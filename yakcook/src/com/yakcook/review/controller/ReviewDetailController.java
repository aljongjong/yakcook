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

@WebServlet("/reviewDetail")
public class ReviewDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewNo = req.getParameter("reviewNo");
		
		int views = new ReviewService().upReivewViews(reviewNo);
		
		//List를 이용해서 List형식으로 여러개를 뽑아온다.
		List<ReviewListVo> detailList = new ReviewService().detailReviewAll(reviewNo);
		List<ReviewImgVo> imgList = new ReviewService().getReviewImgList(reviewNo);
		
		//RdatailList에서 reivewNo만 넘겨준다.
		req.setAttribute("reviewNo",(detailList.get(0).getReviewNo()));
		
		//deatailList에서 뽑아온 내용을 넘겨준다.
		req.setAttribute("detailList", detailList);
	
		//imgList에서 뽑아온 내용을 넘겨준다.
		req.setAttribute("imgList", imgList);
		
		req.getRequestDispatcher("WEB-INF/views/review/detailReview.jsp").forward(req, resp);
	}
	
}
