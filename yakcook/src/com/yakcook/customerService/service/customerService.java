package com.yakcook.customerService.service;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.customerService.dao.customerServiceDao;
import com.yakcook.customerService.model.vo.FAQVo;
import com.yakcook.customerService.model.vo.noticeVo;
import com.yakcook.customerService.model.vo.pagingVo;
import com.yakcook.serviceManage.model.vo.QNAVo;

public class customerService {

	public ArrayList<FAQVo> getFAQList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<FAQVo> FAQList = null;
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
			FAQList = new customerServiceDao().getFAQAll(conn, pv);
		} else {
			FAQList = new customerServiceDao().getFAQ(conn, value, pv);
		}
		close(conn);
		return FAQList;
	}

	public ArrayList<noticeVo> getNoticeList(pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<noticeVo> noticeList = null;
		int totalBoardCount=0;
		totalBoardCount = new customerServiceDao().countNotice(conn);

		
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
		
		noticeList = new customerServiceDao().getNotice(conn, pv);
		close(conn);
		return noticeList;
	}

	public noticeVo getNoticeDetail(int noticeNumber) {
		Connection conn = getConnection();
		noticeVo NV = null;
		NV = new customerServiceDao().getNoticeDetail(conn, noticeNumber);
		close(conn);
		return NV;
	}

	

}
