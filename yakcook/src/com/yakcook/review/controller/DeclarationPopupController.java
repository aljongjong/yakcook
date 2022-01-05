package com.yakcook.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/declarationPopup")
public class DeclarationPopupController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reviewNo = req.getParameter("reviewNo");
		
		
		req.setAttribute("reviewNo",reviewNo);
		req.getRequestDispatcher("WEB-INF/views/review/declaration.jsp").forward(req, resp);
	}
}
