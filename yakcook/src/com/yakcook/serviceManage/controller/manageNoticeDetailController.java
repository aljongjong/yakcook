package com.yakcook.serviceManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.service.serviceManageService;

@WebServlet("/managenoticedetail")
public class manageNoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int noticeNumber = Integer.parseInt(req.getParameter("noticeNumber"));
		
		noticeVo NV = new serviceManageService().getNoticeDetail(noticeNumber);
		req.setAttribute("NV", NV);
		req.getRequestDispatcher("/WEB-INF/views/serviceManage/manageNoticeDetail.jsp").forward(req, resp);
	}
}
