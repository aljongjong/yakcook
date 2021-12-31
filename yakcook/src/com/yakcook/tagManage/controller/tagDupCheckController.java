package com.yakcook.tagManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.tagManage.service.tagManageService;

@WebServlet("/tagDupCheck")
public class tagDupCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tagName = req.getParameter("name");
		int result = new tagManageService().dupCheck(tagName);
		if(result > 0) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
			
		}
	}
}
