package com.yakcook.usermanage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.usermanage.model.vo.pagingVo;
import com.yakcook.usermanage.model.vo.userVo;
import com.yakcook.usermanage.service.userManageService;

@WebServlet("/userlist")
public class userManageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("user_search");
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
		
		ArrayList<userVo> userList = new userManageService().getUserList(value, pv);
		if(value!=null) {
			req.setAttribute("search", value);
		}
		req.setAttribute("paging", pv);
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/WEB-INF/views/userManage/userList.jsp").forward(req, resp);
	}
}
