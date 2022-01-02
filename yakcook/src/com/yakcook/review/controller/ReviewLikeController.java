package com.yakcook.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.review.service.ReviewService;

@WebServlet("/reviewLike")
public class ReviewLikeController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	String reviewNo = req.getParameter("reviewNo");
	//rievewNo를 받아온다.
	
	
	int like = new ReviewService().upReivewLike(reviewNo);
	int like_count = new ReviewService().reviewLikeCount(reviewNo);
	//위에 reivewNo를 넘겨주면서 리뷰좋아요수를 증가하는 메소드와 리뷰 좋아요개수를 가져오는 메소드 실행

	

	
	
	
	}
}
