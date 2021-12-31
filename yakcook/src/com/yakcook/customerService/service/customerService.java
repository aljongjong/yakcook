package com.yakcook.customerService.service;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.customerService.dao.customerServiceDao;
import com.yakcook.customerService.model.vo.FAQVo;
import com.yakcook.customerService.model.vo.pagingVo;

public class customerService {

	public ArrayList<FAQVo> getFAQList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<FAQVo> tagList = null;
		int totalBoardCount=0;
		if(value == null) {
			totalBoardCount = new customerServiceDao().countFAQAll(conn);
		}else {
			totalBoardCount = new customerServiceDao().countFAQ(conn ,value);
		}
		
		int maxPage = totalBoardCount / pv.getBoardLimit();
		if((totalBoardCount % pv.getBoardLimit())!=0) {
			maxPage++;
		}
		pv.setMaxPage(maxPage);
		int p = pv.getCurrentPage();
		int startNo = ((p *pv.getBoardLimit()) - pv.getBoardLimit()) +1 ;
		int endNo = p * pv.getBoardLimit();
		pv.setStartNo(startNo);
		pv.setEndNo(endNo);
		
		if(value == null) {
			tagList = new customerServiceDao().getFAQAll(conn, pv);
		} else {
			tagList = new customerServiceDao().getFAQ(conn, value, pv);
		}
		close(conn);
		return tagList;
	}

}
