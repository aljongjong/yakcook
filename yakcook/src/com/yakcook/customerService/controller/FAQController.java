package com.yakcook.customerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.customerService.model.vo.FAQVo;
import com.yakcook.customerService.model.vo.pagingVo;
import com.yakcook.customerService.service.customerService;



@WebServlet("/FAQ")
public class FAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("category");
		String currentPage = req.getParameter("currentPage");
		pagingVo pv = new pagingVo();
		if(currentPage == null) {
			pv.setCurrentPage(1);
		} else {
			pv.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		int startPage = pv.getCurrentPage() -2;
		if(startPage <=0) {
			startPage=1;
		}
		pv.setStartPage(startPage);
		int endPage = startPage + pv.getPageLimit();
		pv.setEndPage(endPage);
		
		ArrayList<FAQVo> faqList = new customerService().getFAQList(value, pv);
		if(value!=null) {
			req.setAttribute("category", value);
		}
		req.setAttribute("paging", pv);
		req.setAttribute("faqList", faqList);
		req.getRequestDispatcher("/WEB-INF/views/customerService/FAQ.jsp").forward(req, resp);
	}
}
