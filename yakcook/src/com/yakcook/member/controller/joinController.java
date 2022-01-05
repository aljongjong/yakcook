package com.yakcook.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5
		)
@WebServlet("/join")
public class joinController extends HttpServlet{
	
	//회원가입 화면 보여줌
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	//회원가입 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		MemberVo m = new MemberVo();
		m.setUser_id(id);
		m.setUser_pwd(pwd);
		m.setUser_name(name);
		m.setUser_email(email);
		m.setUser_phone(phone);
		
		int result = new MemberService().join(m);
		
		if(result>0) {
			// 성공
			/*
			 * req.setAttribute("msg", "회원가입 성공");
			 * req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req,
			 * resp);
			 */
			out.println("<script>alert('회원가입이 완료 되었습니다.'); location.href='home.jsp';</script>");				 
			out.flush();
		}else {
			// 실패
			out.println("<script>alert('회원 가입 실패.'); location.href='home.jsp';</script>");				 
			out.flush();
		}
	}
}
