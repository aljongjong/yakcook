package com.yakcook.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberQnAVo;

@WebServlet("/QnADetail")
public class MemberQnaDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnano = req.getParameter("qna_no");
		System.out.println(qnano);
		
		List<MemberQnAVo> qnaList = new MemberService().qnaDatailAll(qnano);
		
		req.setAttribute("qnaList", qnaList);
		req.getRequestDispatcher("WEB-INF/views/member/MemberQnADetail.jsp").forward(req, resp);
	}
}
