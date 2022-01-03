package com.yakcook.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.TagVo;

@WebServlet("/tagSearchBar")
public class TagSearchBar extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<TagVo> list = new ServiceProduct().registerTagList();
		
		req.setAttribute("tagList", list);
		req.getRequestDispatcher("/WEB-INF/views/common/tagSearchBar/tagSearchBar.jsp").forward(req, resp);
	}
}
