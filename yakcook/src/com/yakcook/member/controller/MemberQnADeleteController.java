package com.yakcook.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;

@WebServlet("/qnadelete")
public class MemberQnADeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String qnano = req.getParameter("qnano");
		String id = req.getParameter("userId");
		
		// 아이디랑 비번 확인
		// System.out.println(id + "이고" + qnano );
		
		// 옮겨줌
		int result = new MemberService().deleteQnA(qnano, id);
		
		if(result > 0) {
			out.println("<script>alert('문의가 성공적으로 삭제 되었습니다.'); location.href='memberquestion';</script>");				
			out.flush();
			//req.setAttribute("msg", "문의 삭제 성공");
			//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}
		else {
			//req.setAttribute("msg", "문의 삭제 실패");
			//req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req,resp);
			out.println("<script>alert('문의가 실패 되었습니다.'); location.href='memberquestion';</script>");				
			out.flush();
		}
		
	}
}
