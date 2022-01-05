package com.yakcook.payment.service;
import static com.yakcook.common.JDBCTemplate.*;
import java.sql.Connection;

import static com.yakcook.common.JDBCTemplate.*;
import com.yakcook.payment.dao.PaymentDao;
import com.yakcook.payment.vo.PaymentVo;

public class PaymentService {
	//입력한 주문정보를 DB에 넣는 서비스메소드
	public int insertOrder(PaymentVo p) {
		Connection conn = getConnection();
		return new PaymentDao().insertOrder(conn,p);
	}



	public int paymentComplate() {
		Connection conn = getConnection();
		return new PaymentDao().updateComplate(conn);
	}
	
	
	
}
	
