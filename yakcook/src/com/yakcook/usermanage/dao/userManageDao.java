package com.yakcook.usermanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.usermanage.model.vo.pagingVo;
import com.yakcook.usermanage.model.vo.userVo;
import static com.yakcook.common.JDBCTemplate.*;

public class userManageDao {

	public int countUserAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(USER_NUMBER) FROM MEMBER WHERE SECESSION = 'N'";
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

	public int countUser(Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(USER_NUMBER) FROM MEMBER WHERE SECESSION = 'N' AND USER_ID LIKE ?";
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

	public ArrayList<userVo> getUserListAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , m.* FROM MEMBER m WHERE SECESSION = 'N')WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<userVo> userList = new ArrayList<userVo>();
		userVo uv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uv = new userVo();
				uv.setUserNo(rs.getInt("USER_NUMBER"));
				uv.setUserId(rs.getString("USER_ID"));
				uv.setUserName(rs.getString("USER_NAME"));
				uv.setUserEmail(rs.getString("USER_EMAIL"));
				uv.setUserPhone(rs.getString("USER_PHONE"));
				userList.add(uv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return userList;
	}

	public ArrayList<userVo> getUserList(Connection conn, String value, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , m.* FROM MEMBER m WHERE SECESSION = 'N' AND USER_ID LIKE ?)WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<userVo> userList = new ArrayList<userVo>();
		userVo uv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			String values = '%' + value + '%';
			pstmt.setString(1, values);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uv = new userVo();
				uv.setUserNo(rs.getInt("USER_NUMBER"));
				uv.setUserId(rs.getString("USER_ID"));
				uv.setUserName(rs.getString("USER_NAME"));
				uv.setUserEmail(rs.getString("USER_EMAIL"));
				uv.setUserPhone(rs.getString("USER_PHONE"));
				userList.add(uv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return userList;
	}

	public int userDel(Connection conn, int userNum) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET SECESSION='Y' WHERE USER_NUMBER = ?" ;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNum);
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
