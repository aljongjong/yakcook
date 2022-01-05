package com.yakcook.paymentDetail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.paymentDetail.service.paymentDetailService;


@WebServlet("/statusupdate")
public class statusUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		String status = req.getParameter("status");
		
		int result = new paymentDetailService().statusUpdate(orderNo, status);
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
