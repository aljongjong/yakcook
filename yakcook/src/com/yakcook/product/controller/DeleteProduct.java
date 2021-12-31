package com.yakcook.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.service.ServiceProduct;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int deleteProuctNo = Integer.parseInt(req.getParameter("deleteProuctNo"));
		System.out.println("삭제 제품 번호 : " + deleteProuctNo);
		
		int result = new ServiceProduct().deleteProduct(deleteProuctNo);
		
		if(result > 0) {
			req.setAttribute("msg", "제품 삭제를 성공했습니다.");
			req.getRequestDispatcher("/WEB-INF/views/product/deleteSuccessProduct.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "제품 삭제를 실패했습니다.");
			req.getRequestDispatcher("/WEB-INF/views/product/deleteErrorProduct.jsp").forward(req, resp);
		}
	}
}
