package com.yakcook.customerService.dao;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.commit;
import static com.yakcook.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.customerService.model.vo.FAQVo;
import com.yakcook.customerService.model.vo.pagingVo;

public class customerServiceDao {

	public int countFAQAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(FAQ_NUMBER) FROM FAQ";
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

	public int countFAQ(Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(FAQ_NUMBER) FROM FAQ WHERE CATEGORY = ?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
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

	public ArrayList<FAQVo> getFAQAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , f.* FROM FAQ f)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<FAQVo> faqList = new ArrayList<FAQVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				faqList.add(new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getTimestamp("WRITE_DATE"), rs.getTimestamp("MODIFY_DATE"), rs.getString("DELETE_YN")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return faqList;
	}

	public ArrayList<FAQVo> getFAQ(Connection conn, String value, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , f.* FROM FAQ f WHERE CATEGORY = ?)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<FAQVo> faqList = new ArrayList<FAQVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				faqList.add(new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getTimestamp("WRITE_DATE"), rs.getTimestamp("MODIFY_DATE"), rs.getString("DELETE_YN")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return faqList;
	}

}
