package com.yakcook.product.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;

@WebServlet("/detailsProduct")
public class DetailsProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 총 금액 변경 ajax
		int dpPrice = Integer.parseInt(req.getParameter("price"));	
		int dpAmount = Integer.parseInt(req.getParameter("amount"));
		
		int totalPrice = dpPrice * dpAmount;
		int totalPriceD = totalPrice + 2500;
		if(totalPrice >= 100000) {
			resp.getWriter().print(totalPrice);	
		} else {
			resp.getWriter().print(totalPriceD);	
		}
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 제품 이미지 불러오기
		List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
		req.setAttribute("productImgList", piList);
		
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
