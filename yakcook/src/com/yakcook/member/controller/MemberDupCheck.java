package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;

@WebServlet("/memberDupCheck")
public class MemberDupCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax 요청 확인");
		String key1 = req.getParameter("key1");
		String key2 = req.getParameter("key2");
		String id = req.getParameter("id");
		
		//System.out.println(key1);
		//System.out.println(key2);
		System.out.println("아이디 : "+id);

		// 입력 받은 아이디를 DB의 데이터랑 비교해서 중복이 있는지 확인 -> 결과 반환
		int result = new MemberService().dupCheck(id);
		
		if(result > 0) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("중복된 아이디 입니다.");
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용가능한 아이디 입니다.");
		}
//		if("admin".equals(id)) {
//			resp.setContentType("text/html; charset=UTF-8");
//			resp.getWriter().print("관리자입니다.");
//		}else {
//			resp.setContentType("text/html; charset=UTF-8");
//			resp.getWriter().print("관리자 아닙니다.");
//		}
	}
}
