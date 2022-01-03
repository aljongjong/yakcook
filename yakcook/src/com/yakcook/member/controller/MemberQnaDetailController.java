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

@WebServlet("/qnaDetail")
public class MemberQnaDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnano = req.getParameter("qna_no");
		
		List<MemberQnAVo> qnaLiat = new MemberService().qnaDatailAll(qnano);
		
		req.setAttribute("qnaLiat", qnaLiat);
		req.getRequestDispatcher("WEB-INF/views/review/detailReview.jsp").forward(req, resp);
	}
}
