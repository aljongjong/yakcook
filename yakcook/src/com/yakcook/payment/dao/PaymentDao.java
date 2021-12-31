package com.yakcook.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;
import com.yakcook.payment.vo.PaymentVo;


public class PaymentDao {
		

	//입력한 주문정보(주문번호, 이름 , 휴대폰 , 주소 , 배송메세지)를 DB에 저장하는 메소드
	public int insertOrder(Connection conn, PaymentVo p) {
		
		String sql = "INSERT INTO ORDER_INFO(ORDER_NO , ORDER_NAME, ORDER_PHONE , POSTCODE , ADDRESS ,DETAILADDRESS"
				+ ",EXTRAADDRESS,DELIVERY_MEMO)"
				+"VALUES(SEQ_ORDER.NEXTVAL, ? , ? , ? , ? ,  ? ,  ? ,  ? )";
		PreparedStatement pstmt = null;
	
		
		int rs = 0 ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getOrder());
			pstmt.setString(2, p.getPhone1()+p.getPhone2()+p.getPhone3());
			pstmt.setString(3, p.getPostcode());
			pstmt.setString(4, p.getAddress());
			pstmt.setString(5, p.getDetailaddress());
			pstmt.setString(6, p.getExtra());
			pstmt.setString(7, p.getMemo_option() + p.getInput_memo());
			rs = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			commit(conn);
			
		}
		return rs;
	}
	
		
}
