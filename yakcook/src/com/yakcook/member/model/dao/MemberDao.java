package com.yakcook.member.model.dao;

import static com.yakcook.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.yakcook.common.JDBCTemplate;
import com.yakcook.member.model.vo.MemberVo;

public class MemberDao {
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		// 쿼리 날리기?
		String sql = "INSERT INTO MEMBER(MEMBER_NO, ID, PWD, NAME, PHONE, EMAIL, DETAIL, MODIFY_DATE) "
				+ "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setInt(6, -1);
			result = pstmt.executeUpdate();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MemberVo selectMember(Connection conn, MemberVo m) {
		
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND QUIT_YN ='N' "; 
		
		PreparedStatement pstmt = null;
		MemberVo selectedMember = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());
			//결과를 가지고 와야하기 때문에 쿼리이다.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");

				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setOpenYn(openYn);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return selectedMember;
	}

	public List<MemberVo> selectMemberAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * "
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM , m.* FROM MEMBER m WHERE QUIT_YN = 'N' AND OPEN_YN = 'Y' "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> list = new ArrayList<MemberVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			MemberVo selectedMember = null;
			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				//String quitYn = rs.getString("QUIT_YN");

				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setOpenYn(openYn);
				
				list.add(selectedMember);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectMemberById(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			result= rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public List<MemberVo> selectMemberBySearch(Connection conn, String type, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM MEMBER WHERE %s LIKE ?";
		sql = String.format(sql, type);
		try {
		    pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+value+"%");
			MemberVo selectedMember = null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo m = new MemberVo();
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setOpenYn(openYn);
				
				list.add(selectedMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countMemberAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(MEMBER_NO) FROM MEMBER WHERE QUIT_YN = 'N' AND OPEN_YN = 'Y'";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			};
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public MemberVo myInfotmation(Connection conn, String loginUserId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		MemberVo m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginUserId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new MemberVo();
				m.setMemberNo(rs.getInt("MEMBER_NO"));
				m.setId(rs.getString("ID"));
				m.setPwd(rs.getString("PWD"));
				m.setName(rs.getString("NAME"));
				m.setDetail(rs.getInt("DETAIL"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return m;
	}

	
	 public int deleteMember(Connection conn, String userPwd, String userId) { 
		 PreparedStatement pstmt = null; 
		 int result = 0;
		 String userid = userId;
	  
	 String query = "UPDATE MEMBER SET QUIT_YN = 'Y' WHERE PWD = ? AND ID = ?";
	  
	 try { 
		 // 화면에 있는 아이디랑 찾는 아이디랑 비교!
		 pstmt= conn.prepareStatement(query); 
		 pstmt.setString(1, userPwd);
		 pstmt.setString(2, userid);
		 result = pstmt.executeUpdate(); 
	} catch (SQLException e) {
		e.printStackTrace(); 
	 }finally {
		 close(pstmt); 
	 }
	 	return result;
}

	public String findId(Connection conn, String name, String email) {
		String id = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT ID FROM MEMBER WHERE NAME = ? AND EMAIL = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); 
		}
		return id;
	}
	public int findPwd(Connection conn, String name, String id, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = "SELECT * FROM MEMBER WHERE NAME = ? AND ID = ? AND EMAIL = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public int myPwdCheck(Connection conn, String userId, String oldPwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, oldPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public int myPwdUpdate(Connection conn, String userId, String newPwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = "UPDATE MEMBER SET PWD = ? WHERE ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public int myfindPwdUpdate(Connection conn, String id, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = "UPDATE MEMBER SET PWD = ? WHERE ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}

		return result;
	}
	 
}