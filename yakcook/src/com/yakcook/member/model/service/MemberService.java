package com.yakcook.member.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;

import com.yakcook.member.model.dao.MemberDao;
import com.yakcook.member.model.vo.MemberVo;

public class MemberService {
	private String encrypt(String pwd) {
		StringBuilder sb = new StringBuilder();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(pwd.getBytes());
			byte[] digest = md.digest();
			for(byte b : digest) {
				sb.append(String.format("%02x", b));
			}
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}

	public int join(MemberVo m) {
		m.setPwd(encrypt(m.getPwd()));
		//DB Connection 가져오기
		Connection conn = getConnection();
		//쿼리 날리기 (insert 쿼리)
		int result = 0;
		try {
			result = insertMember(conn, m);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);

		}
		
		// 결과 반환해주기
		return result;
		
	}
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		// dao 불러서 쿼리 실행
		// dao한테 쿼리 실행 결과 받아서 비지니스 로직 처리
		return new MemberDao().insertMember(conn, m);
	}
	
	public MemberVo login(MemberVo m) {
		// 커넥션 가져오기
		Connection conn = getConnection();
		// id 가지고 그 아이디의 비번 조회
		MemberVo selectedMember = selectMember(conn,m);
		close(conn);
		if(selectedMember.getPwd() .equals(encrypt(m.getPwd()))) {
			return selectedMember;
		}else {
			return null;
		}
	}
	
	public MemberVo selectMember(Connection conn, MemberVo m) {
		return new MemberDao().selectMember(conn, m);
	}
	public List<MemberVo> selectMemberAll(Connection conn, String currentPag, int startNo, int endNo) {
		return new MemberDao().selectMemberAll(conn, startNo, endNo);
	}
	public List<MemberVo> search(String type, String value, String currentPage) {
		Connection conn = getConnection();
		int totalBoardCount = countMemberAll(conn);
		int pageLimit = 5;
		int boardLimit = 10;
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		
		int p = Integer.parseInt(currentPage);
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<MemberVo> memberList;
		if(type == null || value == null) {
			memberList = selectMemberAll(conn,currentPage, startNo, endNo);
		}else {
			memberList = selectMember(conn, type, value);
		}
		close(conn);
		
		return memberList;
	}
	private int countMemberAll(Connection conn) {
		return new MemberDao().countMemberAll(conn);
	}

	private List<MemberVo> selectMember(Connection conn, String type, String value) {
		return new MemberDao().selectMemberBySearch(conn, type, value);
	}
	public int dupCheck(String id) {
		Connection conn = getConnection();
		int result = selectMemberById(conn,id);
		close(conn);
		return result;
	}
	private int selectMemberById(Connection conn, String id) {
		return new MemberDao().selectMemberById(conn, id);
	}
	
	public MemberVo myInfotmation(String loginUserId) {
		Connection conn = getConnection();
		return new MemberDao().myInfotmation(conn,loginUserId);
	}

	
	 public int deleteMember(String userPwd, String userId) {
		 Connection conn = getConnection();
		 MemberDao mDao = new MemberDao();
		 int result = mDao.deleteMember(conn, encrypt(userPwd), userId);
	 
		 if(result > 0) {
			 commit(conn); 
		 }else {
			 rollback(conn); 
		} 
		 return result; 
	 }

	public String findId(String name, String email) {
		 Connection conn = getConnection();
		 MemberDao mDao = new MemberDao();
		 String id = mDao.findId(conn,name, email);
		 close(conn);
		 return id;
	}
	
	public int findPwd(String name, String id, String email) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		int result = mDao.findPwd(conn, name, id, email);
		close(conn);
		return result;
	}

	public int myPwdCheck(String userId, String oldPwd) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		int result = mDao.myPwdCheck(conn, userId, encrypt(oldPwd));
		close(conn);
		return result;
	}

	public int myPwdUpdate(String userId, String newPwd) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		int result = mDao.myPwdUpdate(conn, userId, encrypt(newPwd));
		close(conn);
		if(result > 0) {
			 commit(conn); 
		 }else {
			 rollback(conn); 
		} 
		return result;
	}

	public int myfindPwdUpdate(String id, String pwd) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		int result = mDao.myfindPwdUpdate(conn, id, encrypt(pwd));
		close(conn);
		if(result > 0) {
			 commit(conn); 
		 }else {
			 rollback(conn); 
		} 
		return result;
	}	 
}
