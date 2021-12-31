package com.yakcook.usermanage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.usermanage.service.userManageService;

@WebServlet("/userdel")
public class userDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userNumber = req.getParameter("userDel");
		int userNum = Integer.parseInt(userNumber);
		int result = new userManageService().userDel(userNum);
		if(result != 1) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
		}
	}
}
