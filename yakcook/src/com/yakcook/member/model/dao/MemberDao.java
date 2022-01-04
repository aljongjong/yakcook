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
import com.yakcook.member.model.vo.MemberQnAVo;
import com.yakcook.member.model.vo.MemberVo;
import com.yakcook.review.vo.ReviewListVo;

public class MemberDao {
   public int insertMember(Connection conn, MemberVo m) throws SQLException {
      // 쿼리 날리기?
      String sql = "INSERT INTO MEMBER(USER_NO, USER_ID, USER_PWD, USER_NAME, USER_PHONE, USER_EMAIL, USER_JOIN_DATE, USER_MODIFY_DATE) "
            + "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE, SYSDATE)";
      PreparedStatement pstmt = null;
      int result = 0;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, m.getUser_id());
         pstmt.setString(2, m.getUser_pwd());
         pstmt.setString(3, m.getUser_name());
         pstmt.setString(4, m.getUser_phone());
         pstmt.setString(5, m.getUser_email());
         result = pstmt.executeUpdate();
      } finally {
         JDBCTemplate.close(pstmt);
      }
      return result;
   }

   public MemberVo selectMember(Connection conn, MemberVo m) {
      String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND QUIT_YN ='N' "; 
      PreparedStatement pstmt = null;
      MemberVo selectedMember = null;
      ResultSet rs = null;
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, m.getUser_id());
         //결과를 가지고 와야하기 때문에 쿼리이다.
         rs = pstmt.executeQuery();
         if(rs.next()) {
            int userNo = rs.getInt("USER_NO");
            String id = rs.getString("USER_ID");
            String pwd = rs.getString("USER_PWD");
            String name = rs.getString("USER_NAME");
            String phone = rs.getString("USER_PHONE");
            String eamil = rs.getString("USER_EMAIL");

            selectedMember = new MemberVo();
            selectedMember.setUser_no(userNo);
            selectedMember.setUser_id(id);
            selectedMember.setUser_pwd(pwd);
            selectedMember.setUser_name(name);
            selectedMember.setUser_phone(phone);
            selectedMember.setUser_email(eamil);
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(pstmt);
      }
      return selectedMember;
   }

   public int selectMemberById(Connection conn, String id) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int result = 0;
      String sql = "SELECT COUNT(*) FROM MEMBER WHERE USER_ID = ?";
      
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


   public int countMemberAll(Connection conn) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "SELECT COUNT(USER_NO) FROM MEMBER WHERE QUIT_YN = 'N'";
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
      String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";
      MemberVo m = null;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, loginUserId);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            m = new MemberVo();
            m.setUser_no(rs.getInt("USER_NO"));
            m.setUser_id(rs.getString("USER_ID"));
            m.setUser_pwd(rs.getString("USER_PWD"));
            m.setUser_name(rs.getString("USER_NAME"));
            m.setUser_email(rs.getString("USER_EMAIL"));
            m.setUser_phone(rs.getString("USER_PHONE"));
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
     
    String query = "UPDATE MEMBER SET QUIT_YN = 'Y' WHERE USER_PWD = ? AND USER_ID = ?";
     
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
      String query = "SELECT USER_ID FROM MEMBER WHERE USER_NAME = ? AND USER_EMAIL = ?";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, name);
         pstmt.setString(2, email);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            id = rs.getString("USER_ID");
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
      String query = "SELECT * FROM MEMBER WHERE USER_NAME = ? AND USER_ID = ? AND USER_EMAIL = ?";
      
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
      String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
      
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
      String query = "UPDATE MEMBER SET USER_PWD = ? WHERE USER_ID = ?";
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
      String query = "UPDATE MEMBER SET USER_PWD = ? WHERE USER_ID = ?";
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

   public int insertQna(Connection conn, MemberQnAVo q) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "INSERT INTO QNA (QNA_NO, QNA_TITLE, QNA_CONTENT, QNA_DATE, USER_ID) "
            + "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, SYSDATE, ?)";
      int result = 0;
         try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, q.getQna_title());
            pstmt.setString(2, q.getQna_content());
            pstmt.setString(3, q.getUser_id());
            result = pstmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         }finally {
            JDBCTemplate.close(pstmt);
         }
      return result;
   }

   public List<MemberQnAVo> detailQnaView(Connection conn, int no) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      MemberQnAVo q = null;
      String sql = "SELECT * FROM QnA WHERE QNA_NO = ?";
      List<MemberQnAVo> QnAListView = new ArrayList<MemberQnAVo>();
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, no);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            int qna_no = rs.getInt("QNA_NO");
            String qna_title = rs.getString("QNA_TITLE");
            String qna_content = rs.getString("QNA_CONTENT");
            String user_id = rs.getString("USER_ID");
            
            q = new MemberQnAVo();
            q.setQna_no(qna_no);
            q.setQna_title(qna_title);
            q.setQna_content(qna_content);
            q.setUser_id(user_id);            
            QnAListView.add(q);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(conn);
         close(pstmt);
         close(rs);
      }
      return QnAListView;
   }

   public int deleteQnA(Connection conn, int no, String id) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = "UPDATE QnA SET QUIT_YN = 'Y' WHERE QNA_NO = ? AND USER_ID = ?";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, no);
         pstmt.setString(2, id);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result;
   }

   public static List<MemberQnAVo> qnaListAll(Connection conn, String loginUserId) {
      PreparedStatement pstmt = null;
         ResultSet rs = null;
         String sql = "SELECT * FROM QnA WHERE USER_ID = ? AND QUIT_YN = 'N'";
         List<MemberQnAVo> qnaList = new ArrayList<MemberQnAVo>();
         
         // 쿼리 날리기
         try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,loginUserId);
            rs = pstmt.executeQuery();
            // 데이터 꺼내오기
            while(rs.next()) {
               int qna_no = rs.getInt("QNA_NO");
               String user_id = rs.getString("USER_ID");
               String qna_title = rs.getString("QNA_TITLE"); 
               String qna_content = rs.getString("QNA_CONTENT");
               
               MemberQnAVo q = new MemberQnAVo();
               q.setQna_no(qna_no);
               q.setUser_id(user_id);
               q.setQna_title(qna_title);
               q.setQna_content(qna_content);

               qnaList.add(q);
            }

         }catch (SQLException e) {
            e.printStackTrace();
         }

      return qnaList;
   }

   public static List<ReviewListVo> reviewListAll(Connection conn, String loginUserId) {
       PreparedStatement pstmt = null;
         ResultSet rs = null;
         String query = "SELECT E.REVIEW_NO, E.REVIEW_TITLE, E.REVIEW_CONTENTS, E.REVIEW_LIKE, E.REVIEW_DATE, "
         		+ "E.REVIEW_VIEWS, I.REVIEW_IMG_SERVERFILE1 FROM REVIEW E, REVIEW_IMG I "
         		+ "WHERE E.REVIEW_NO = I.REVIEW_NO AND USER_ID = ? AND REVIEW_DELETE = 'N'";
         List<ReviewListVo> reviewList = new ArrayList<ReviewListVo>();
         
         // 쿼리 날리기
         try{
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,loginUserId);
            rs = pstmt.executeQuery();
            // 데이터 꺼내오기
            while(rs.next()) {
               int reviewNo = rs.getInt("REVIEW_NO");
               String reviewTitle = rs.getString("REVIEW_TITLE");
               String reviewContents = rs.getString("REVIEW_CONTENTS");
               int reviewLike = rs.getInt("REVIEW_LIKE");
               int reviewViews = rs.getInt("REVIEW_VIEWS");
               String reviewImg = rs.getString("REVIEW_IMG_SERVERFILE1");
               Timestamp reviewDate = rs.getTimestamp("REVIEW_DATE");
                       
               ReviewListVo r = new ReviewListVo();
               r.setReviewNo(reviewNo);
               r.setReviewTitle(reviewTitle);
               r.setReviewContents(reviewContents);
               r.setReviewLike(reviewLike);
               r.setReviewViews(reviewViews);
               r.setReviewImg(reviewImg);
               r.setReviewDate(reviewDate);

               reviewList.add(r);
            }

         }catch (SQLException e) {
            e.printStackTrace();
         }finally {
         close(pstmt);
         close(rs);
      }

      return reviewList;
   }
    
}