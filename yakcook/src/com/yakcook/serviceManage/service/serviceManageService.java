package com.yakcook.serviceManage.service;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.serviceManage.dao.manageServiceDao;
import com.yakcook.serviceManage.model.vo.FAQVo;
import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.model.vo.pagingVo;

public class serviceManageService {

	public ArrayList<FAQVo> getFAQList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<FAQVo> FAQList = null;
		int totalBoardCount=0;
		if(value == null) {
			totalBoardCount = new manageServiceDao().countFAQAll(conn);
		}else {
			totalBoardCount = new manageServiceDao().countFAQ(conn ,value);
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
			FAQList = new manageServiceDao().getFAQAll(conn, pv);
		} else {
			FAQList = new manageServiceDao().getFAQ(conn, value, pv);
		}
		close(conn);
		return FAQList;
	}

	public ArrayList<noticeVo> getNoticeList(pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<noticeVo> noticeList = null;
		int totalBoardCount=0;
		totalBoardCount = new manageServiceDao().countNotice(conn);

		
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
		
		noticeList = new manageServiceDao().getNotice(conn, pv);
		close(conn);
		return noticeList;
	}

	public noticeVo getNoticeDetail(int noticeNumber) {
		Connection conn = getConnection();
		noticeVo NV = null;
		
		NV = new manageServiceDao().getNoticeDetail(conn, noticeNumber);
		close(conn);
		return NV;
	}

}
