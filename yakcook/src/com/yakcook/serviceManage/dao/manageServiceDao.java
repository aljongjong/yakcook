package com.yakcook.serviceManage.dao;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.commit;
import static com.yakcook.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.serviceManage.model.vo.FAQVo;
import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.model.vo.pagingVo;

public class manageServiceDao {

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
		String sql = "SELECT COUNT(FAQ_NUMBER) FROM FAQ F "
				+ "JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) "
				+ "WHERE C.CATEGORY_NAME = ?";
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
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , F.*, C.CATEGORY_NAME FROM FAQ F JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) )WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<FAQVo> faqList = new ArrayList<FAQVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				faqList.add(new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY_NAME"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getString("DELETE_YN")));
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
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , F.*, C.CATEGORY_NAME FROM FAQ F JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) WHERE CATEGORY_NAME = ?)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<FAQVo> faqList = new ArrayList<FAQVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				faqList.add(new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY_NAME"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getString("DELETE_YN")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return faqList;
	}

	public int countNotice(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(NOTICE_NUMBER) FROM NOTICE";
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

	public ArrayList<noticeVo> getNotice(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , N.* FROM NOTICE N)WHERE RNUM BETWEEN ? AND ?"
				+ "ORDER BY WRITE_DATE DESC";
		ResultSet rs = null;
		ArrayList<noticeVo> noticeList = new ArrayList<noticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeList.add(new noticeVo(rs.getInt("NOTICE_NUMBER"), rs.getInt("MANAGER_NUMBER"),rs.getString("NOTICE_TITLE")
						, rs.getString("NOTICE_CONTENT"), rs.getTimestamp("WRITE_DATE")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return noticeList;
	}

	public noticeVo getNoticeDetail(Connection conn, int noticeNumber) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM NOTICE WHERE NOTICE_NUMBER = ?";
		ResultSet rs = null;
		noticeVo NV = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NV = new noticeVo(rs.getInt("NOTICE_NUMBER"), rs.getInt("MANAGER_NUMBER"),rs.getString("NOTICE_TITLE")
						, rs.getString("NOTICE_CONTENT"), rs.getTimestamp("WRITE_DATE"));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return NV;
	}

}
