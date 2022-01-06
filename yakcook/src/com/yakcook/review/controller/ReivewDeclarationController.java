package com.yakcook.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.review.service.ReviewService;
@WebServlet("/declaration")
public class ReivewDeclarationController extends HttpServlet{
	
	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String reviewNo = req.getParameter("reviewNo");
			String reviewReason =req.getParameter("reason");
			
			
			int declaration = new ReviewService().upDeclaration(reviewNo);
			int declarationTable = new ReviewService().completeDeclaration(reviewNo , reviewReason);
			
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = resp.getWriter();
			
			if (declarationTable > 0 ) {
				out.println("<script>alert('신고가 접수되었습니다.')</script>");
				
				
			} else {
				out.println("ERROR");
			
			}
		}
		
}
