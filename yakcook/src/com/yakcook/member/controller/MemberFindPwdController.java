package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;

@WebServlet("/findPwd")
public class MemberFindPwdController extends HttpServlet{
	//비번 찾기 form
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/findPwdForm.jsp").forward(req, resp);
	}
	//비번 찾기 기능 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		// 파라미터 잘 받아오나 확인
		//System.out.println(name+ "이고" + id + "이고~"+ email);
		int result = new MemberService().findPwd(name, id, email);
		
		//성공하면 1
		if(result > 0) {
			req.setAttribute("id", id);
			req.getRequestDispatcher("/WEB-INF/views/member/findPwdUpdateForm.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "비번 조회까지 실패");
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}
	}
}
