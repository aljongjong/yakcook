package com.yakcook.serviceManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.service.serviceManageService;

@WebServlet("/addnotice")
public class noticeAddController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/serviceManage/addNotice.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("faqTitle");
		String contents = req.getParameter("faqContents");
		int managerNo = Integer.parseInt(req.getParameter("manageNo"));
		
		noticeVo nv = new noticeVo();
		nv.setManagerNo(managerNo);
		nv.setNoticeContent(contents);
		nv.setNoticeTitle(title);
		
		int result = new serviceManageService().addNotice(nv);
		
		if(result != 1) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
		}
	}
}
