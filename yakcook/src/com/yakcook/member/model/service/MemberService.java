package com.yakcook.member.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;

import com.yakcook.member.model.dao.MemberDao;
import com.yakcook.member.model.vo.MemberQnAVo;
import com.yakcook.member.model.vo.MemberVo;
import com.yakcook.review.vo.ReviewListVo;

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
		      m.setUser_pwd(encrypt(m.getUser_pwd()));
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
		      if(selectedMember.getUser_pwd() .equals(encrypt(m.getUser_pwd()))) {
		         return selectedMember;
		      }else {
		         return null;
		      }
		   }
		   
		   public MemberVo selectMember(Connection conn, MemberVo m) {
		      return new MemberDao().selectMember(conn, m);
		   }

		   private int countMemberAll(Connection conn) {
			      return new MemberDao().countMemberAll(conn);
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
			       //MemberDao mDao = new MemberDao();
			       int result = new MemberDao().deleteMember(conn, encrypt(userPwd), userId);
			    
			       if(result > 0) {
			          commit(conn); 
			       }else {
			          rollback(conn); 
			      } 
			       return result; 
			    }

			    public String findId(String name, String email) {
			        Connection conn = getConnection();
			        //MemberDao mDao = new MemberDao();
			        String id = new MemberDao().findId(conn,name, email);
			        close(conn);
			        return id;
			    }
			    
			    public int findPwd(String name, String id, String email) {
			       Connection conn = getConnection();
			       //MemberDao mDao = new MemberDao();
			       int result = new MemberDao().findPwd(conn, name, id, email);
			       close(conn);
			       return result;
			    }

			    public int myPwdCheck(String userId, String oldPwd) {
			        Connection conn = getConnection();
			        //MemberDao mDao = new MemberDao();
			        int result = new MemberDao().myPwdCheck(conn, userId, encrypt(oldPwd));
			        close(conn);
			        return result;
			     }

			    public int myPwdUpdate(String userId, String newPwd) {
			        Connection conn = getConnection();
			        //MemberDao mDao = new MemberDao();
			        int result = new MemberDao().myPwdUpdate(conn, userId, encrypt(newPwd));
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
			       //MemberDao mDao = new MemberDao();
			       int result = new MemberDao().myfindPwdUpdate(conn, id, encrypt(pwd));
			       close(conn);
			       if(result > 0) {
			           commit(conn); 
			        }else {
			           rollback(conn); 
			       } 
			       return result;
			    } 
			    

public int qnawriter(MemberQnAVo q) {
	Connection conn = getConnection();
	int result = 0;
	try {
		result = insertQna(conn,q);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
	}catch (SQLException e) {
        rollback(conn);
        e.printStackTrace();
     }finally {
        close(conn);
     }
	return result;
}

private int insertQna(Connection conn, MemberQnAVo q)  throws SQLException {
	return new MemberDao().insertQna(conn,q);
}

public List<MemberQnAVo> qnaDatailAll(String qnano) {
	int no = Integer.parseInt(qnano);
	Connection conn = getConnection();
	return new MemberDao().detailQnaView(conn,no);
}

public int deleteQnA(String qnano, String id) {
	int no = Integer.parseInt(qnano); 
	Connection conn = getConnection();
	//MemberDao mDao = new MemberDao();
	int result = new MemberDao().deleteQnA(conn, no, id);
	
	if(result > 0) {
		commit(conn);
	}else {
		rollback(conn);
	}
	return result;
}

public List<MemberQnAVo> qnaListAll(String loginUserId) {
	Connection conn = getConnection();
	return MemberDao.qnaListAll(conn, loginUserId);
}

public List<ReviewListVo> reviewListAll(String loginUserId) {
	Connection conn = getConnection();
	return MemberDao.reviewListAll(conn, loginUserId);
}

public MemberQnAVo myqnaList(String qna_no) {
    Connection conn = getConnection();
    return new MemberDao().myqnaList(conn,qna_no);
}

public int myqnaUpdate(String userId, String qnatitle, String qnacontent, int intqnano) {
	Connection conn =  getConnection();
	//MemberDao mDao = new MemberDao();
	int result = new MemberDao().myqnaUpdate(conn, userId, qnatitle, qnacontent, intqnano);
	close(conn);
	if(result > 0) {
		commit(conn);
	}else {
		rollback(conn);
	}
	return result;
}

public MemberVo myinfoList(String id) {
	Connection conn = getConnection();
	return new MemberDao().myinfoList(conn, id);
}

public int myinfoUpdate(String id, String email, String phone) {
	Connection conn = getConnection();
	
	int result = new MemberDao().myinfoUpdate(conn, id, email, phone);
	close(conn);
	if(result > 0) {
		commit(conn);
	}else {
		rollback(conn);
	}
	return result;
}

public int dupCheckEmail(String email) {
	Connection conn = getConnection();
	int result = selectMemberByEmail(conn, email);
	close(conn);
	return result;
}

private int selectMemberByEmail(Connection conn, String email) {
	 return new MemberDao().selectMemberByEmail(conn, email);
}
			 }