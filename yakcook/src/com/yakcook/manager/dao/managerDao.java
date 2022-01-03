package com.yakcook.manager.dao;

import static com.yakcook.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yakcook.manager.model.vo.managerVo;

public class managerDao {

	public int managerCheck(Connection conn, managerVo mv) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(MANAGER_NUMBER) FROM MANAGER WHERE MANAGER_ID = ?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getManagerId());
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

	public managerVo getManager(Connection conn, managerVo mv) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MANAGER WHERE MANAGER_ID = ?";
		managerVo managerVo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getManagerId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				managerVo = new managerVo(rs.getInt("MANAGER_NUMBER"), rs.getString("MANAGER_ID"), 
						rs.getString("MANAGER_PWD"), rs.getInt("MANAGER_LEVEL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return managerVo;
	}

}
