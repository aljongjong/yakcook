package com.yakcook.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewListVo;

@WebServlet("/detail")
public class ReviewDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewNo = req.getParameter("reviewNo");
		
		
		List<ReviewListVo> detailList = new ReviewService().detailReviewAll(reviewNo);
		List<ReviewImgVo> imgList = new ReviewService().getReviewImgList(reviewNo);
		
		req.setAttribute("detailList", detailList);
		req.setAttribute("imgList", imgList);
		req.getRequestDispatcher("WEB-INF/views/review/detailReview.jsp").forward(req, resp);
	}
	
}
