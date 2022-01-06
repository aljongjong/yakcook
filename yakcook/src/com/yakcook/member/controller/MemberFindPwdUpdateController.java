package com.yakcook.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/findPwdUpdate")
public class MemberFindPwdUpdateController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		String pwd = req.getParameter("password");
		int result = new MemberService().myfindPwdUpdate(id,pwd);
		
		//성공
		if(result > 0) {
			out.println("<script>alert('비밀번호 변경이 완료 되었습니다.'); location.href='login';</script>");				
			out.flush();
			//req.setAttribute("msg", "비번 변경까지 완료");
			//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		}else {
			//req.setAttribute("msg", "비번 변경까지 실패");
			//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			out.println("<script>alert('비밀번호 변경 실패.'); location.href='login';</script>");				
			out.flush();
		}
	}
}
