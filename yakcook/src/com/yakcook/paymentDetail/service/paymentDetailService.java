package com.yakcook.paymentDetail.service;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.paymentDetail.dao.paymentDetailDao;
import com.yakcook.paymentDetail.model.vo.pagingVo;
import com.yakcook.paymentDetail.model.vo.payProductVo;
import com.yakcook.paymentDetail.model.vo.paymentVo;

public class paymentDetailService {

	public ArrayList<paymentVo> getPayList(String category, String search,
			pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<paymentVo> paymentVo = null;
		int totalBoardCount=0;
		if((search != null)){
			totalBoardCount = new paymentDetailDao().countSearchPay(conn ,search, category);
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
		
		if((search != null)){
			paymentVo = new paymentDetailDao().getSearchPay(conn, search, category, pv);
		}else {
			paymentVo = new paymentDetailDao().getPayAll(conn, pv);
		}
		
		for(paymentVo payVo : paymentVo) {
			ArrayList<payProductVo> ppv = new paymentDetailDao().getPayProduct(conn, payVo.getOrderNo());
			payVo.setPayProduct(ppv);
		}
		close(conn);
		return paymentVo;
	}

	public int statusUpdate(int orderNo, String status) {
		Connection conn = getConnection();
		int result = new paymentDetailDao().statusUpdate(conn, orderNo, status);
		close(conn);
		return result;
	}
}
