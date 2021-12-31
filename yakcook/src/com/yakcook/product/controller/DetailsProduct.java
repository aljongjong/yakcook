package com.yakcook.product.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.vo.ProductVo;

@WebServlet("/detailsProduct")
public class DetailsProduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 제품 조회 페이지에서 제품 이름 클릭시 제품 상세 페이지 이동하기
		String productNo = req.getParameter("productNo");
		String price = req.getParameter("price");
		String categoryDate = req.getParameter("categoryDate");
		String productContents = req.getParameter("productContents");
		String productDelete = req.getParameter("productDelete");
		String lasteditDate = req.getParameter("lasteditDate");
		String inventory = req.getParameter("inventory");
		String categoryNo = req.getParameter("categoryNo");
		String productName = req.getParameter("productName");
		
		System.out.println(productNo);
		System.out.println(price);
		System.out.println(categoryDate);
		System.out.println(productContents);
		System.out.println(productDelete);
		System.out.println(lasteditDate);
		System.out.println(inventory);
		System.out.println(categoryNo);
		System.out.println(productName);
		
		ProductVo pv = new ProductVo();
		pv.setProductNo(Integer.parseInt(productNo));
		pv.setPrice(Integer.parseInt(price));
		pv.setProductContents(productContents);
		pv.setInventory(Integer.parseInt(inventory));
		pv.setCategoryNo(Integer.parseInt(categoryNo));
		pv.setProductName(productName);
		
		req.setAttribute("detailsProduct", pv);
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/product/detailsProduct.jsp").forward(req, resp);
	}
}
