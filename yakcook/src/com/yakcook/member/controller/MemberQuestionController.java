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
import com.yakcook.member.model.vo.MemberQnAVo;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/memberquestion")
public class MemberQuestionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 세션 가져오기
		HttpSession session = req.getSession();
		
		//현재 로그인 한 회원의 세션 정보 가져오기
		String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
		System.out.println("현재 로그인 아이디 질문! : "+ loginUserId);
		
		List<MemberQnAVo> qnalist = new MemberService().qnaListAll(loginUserId);
		
		req.setAttribute("qnaList", qnalist);
		req.getRequestDispatcher("/WEB-INF/views/member/memberQuestion.jsp").forward(req, resp);
	}
}
	

