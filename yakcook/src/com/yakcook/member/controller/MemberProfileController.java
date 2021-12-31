package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/profile")
public class MemberProfileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		//현재 로그인 한 회원의 세션 정보 가져오기
		String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getId();
		System.out.println("현재 로그인 아이디 : "+ loginUserId);
		
		MemberVo m = new MemberService().myInfotmation(loginUserId);
		
		//
		if( m != null) {
			req.setAttribute("m", m);
			req.getRequestDispatcher("/WEB-INF/views/member/profileForm.jsp").forward(req, resp);
		}
	}
}
