package com.yakcook.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/pwdUpdate")
public class MemberPwdUpdateController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String oldPwd = req.getParameter("oldPwd");
		String newPwd = req.getParameter("newPwd");
		
		// 잘나오는 거 확인!
//		System.out.println("업데이트폼~~!" +userId);
//		System.out.println("업데이트폼~~!" +oldPwd);
//		System.out.println("업데이트폼~~!" +newPwd);
		
		//id, oldPwd 던지기
		int result = new MemberService().myPwdCheck(userId, oldPwd);
		
		//성공
		if(result > 0) {
			int Pwdresult = new MemberService().myPwdUpdate(userId, newPwd);
			if(Pwdresult > 0 ) {
				System.out.println("비번 바꾸기 성공");
				req.setAttribute("msg", "비번 변경 성공");
				req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			}else {
				System.out.println("비번 바꾸기 실패");
				req.setAttribute("msg", "비번 변경 실패");
				req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			}
		}//실패 
		else {
			System.out.println("실패" + result);
		}
	}
}
