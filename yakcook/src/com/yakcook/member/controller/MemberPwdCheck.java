package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/passWordCheck")
public class MemberPwdCheck extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax 요청 확인");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		
		System.out.println("pwd1 : "+ pwd1);
		System.out.println("pwd2 : "+ pwd2);
		
		if(pwd1.equals(pwd2)) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("비밀번호 일치");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("비밀번호 불일치");
		}
	}
}
