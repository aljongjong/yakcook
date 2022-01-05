package com.yakcook.paymentDetail.dao;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.commit;
import static com.yakcook.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.paymentDetail.model.vo.pagingVo;
import com.yakcook.paymentDetail.model.vo.payProductVo;
import com.yakcook.paymentDetail.model.vo.paymentVo;

public class paymentDetailDao {

	public int countSearchPay(Connection conn, String search, String category) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(ORDER_NO) FROM ORDER_INFO WHERE %s = ?";
		sql = String.format(sql,  category);
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public int countPayAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(ORDER_NO) FROM ORDER_INFO";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}


	public ArrayList<paymentVo> getSearchPay(Connection conn, String search, String category, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , O.* FROM ORDER_INFO O WHERE %s = ?)WHERE RNUM BETWEEN ? AND ?";
		sql = String.format(sql,  category);
		ResultSet rs = null;
		ArrayList<paymentVo> payList = new ArrayList<paymentVo>();
		paymentVo payVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				payVo = new paymentVo();
				payVo.setOrderNo(rs.getInt("ORDER_NO"));
				payVo.setUserId(rs.getString("USER_ID"));
				payVo.setUserName(rs.getString("ORDER_NAME"));
				payVo.setUserPhone(rs.getString("ORDER_PHONE"));
				payVo.setPostNo(rs.getString("POST_NO"));
				payVo.setAddress(rs.getString("ADDRESS"));
				payVo.setDetailAddress(rs.getString("DETAILADDRESS"));
				payVo.setExtraAddress(rs.getString("EXTRAADDRESS"));
				payVo.setMemo(rs.getString("MEMO_OPTION"));
				payVo.setMemoInput(rs.getString("INPUT_MEMO"));
				payVo.setOrderDate(rs.getDate("ORDER_DATE"));
				payVo.setStatus(rs.getString("STATUS"));
				payVo.setPayMethod(rs.getString("PAYMETHOD"));
				payList.add(payVo);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(rs);
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return payList;
	}

	public ArrayList<paymentVo> getPayAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , O.* FROM ORDER_INFO O)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<paymentVo> payList = new ArrayList<paymentVo>();
		paymentVo payVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				payVo = new paymentVo();
				payVo.setOrderNo(rs.getInt("ORDER_NO"));
				payVo.setUserId(rs.getString("USER_ID"));
				payVo.setUserName(rs.getString("ORDER_NAME"));
				payVo.setUserPhone(rs.getString("ORDER_PHONE"));
				payVo.setPostNo(rs.getString("POST_NO"));
				payVo.setAddress(rs.getString("ADDRESS"));
				payVo.setDetailAddress(rs.getString("DETAILADDRESS"));
				payVo.setExtraAddress(rs.getString("EXTRAADDRESS"));
				payVo.setMemo(rs.getString("MEMO_OPTION"));
				payVo.setMemoInput(rs.getString("INPUT_MEMO"));
				payVo.setOrderDate(rs.getDate("ORDER_DATE"));
				payVo.setStatus(rs.getString("STATUS"));
				payVo.setPayMethod(rs.getString("PAYMETHOD"));
				payList.add(payVo);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(rs);
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return payList;
	}

	public ArrayList<payProductVo> getPayProduct(Connection conn, int orderNo) {
		PreparedStatement pstmt = null;
		String sql = "SELECT P.PRODUCT_NAME, P.PRICE, B.QUANTITY "
				+ "FROM BUY B JOIN PRODUCT P ON(B.PRODUCT_NO = P.PRODUCT_NO) WHERE B.ORDER_NO=?";
		ResultSet rs = null;
		ArrayList<payProductVo> productList = new ArrayList<payProductVo>();
		payProductVo productVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productVo  = new payProductVo(rs.getString("PRODUCT_NAME"),rs.getInt("PRICE"), rs.getInt("QUANTITY"));
				productList.add(productVo);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(rs);
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return productList;
	}

	public int statusUpdate(Connection conn, int orderNo, String status) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE ORDER_INFO SET STATUS = ? WHERE ORDER_NO = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, orderNo);
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
