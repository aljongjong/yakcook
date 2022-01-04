package com.yakcook.serviceManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.service.serviceManageService;

@WebServlet("/modinotice")
public class noticeModifyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
		noticeVo NV = new serviceManageService().getNoticeDetail(noticeNo);
		req.setAttribute("NV", NV);
		req.getRequestDispatcher("/WEB-INF/views/serviceManage/modifyNotice.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int noticeNumber = Integer.parseInt(req.getParameter("noticeNumber"));
		String title = req.getParameter("noticeTitle");
		String contents = req.getParameter("noticeContents");
		int managerNo = Integer.parseInt(req.getParameter("manageNo"));
		
		noticeVo NV = new noticeVo();
		NV.setManagerNo(managerNo);
		NV.setNoticeContent(contents);
		NV.setNoticeNo(noticeNumber);
		NV.setNoticeTitle(title);

		
		int result = new serviceManageService().modiNotice(NV);
		
		if(result != 1) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
		}
	}
}
