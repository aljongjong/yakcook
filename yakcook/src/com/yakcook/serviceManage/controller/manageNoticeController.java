package com.yakcook.serviceManage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.model.vo.pagingVo;
import com.yakcook.serviceManage.service.serviceManageService;

@WebServlet("/managenotice")
public class manageNoticeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		ArrayList<noticeVo> noticeList = new serviceManageService().getNoticeList(pv);
		req.setAttribute("paging", pv);
		req.setAttribute("noticeList", noticeList);
		req.getRequestDispatcher("/WEB-INF/views/serviceManage/manageNotice.jsp").forward(req, resp);
	}
}
