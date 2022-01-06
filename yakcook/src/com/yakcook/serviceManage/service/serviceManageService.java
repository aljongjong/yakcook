package com.yakcook.serviceManage.service;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.paymentDetail.model.vo.paymentVo;
import com.yakcook.serviceManage.dao.manageServiceDao;
import com.yakcook.serviceManage.model.vo.FAQVo;
import com.yakcook.serviceManage.model.vo.QNAVo;
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

	public int addFAQ(FAQVo fv) {
		Connection conn = getConnection();
		int categoryNo = new manageServiceDao().getCategoryNumber(conn, fv);
		int result = new manageServiceDao().addFAQ(conn, fv, categoryNo);
		close(conn);
		return result;
	}

	public int FAQDel(int faqNo) {
		Connection conn = getConnection();
		int result = new manageServiceDao().FAQdel(conn, faqNo);
		close(conn);
		return result;
	}

	public FAQVo getFAQ(int fAQNum) {
		Connection conn = getConnection();
		FAQVo fv = new manageServiceDao().getFAQSelected(conn, fAQNum);
		close(conn);
		return fv;
	}

	public int modiFAQ(FAQVo fv) {
		Connection conn = getConnection();
		int categoryNo = new manageServiceDao().getCategoryNumber(conn, fv);
		int result = new manageServiceDao().modiFAQ(conn, fv, categoryNo);
		close(conn);
		return result;
	}

	public int addNotice(noticeVo nv) {
		Connection conn = getConnection();
		int result = new manageServiceDao().addNotice(conn, nv);
		close(conn);
		return result;
	}

	public int noticeDel(int noticeNo) {
		Connection conn = getConnection();
		int result = new manageServiceDao().noticeDel(conn, noticeNo);
		close(conn);
		return result;
	}

	public int modiNotice(noticeVo NV) {
		Connection conn = getConnection();
		int result = new manageServiceDao().modiNotice(conn, NV);
		close(conn);
		return result;
	}
	
	public ArrayList<QNAVo> getQNAList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<QNAVo> QNAList = null;
		int totalBoardCount=0;
		if(value == null) {
			totalBoardCount = new manageServiceDao().countQNAAll(conn);
		}else {
			totalBoardCount = new manageServiceDao().countQNA(conn ,value);
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
			QNAList = new manageServiceDao().getQNAAll(conn, pv);
		} else {
			QNAList = new manageServiceDao().getQNA(conn, value, pv);
		}
		close(conn);
		return QNAList;
	}

	public QNAVo selectQNA(int qnaNo) {
		Connection conn = getConnection();
		QNAVo qv= new manageServiceDao().selectQNA(conn,qnaNo);
		close(conn);
		return qv;
	}

	public int answerQNA(QNAVo qv) {
		Connection conn = getConnection();
		int result = new manageServiceDao().answerQNA(conn, qv);
		close(conn);
		return result;
	}

	public ArrayList<QNAVo> getAnsweredQNAList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<QNAVo> QNAList = null;
		int totalBoardCount=0;
		if(value == null) {
			totalBoardCount = new manageServiceDao().countAnswerdQNAAll(conn);
		}else {
			totalBoardCount = new manageServiceDao().countAnswerdQNA(conn ,value);
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
			QNAList = new manageServiceDao().getAnswerdQNAAll(conn, pv);
		} else {
			QNAList = new manageServiceDao().getAnswerdQNA(conn, value, pv);
		}
		close(conn);
		return QNAList;
	}

	public QNAVo selectAnswerQNA(int qnaNo) {
		Connection conn = getConnection();
		QNAVo qv= new manageServiceDao().selectAnswerQNA(conn,qnaNo);
		close(conn);
		return qv;
	}

	

}
