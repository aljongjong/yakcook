package com.yakcook.paymentDetail.dao;

import static com.yakcook.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.paymentDetail.model.vo.pagingVo;
import com.yakcook.paymentDetail.model.vo.paymentVo;

public class paymentDetailDao {

	public int countCategoryPay(Connection conn, String category) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(ORDER_NO) FROM ORDER_INFO WHERE STATUS = ?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
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

	public int countSearchPay(Connection conn, String search, String status) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(ORDER_NO) FROM ORDER_INFO WHERE STATUS = ?";
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
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<paymentVo> getCategoryPay(Connection conn, String category, pagingVo pv) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<paymentVo> getSearchPay(Connection conn, String search, String status, pagingVo pv) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<paymentVo> getPayAll(Connection conn, pagingVo pv) {
		// TODO Auto-generated method stub
		return null;
	}
}
