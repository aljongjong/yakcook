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

@WebServlet("/memberdelete")
public class MemberDeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
		String userPwd = req.getParameter("userPwd");
		//String userId = (String) session.getAttribute("loginUserId");
		System.out.println(userPwd);
		System.out.println(userId);
		
		int result = new MemberService().deleteMember(userPwd,userId);
		
		 if(result > 0) {
			 req.setAttribute("msg", "회원탈퇴 성공");
			 req.getSession().invalidate();
			 req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		 }else { // 실패 
			 req.setAttribute("msg", "회원탈퇴 실패");
			 req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req,resp); 
		 }
		
		
		//req.getRequestDispatcher("/WEB-INF/views/member/deleteForm.jsp").forward(req, resp);
	}
}
