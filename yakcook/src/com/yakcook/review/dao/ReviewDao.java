package com.yakcook.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;

import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewListVo;



public class ReviewDao {

	// 작성한 리뷰의 제목, 내용 , 작성자 ,등을 데이터베이스에 넣는메소드
	public int writerReview(Connection conn, ReviewListVo r) {
		String sql = "INSERT INTO REVIEW (REVIEW_NO , REVIEW_TITLE , REVIEW_CONTENTS , REVIEW_DATE, REVIEW_LIKE ,REVIEW_VIEWS, "
				+ "REVIEW_DECLARATION,REVIEW_DELETE,USER_ID)"
				+ "VALUES (SEQ_REVIEW.NEXTVAL, ? , ? , SYSDATE , ? , ? , ? , ?,?)";
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContents());
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setString(6, "N");
			pstmt.setString(7, r.getUserId());

			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(pstmt);
			close(conn);
		}
		return rs;

	}

	// 리뷰의 이미지들을 테이블에 저장하는 메소드
	public int imgReview(Connection conn, ReviewImgVo i) {
		String sql = "INSERT INTO REVIEW_IMG (REVIEW_IMG_NO, REVIEW_NO, REVIEW_IMG_SERVERFILE1, REVIEW_IMG_SERVERFILE2, REVIEW_IMG_SERVERFILE3,"
				+ "REVIEW_IMG_DATE, REVIEW_IMG_DELETE) VALUES (SEQ_REVIEW_IMG_NO.NEXTVAL,(SELECT REVIEW_NO FROM(SELECT * FROM REVIEW ORDER BY REVIEW_NO DESC)WHERE ROWNUM =1)"
				+ ", ? , ? , ? , SYSDATE, ?)";
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getImgServerFile1());
			pstmt.setString(2, i.getImgServerFile2());
			pstmt.setString(3, i.getImgServerFile3());
			pstmt.setString(4, i.getImgDelete());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}
		return rs;
	}

	// 리뷰목록의 페이징처리를 위한 메소드 : 리뷰목록을 전부 뽑아오는 메소드
	public List<ReviewListVo> getReviewList(Connection conn, int startNo, int endNo) {

		String sql = "SELECT * FROM(SELECT DISTINCT R.REVIEW_NO,R. REVIEW_TITLE, R.REVIEW_CONTENTS,"
				+ " R.REVIEW_DATE ,R.REVIEW_LIKE,R.REVIEW_VIEWS,R.REVIEW_DECLARATION, R.REVIEW_DELETE,"
				+ " R.USER_ID,I.REVIEW_IMG_SERVERFILE1 FROM REVIEW R, REVIEW_IMG I WHERE R.REVIEW_NO = I.REVIEW_NO ORDER BY REVIEW_NO DESC )"
				+ "WHERE ROWNUM BETWEEN ? AND ?  AND REVIEW_DELETE = 'N' AND REVIEW_DECLARATION<5 ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List Reviewlist = new ArrayList<ReviewListVo>();
		ReviewListVo r = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt("REVIEW_NO");
				String reviewTitle = rs.getString("REVIEW_TITLE");
				String reviewContents = rs.getString("REVIEW_CONTENTS");
				Timestamp reviewDate = rs.getTimestamp("REVIEW_DATE");
				int reviewLike = rs.getInt("REVIEW_LIKE");
				int reviewDeclaration = rs.getInt("REVIEW_DECLARATION");
				int reviewViews = rs.getInt("REVIEW_VIEWS");
				String reviewDelete = rs.getString("REVIEW_DELETE");
				String userId = rs.getString("USER_ID");
				String reviewImg = rs.getString("REVIEW_IMG_SERVERFILE1");
				
				r = new ReviewListVo();
				r.setReviewNo(reviewNo);
				r.setReviewTitle(reviewTitle);
				r.setReviewContents(reviewContents);
				r.setReviewDate(reviewDate);
				r.setReviewLike(reviewLike);
				r.setReviewDeclaration(reviewDeclaration);
				r.setReviewViews(reviewViews);
				r.setReviewDelete(reviewDelete);
				r.setUserId(userId);
				if(reviewImg != null) {
					r.setReviewImg(reviewImg);
				}
				else {
					r.setReviewImg("no_img.jpg");
				}
				
				Reviewlist.add(r);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(conn);
			close(pstmt);
		}
		return Reviewlist;
	}

	// 리뷰게시물 개수를 불러오는 메소드
	public int countreviewAll(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리뷰게시물개수를 부르는 쿼리
		String sql = "SELECT COUNT(REVIEW_NO) FROM REVIEW";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return 0;
	}

	public List<ReviewListVo> reviewImg(Connection conn, int startNo, int endNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List ReviewImglist = new ArrayList<ReviewListVo>();
		ReviewListVo r = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, r.* FROM REVIEW_IMG r ) WHERE RNUM BETWEEN  ? AND ? ORDER BY REVIEW_IMG_DATE DESC ";

		System.out.println(startNo);
		System.out.println(endNo);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String reviewImg = rs.getString("REVIEW_IMG_SERVERFILE1");
				System.out.println(reviewImg);
				r = new ReviewListVo();
				r.setReviewImg(reviewImg);
				
				ReviewImglist.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return ReviewImglist;
	}

	// 상세 페이지에 넣기위해 리뷰 리스트에서 하나씩 데이터를 꺼내오는 메소드
	public List<ReviewListVo> detailReview(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM REVIEW WHERE REVIEW_NO = ?";
		ReviewListVo i = null;
		List Reviewlist = new ArrayList<ReviewListVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				int reviewNo = rs.getInt("REVIEW_NO");
				String reviewTitle = rs.getString("REVIEW_TITLE");
				String reviewContents = rs.getString("REVIEW_CONTENTS");
				Timestamp reviewDate = rs.getTimestamp("REVIEW_DATE");
				String userId = rs.getString("USER_ID");
				int reviewLike = rs.getInt("REVIEW_LIKE");
				int reviewDeclaration = rs.getInt("REVIEW_DECLARATION");
				int reviewViews = rs.getInt("REVIEW_VIEWS");
				String reviewDelete = rs.getString("REVIEW_DELETE");

				i = new ReviewListVo();
				i.setReviewNo(reviewNo);
				i.setReviewTitle(reviewTitle);
				i.setReviewContents(reviewContents);
				i.setReviewDate(reviewDate);
				i.setUserId(userId);
				i.setReviewLike(reviewLike);
				i.setReviewDeclaration(reviewDeclaration);
				i.setReviewViews(reviewViews);
				i.setReviewDelete(reviewDelete);

				Reviewlist.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
		}
		return Reviewlist;

	}

	// 해당 게시물 번호에 맞춰 리뷰 이미지들을 받아오는 메소드
	public List<ReviewImgVo> getReviewImgList(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT REVIEW_IMG_SERVERFILE1 , REVIEW_IMG_SERVERFILE2 , REVIEW_IMG_SERVERFILE3 FROM REVIEW_IMG WHERE REVIEW_NO = ?";
		ReviewImgVo i = null;

		List ReviewImgList = new ArrayList<ReviewListVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String serverFile1 = rs.getString("REVIEW_IMG_SERVERFILE1");
				String serverFile2 = rs.getString("REVIEW_IMG_SERVERFILE2");
				String serverFile3 = rs.getString("REVIEW_IMG_SERVERFILE3");

				i = new ReviewImgVo();
				i.setImgServerFile1(serverFile1);
				i.setImgServerFile2(serverFile2);
				i.setImgServerFile3(serverFile3);
				ReviewImgList.add(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
		}
		return ReviewImgList;
	}

	// 리뷰 삭제를 위해 리뷰 넘버를 넘긴 후 해당하는 게시물을 찾아온 후 , 리뷰를 삭제하는 메소드
	public int deleteReview(Connection conn, int no, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String server_userId = null;
		ResultSet rs = null;
		String sql = "SELECT USER_ID FROM REVIEW WHERE REVIEW_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				server_userId = rs.getString("USER_ID");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println(server_userId + "  " + userId);
		if (server_userId.equals(userId)) {

			sql = "UPDATE REVIEW SET REVIEW_DELETE = 'Y' WHERE REVIEW_NO =?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				commit(conn);
				close(conn);
				close(pstmt);

			}

		} else {
			close(conn);
			close(pstmt);
		}

		return result;
	}

	// 리뷰좋아요를 누를경우 리뷰의 좋아요 수를 증가시키는 메소드
	public int updateLike(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_LIKE =REVIEW_LIKE+1 WHERE REVIEW_NO = ?";
		// 리뷰테이블에서 RIEVEW_LIKE(좋아요)를 불러올때 마다 REVIEW_RIKE에 +1을 해서 불러온다.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}

		return rs;
	}

	// 리뷰좋아요 개수를 불러오는 메소드
	public int selectLike(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rtn = 0;

		String sql = "SELECT REVIEW_LIKE FROM REVIEW WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rtn = rs.getInt("REVIEW_LIKE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
		}

		return rtn;

	}

	// 리뷰의 조회수를 증가시키는 메소드
	public int viewsUpdate(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_VIEWS =REVIEW_VIEWS+1 WHERE REVIEW_NO = ?";
		// 리뷰테이블에서 RIEVEW_VIEWS(조회수)를 불러올때 마다 REVIEW_VIEWS +1을 해서 불러온다.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}

		return rs;
	}

	// 리뷰게시물의 신고횟수를 증가시키는 메소드
	public int declarationUp(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_DECLARATION = REVIEW_DECLARATION+1 WHERE REVIEW_NO =?";
		// 리뷰테이블에서 REVIEW_DECLARATION(신고횟수)를 불러올때 마다 REVIEW_DECLARATION +1을 해서 불러온다.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}

		return rs;
	}

	public int InsertDeclaration(Connection conn, int no, String reviewReason) {
		PreparedStatement pstmt = null;
		int rs =0;
		
		String sql="INSERT INTO DECLARATION (DECLARATION_NO , REVIEW_NO, DECLATION_REASON) VALUES (SEQ_DECLARATION.NEXTVAL, ? , ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2,reviewReason);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}
		
		return rs;
	}

}