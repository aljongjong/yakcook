package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/pwdUpdateForm")
public class MemberPwdUpdateForm extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println("여기와ㅕ따!");
		String userId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
		req.setAttribute("id", userId);
		System.out.println(userId);
		req.getRequestDispatcher("/WEB-INF/views/member/pwdUpdateForm.jsp").forward(req, resp);
	}
}
