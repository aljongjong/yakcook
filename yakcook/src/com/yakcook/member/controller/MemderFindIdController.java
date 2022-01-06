package com.yakcook.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.dao.MemberDao;
import com.yakcook.member.model.service.MemberService;


@WebServlet("/findId")
public class MemderFindIdController extends HttpServlet {
	// 아이디 찾기 화면 보여줌
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/findIdForm.jsp").forward(req, resp);
	}
	// 아이디 찾기 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//MemberDao mDao = new MemberDao();
		String name = req.getParameter("Name");
		String email = req.getParameter("Email");
		
		//String id = mDao.findId(name, email);
		String id = new MemberService().findId(name, email);
		req.setAttribute("id", id);
		
		if(id != null) {
			req.setAttribute("id", id);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			out.println("<script>alert('회원정보가 없습니다.'); location.href='login';</script>");				
			out.flush();
			//req.setAttribute("msg", "조회 실패");
			//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}
	}
}
