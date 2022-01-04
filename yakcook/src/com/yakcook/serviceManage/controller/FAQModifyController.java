package com.yakcook.serviceManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.serviceManage.model.vo.FAQVo;
import com.yakcook.serviceManage.service.serviceManageService;

@WebServlet("/modiFAQ")
public class FAQModifyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int FAQNum = Integer.parseInt(req.getParameter("FAQNum"));
		FAQVo fv = new serviceManageService().getFAQ(FAQNum);
		req.setAttribute("fv", fv);
		req.getRequestDispatcher("/WEB-INF/views/serviceManage/modifyFAQ.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int FAQNum = Integer.parseInt(req.getParameter("faqNumber"));
		String title = req.getParameter("faqTitle");
		String category = req.getParameter("category");
		String contents = req.getParameter("faqContents");
		int managerNo = Integer.parseInt(req.getParameter("manageNo"));
		
		FAQVo fv = new FAQVo();
		fv.setFaqNumber(FAQNum);
		fv.setCategory(category);
		fv.setFaqContent(contents);
		fv.setFaqTitle(title);
		fv.setManagerNumber(managerNo);
		
		int result = new serviceManageService().modiFAQ(fv);
		
		if(result != 1) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
		}
	}
}
