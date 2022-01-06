package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;

@WebServlet("/memberEmailDupCheck")
public class MemberEmailDupCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		System.out.println("이메일  : "+  email);
		
		int result = new MemberService().dupCheckEmail(email);
		
		if(result > 0) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
		}
	}
}
