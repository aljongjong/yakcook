package com.yakcook.tagManage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.tagManage.model.vo.pagingVo;
import com.yakcook.tagManage.model.vo.tagVo;

import static com.yakcook.common.JDBCTemplate.*;

public class tagManageDao {

	public int tagAdd(Connection conn, String name) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TAG_KEYWORD(TAG_NUMBER, TAG_NAME) VALUES(SEQ_TAG_NO.NEXTVAL, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int dupCheck(Connection conn, String tagName) {
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM TAG_KEYWORD WHERE TAG_NAME = ?";
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tagName);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<tagVo> getTagListAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , t.* FROM TAG_KEYWORD t)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<tagVo> tagList = new ArrayList<tagVo>();
		tagVo tv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tv = new tagVo();
				tv.setTagNo(rs.getInt("TAG_NUMBER"));
				tv.setTagName(rs.getString("TAG_NAME"));
				tagList.add(tv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return tagList;
	}

	public int countTagAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(TAG_NUMBER) FROM TAG_KEYWORD";
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

	public ArrayList<tagVo> getTagList(Connection conn, String value, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , t.* FROM TAG_KEYWORD t WHERE TAG_NAME LIKE ?)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<tagVo> tagList = new ArrayList<tagVo>();
		tagVo tv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			String values = '%' + value + '%';
			pstmt.setString(1, values);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tv = new tagVo();
				tv.setTagNo(rs.getInt("TAG_NUMBER"));
				tv.setTagName(rs.getString("TAG_NAME"));
				tagList.add(tv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return tagList;
	}

	public int countTag(Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(TAG_NUMBER) FROM TAG_KEYWORD WHERE TAG_NAME LIKE ?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			String values = '%' + value + '%';
			pstmt.setString(1, values);
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

	public int tagModify(Connection conn, int tagNum, String tagName) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE TAG_KEYWORD SET TAG_NAME = ? WHERE TAG_NUMBER = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tagName);
			pstmt.setInt(2, tagNum);
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int tagDel(Connection conn, int tagNum) {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM TAG_KEYWORD WHERE TAG_NUMBER = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tagNum);
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

}
