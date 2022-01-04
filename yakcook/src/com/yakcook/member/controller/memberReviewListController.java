package com.yakcook.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.common.JDBCTemplate;
import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;
import com.yakcook.review.vo.ReviewListVo;
import com.yakcook.review.vo.ReviewListVo;

@WebServlet("/memberReview")
public class memberReviewListController extends HttpServlet {
	//화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 세션 가져오기
		HttpSession session = req.getSession();
		
		//현재 로그인 한 회원의 세션 정보 가져오기
		String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
		System.out.println("현재 로그인 아이디!!!!!!!! : "+ loginUserId);
		
		List<ReviewListVo> reviewList = new MemberService().reviewListAll(loginUserId);
		
		req.setAttribute("data", reviewList);
		req.getRequestDispatcher("/WEB-INF/views/member/memberReviewList.jsp").forward(req, resp);
	}
	
}
