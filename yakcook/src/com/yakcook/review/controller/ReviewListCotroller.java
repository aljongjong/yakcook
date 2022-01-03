package com.yakcook.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.common.JDBCTemplate;
import com.yakcook.member.model.vo.MemberVo;
import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewListVo;

@WebServlet("/reviewList")
public class ReviewListCotroller extends HttpServlet {

	@Override // 리뷰목록 페이지를 보여줄 메소드
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// currentPage 선언
		String currentPage = req.getParameter("currentPage");
		if (currentPage == null)
			currentPage = "1";
		// 조회해온 리뷰데이터를 ReviewList(리뷰목록에 넘겨줌)
		int maxPage = 4;
		req.setAttribute("maxPage", maxPage);

		int startPage = Integer.parseInt(currentPage) - 2;

		if (startPage <= 0)
			startPage = 1;
		int endPage = startPage + 5;// pageLimit
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
	        
	        //현재 로그인 한 회원의 세션 정보 가져오기
		// page 갯수 정하는 코드
		List<ReviewListVo> reviewList = new ReviewService().selectReview(currentPage);
		// reviewList로 data(reviewList)를 전송해줌.
		req.setAttribute("data", reviewList);
		req.getRequestDispatcher("WEB-INF/views/review/reviewList.jsp").forward(req, resp);
	}

}