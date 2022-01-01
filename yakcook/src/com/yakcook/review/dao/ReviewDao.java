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
import com.yakcook.review.vo.ReviewVo;

public class ReviewDao {

	// 작성한 리뷰의 제목, 내용 , 작성자 ,파일 이미지를 데이터베이스에 넣는메소드
	public int writerReview(Connection conn, ReviewVo r) {
		String sql = "INSERT INTO REVIEW (REVIEW_NO , REVIEW_TITLE , REVIEW_CONTENTS , REVIEW_DATE,WRITER , REVIEW_LIKE ,"
				+ "REVIEW_DECLARATION,REVIEW_VIEWS,REVIEW_DELETE) "
				+ "VALUES (SEQ_REVIEW_NO.NEXTVAL, ? , ? , SYSDATE , ? , ? , ? , ?, ?)";
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getTitle());
			pstmt.setString(2, r.getContents());
			pstmt.setString(3, r.getWriter());
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setString(7, "N");

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
		System.out.println(sql);
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

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, r.* FROM REVIEW r ) WHERE REVIEW_DELETE = 'N' AND"
				+ " RNUM BETWEEN ? AND ? ORDER BY REVIEW_DATE DESC ";

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
				String userId = rs.getString("USER_ID");
				int reviewLike = rs.getInt("REVIEW_LIKE");
				int reviewDeclaration = rs.getInt("REVIEW_DECLARATION");
				int reviewViews = rs.getInt("REVIEW_VIEWS");
				String reviewDelete = rs.getString("REVIEW_DELETE");

				r = new ReviewListVo();
				r.setReviewNo(reviewNo);
				r.setReviewTitle(reviewTitle);
				r.setReviewContents(reviewContents);
				r.setReviewDate(reviewDate);
				r.setUserId(userId);
				r.setReviewLike(reviewLike);
				r.setReviewDeclaration(reviewDeclaration);
				r.setReviewViews(reviewViews);
				r.setReviewDelete(reviewDelete);

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

	public int deleteReview(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_DELETE = 'Y' WHERE REVIEW_NO =?";
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

	public int updateLike(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_LIKE =REVIEW_LIKE+1 WHERE REVIEW_NO = ?";

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

	public int viewsUpdate(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_VIEWS =REVIEW_VIEWS+1 WHERE REVIEW_NO = ?";

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

	public int declarationUp(Connection conn , int no) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE REVIEW SET REVIEW_DECLARATION = REVIEW_DECLARATION+1 WHERE REVIEW_NO =?";

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

}