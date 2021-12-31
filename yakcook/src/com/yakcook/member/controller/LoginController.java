package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	}
	// 로그인 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// 데이터 담기
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setPwd(pwd);
		
		MemberVo loginUser = new MemberService().login(m);
		
		if(loginUser != null) {
			req.getSession().setAttribute("loginUser", loginUser);
			req.setAttribute("msg", "로그인 성공");
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}else {
			// 실패
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
