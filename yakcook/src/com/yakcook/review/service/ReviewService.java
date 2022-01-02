package com.yakcook.review.service;

import static com.yakcook.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import com.yakcook.review.dao.ReviewDao;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewListVo;
import com.yakcook.review.vo.ReviewVo;

public class ReviewService {

	public int writerReview(ReviewVo r) {
		Connection conn = getConnection();
		return new ReviewDao().writerReview(conn, r);

	}
	public int imgReview(ReviewImgVo i) {
		Connection conn =getConnection();
		return new ReviewDao().imgReview(conn,i);
	}
	
	//public List<ReviewImgVo> selectImgReview(){
	//	List<ReviewImgVo> reviewImgList = new ReviewDao().getReviewImgList();
	//	return reviewImgList;}
	public List<ReviewListVo> selectReview(String currentPage) {
		// DB에 가서 데이터 조회
		Connection conn = getConnection();

		int totalReviewCount = countReviewAll(conn);// 총 리뷰 개수
		int pageLimit = 10;// 페이징 목록 최대갯수
		int reviewLimit = 9;// 한 페이지당 게시글 수
		int maxPage = 0;

		maxPage = totalReviewCount / pageLimit;
		if (totalReviewCount % pageLimit != 0) {
			maxPage++;
		}

		// p(currentPage)를 int형으로 변환함
		int p = Integer.parseInt(currentPage);
		int endNo = p * reviewLimit; // 끝페이지
		int startNo = endNo - reviewLimit + 1;// 시작페이지
		
		List<ReviewListVo> reviewList = new ReviewDao().getReviewList(conn, startNo, endNo);

		close(conn);
		return reviewList;

		// 쿼리준비

	}

	// 리뷰 개수를 알아보는 메소드 호출
	public int countReviewAll(Connection conn) {
		return new ReviewDao().countreviewAll(conn);
	}
	

	public List<ReviewListVo> detailReviewAll(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().detailReview(conn, no);
	}

	public static int deleteReview(String titleNo) {
		int no = Integer.parseInt(titleNo);
		Connection conn = getConnection();
		return new ReviewDao().deleteReview(conn , no);
	}
	
	public List<ReviewImgVo> getReviewImgList(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().getReviewImgList(conn, no);
	}
	public int upReivewLike(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().updateLike(conn, no);
	}
	public int upReivewViews(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().viewsUpdate(conn, no);
	}
	
	
	public int upDeclaration(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().declarationUp(conn, no);
	}

}
