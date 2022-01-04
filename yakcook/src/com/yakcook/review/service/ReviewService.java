package com.yakcook.review.service;

import static com.yakcook.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import com.yakcook.review.dao.ReviewDao;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewListVo;

public class ReviewService {

	public int writerReview(ReviewListVo r) {
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
		System.out.println(p);
		int startNo = 0;
		int endNo = p*9;
		if(p<=1) {
			startNo = 1;
		}
		else if(p>1) {
			startNo = (p+((p-1)*8));
		}
		else {
			System.out.println("error");
		}
		
		List<ReviewListVo> reviewList = new ReviewDao().getReviewList(conn, startNo, endNo);

		close(conn);
		return reviewList;
	}
	

	

	// 리뷰 개수를 알아보는 메소드 호출
	public int countReviewAll(Connection conn) {
		return new ReviewDao().countreviewAll(conn);
	}
	
	// 상세 페이지에 넣기위해 리뷰 리스트에서 하나씩 데이터를 꺼내오는 메소드
	public List<ReviewListVo> detailReviewAll(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().detailReview(conn, no);
	}

	
	//해당 게시물 번호에 맞춰 리뷰 이미지들을 받아오는 메소드
	public List<ReviewImgVo> getReviewImgList(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().getReviewImgList(conn, no);
	}

	//리뷰 삭제를 위해 리뷰 넘버를 넘긴 후 해당하는 게시물을 찾아온 후 , 리뷰를 삭제하는 메소드
	public static int deleteReview(String titleNo, String userId) {
		int no = Integer.parseInt(titleNo);
		Connection conn = getConnection();
		return new ReviewDao().deleteReview(conn , no, userId);
	}
	
	//리뷰좋아요를 누를경우 리뷰의 좋아요 수를 증가시키는 메소드
	public int upReivewLike(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().updateLike(conn, no);
	}

	//리뷰좋아요 개수를 불러오는 메소드
	public int reviewLikeCount(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().selectLike(conn, no);
	}
	
	//리뷰의 조회수를 증가시키는 메소드
	public int upReivewViews(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().viewsUpdate(conn, no);
	}
	
	//리뷰게시물의 신고횟수를 증가시키는 메소드
	public int upDeclaration(String reviewNo) {
		int no = Integer.parseInt(reviewNo);
		Connection conn = getConnection();
		return new ReviewDao().declarationUp(conn, no);
	}
	

}
