package com.yakcook.customerService.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.customerService.model.vo.noticeVo;
import com.yakcook.customerService.service.customerService;

@WebServlet("/noticedetail")
public class noticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int noticeNumber = Integer.parseInt(req.getParameter("noticeNumber"));
		
		noticeVo NV = new customerService().getNoticeDetail(noticeNumber);
		req.setAttribute("NV", NV);
		req.getRequestDispatcher("/WEB-INF/views/customerService/noticeDetail.jsp").forward(req, resp);
	}
}
