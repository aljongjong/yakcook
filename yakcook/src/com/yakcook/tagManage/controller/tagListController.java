package com.yakcook.tagManage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.tagManage.model.vo.pagingVo;
import com.yakcook.tagManage.model.vo.tagVo;
import com.yakcook.tagManage.service.tagManageService;

@WebServlet("/taglist")
public class tagListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("tag_search");
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
		
		ArrayList<tagVo> tagList = new tagManageService().getTagList(value, pv);
		if(value!=null) {
			req.setAttribute("search", value);
		}
		req.setAttribute("paging", pv);
		req.setAttribute("tagList", tagList);
		req.getRequestDispatcher("/WEB-INF/views/tagManage/tagList.jsp").forward(req, resp);
	}
}
