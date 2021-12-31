package com.yakcook.tagManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.tagManage.service.tagManageService;

@WebServlet("/tagmodi")
public class tagModifyController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tagNum = req.getParameter("tagNum");
		req.getSession().setAttribute("tagNum", tagNum);
		req.getRequestDispatcher("/WEB-INF/views/tagManage/tagModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tagNumber = (String) req.getSession().getAttribute("tagNum");
		String tagName = req.getParameter("tagName");
		int tagNum = Integer.parseInt(tagNumber);
		int result = new tagManageService().tagModify(tagNum, tagName);
		if(result != 1) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			req.getSession().removeAttribute("tagNum");
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
			
		}
	}
}
