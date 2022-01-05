package com.yakcook.paymentDetail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.paymentDetail.model.vo.pagingVo;
import com.yakcook.paymentDetail.model.vo.paymentVo;
import com.yakcook.paymentDetail.service.paymentDetailService;
import com.yakcook.serviceManage.service.serviceManageService;


@WebServlet("/paymentdetail")
public class paymentDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String search = req.getParameter("pay_search");
		String currentPage = req.getParameter("currentPage");
		pagingVo pv = new pagingVo();
		if(currentPage == null) {
			pv.setCurrentPage(1);
		} else {
			pv.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		int startPage = pv.getCurrentPage() -5;
		if(startPage <=0) {
			startPage=1;
		}
		pv.setStartPage(startPage);
		int endPage = startPage + pv.getPageLimit();
		pv.setEndPage(endPage);
		
		ArrayList<paymentVo> paymentVo = new paymentDetailService().getPayList(category,search, pv);
		
		if(search!=null) {
			req.setAttribute("category", category);
			req.setAttribute("search", search);
		}
		req.setAttribute("paging", pv);
		req.setAttribute("payList", paymentVo);
		
		req.getRequestDispatcher("/WEB-INF/views/paymentDetails/paymentDetail.jsp").forward(req, resp);
	}
}
