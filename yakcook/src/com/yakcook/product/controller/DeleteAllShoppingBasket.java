package com.yakcook.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.service.ServiceProduct;

@WebServlet("/allDeleteShoppingBasket")
public class DeleteAllShoppingBasket extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int shoppingBasketNo = Integer.parseInt(req.getParameter("shoppingBasketNo"));
		
		System.out.println("전체삭제할 장바구니번호 : " + shoppingBasketNo);
		
		// 장바구니 안에 전체 제품 삭제
		int result = new ServiceProduct().deleteAllShoppingBasket(shoppingBasketNo);
		System.out.println("전체삭제된 행 개수: " + result);
		
		req.setAttribute("msg", "장바구니가 비었습니다.");
		req.getRequestDispatcher("/WEB-INF/views/product/deleteAllShoppingBasket.jsp").forward(req, resp);
	}
}
