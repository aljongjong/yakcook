package com.yakcook.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/memberinfoupdate")
public class MemberInfoUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("user_id");
		System.out.println("아이디"+id);
		
		MemberVo m  = new MemberService().myinfoList(id);
		
		if(m != null) {
			req.setAttribute("m", m);
			req.getRequestDispatcher("/WEB-INF/views/member/memberInfoUpdate.jsp").forward(req, resp);
		}else {
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("uesrid");
		String email = req.getParameter("usereamil");
		String phone = req.getParameter("userphone");
		
		System.out.println(id + email + phone);
		int result = new MemberService().myinfoUpdate(id, email, phone);
		
		if(result > 0) {
			out.println("<script>alert('회원 정보 변경되었습니다.'); location.href='profile';</script>");				 
			out.flush();
		}else {
			
		}
	}
}
