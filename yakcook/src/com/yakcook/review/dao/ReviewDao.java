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
		String sql = "INSERT INTO REVIEW (REVIEW_NO , REVIEW_TITLE , REVIEW_CONTENTS , REVIEW_DATE ,"
				+ " WRITER , REVIEW_DECLARATION,REVIEW_DELETE)"
				+ "VALUES (SEQ_REVIEW.NEXTVAL, ? , ? , SYSDATE , ? , ? , ?)";
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getTitle());
			pstmt.setString(2, r.getContents());
			pstmt.setString(3, r.getWriter());
			pstmt.setInt(4, 0);
			pstmt.setString(5, "N");

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
		String sql = "INSERT INTO REVIEW_IMG (REVIEW_NO , SERVERFILE1 ,SERVERFILE2,SERVERFILE3) "
				+ "	VALUES (SEQ_REVIEW_IMG.NEXTVAL, ?,?,?)";
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getServerFile1());
			pstmt.setString(2, i.getServerFile2());
			pstmt.setString(3, i.getServerFile3());

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
				String reviewWriter = rs.getString("WRITER");

				r = new ReviewListVo();
				r.setReviewNo(reviewNo);
				r.setReviewTitle(reviewTitle);
				r.setReviewContents(reviewContents);
				r.setReviewDate(reviewDate);
				r.setWriter(reviewWriter);
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
				Timestamp reviewData = rs.getTimestamp("REVIEW_DATE");
				String writer = rs.getString("WRITER");

				i = new ReviewListVo();
				i.setReviewNo(reviewNo);
				i.setReviewTitle(reviewTitle);
				i.setReviewContents(reviewContents);
				i.setReviewDate(reviewData);
				i.setWriter(writer);
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

		String sql = "SELECT I.SERVERFILE1 , I.SERVERFILE2 , I. SERVERFILE3 FROM REVIEW_IMG I INNER JOIN "
				+ "REVIEW R ON (I.REVIEW_NO = R.REVIEW_NO) WHERE I.REVIEW_NO = ?";
		ReviewImgVo i = null;

		List ReviewImgList = new ArrayList<ReviewListVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String serverFile1 = rs.getString("SERVERFILE1");
				String serverFile2 = rs.getString("SERVERFILE2");
				String serverFile3 = rs.getString("SERVERFILE3");
				
				i = new ReviewImgVo();
				i.setServerFile1(serverFile1);
				i.setServerFile2(serverFile2);
				i.setServerFile3(serverFile3);
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

}