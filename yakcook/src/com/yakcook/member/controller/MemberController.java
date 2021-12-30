package com.yakcook.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/search")
public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("searchType");
		String value = req.getParameter("searchValue");
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		
		System.out.println(type);
		System.out.println(value);
		System.out.println("currentPage : " + currentPage);
		
		List<MemberVo> memberList = new MemberService().search(type, value, currentPage);
		req.setAttribute("memberList", memberList);
		req.getRequestDispatcher("/WEB-INF/views/member/searchAllUser.jsp").forward(req, resp);
	}
}
