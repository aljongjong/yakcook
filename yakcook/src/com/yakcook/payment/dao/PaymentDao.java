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
		
		String sql = "INSERT INTO ORDER_INFO(ORDER_NO , USER_ID , ORDER_NAME, ORDER_PHONE , POST_NO , ADDRESS ,DETAILADDRESS,EXTRAADDRESS,MEMO_OPTION,INPUT_MEMO,ORDER_DATE , COMPLEATE) VALUES(SEQ_ORDER.NEXTVAL, ? ,  ? , ? , ? , ? ,  ? ,  ? ,  ? , ? ,SYSDATE , ? )";
		PreparedStatement pstmt = null;
	
		
		int rs = 0 ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getUserId().trim());
			pstmt.setString(2, p.getOrder());
			pstmt.setString(3, p.getPhone1()+p.getPhone2()+p.getPhone3());
			pstmt.setString(4, p.getPostcode());
			pstmt.setString(5, p.getAddress());
			pstmt.setString(6, p.getDetailaddress());
			pstmt.setString(7, p.getExtra());
			pstmt.setString(8, p.getMemo_option());
			pstmt.setString(9, p.getInput_memo());
			pstmt.setString(10, "N");
			rs = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			commit(conn);
			close(conn);
			
		}
		return rs;
	}

	public int selectedOrder(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql ="(SELECT ORDER_NO FROM(SELECT * FROM ORDER_INFO ORDER BY ORDER_NO DESC)WHERE ROWNUM =1)";
		try {
			pstmt =	conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("ORDER_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
		}
		
		return result;
	}
	
	
		
}
