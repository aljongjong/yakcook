package com.yakcook.review.controller;

import java.io.IOException;

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
	System.out.println(reviewNo);
	int like = new ReviewService().upReivewLike(reviewNo);
	
	}
}
