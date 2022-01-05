package com.yakcook.paymentDetail.service;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.paymentDetail.dao.paymentDetailDao;
import com.yakcook.paymentDetail.model.vo.paymentVo;

public class paymentDetailService {

	public ArrayList<paymentVo> getPayList(String category, String search,
			String status, com.yakcook.paymentDetail.model.vo.pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<paymentVo> paymentVo = null;
		int totalBoardCount=0;
		if(category != null) {
			totalBoardCount = new paymentDetailDao().countCategoryPay(conn ,category);
		}else if((search != null)){
			totalBoardCount = new paymentDetailDao().countSearchPay(conn ,search, status);
		}else {
			totalBoardCount = new paymentDetailDao().countPayAll(conn);
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
		
		if(category != null) {
			paymentVo = new paymentDetailDao().getCategoryPay(conn, category, pv);
		}else if((search != null)){
			paymentVo = new paymentDetailDao().getSearchPay(conn, search, status, pv);
		}else {
			paymentVo = new paymentDetailDao().getPayAll(conn, pv);
		}
		
		close(conn);
		return paymentVo;
	}
}
