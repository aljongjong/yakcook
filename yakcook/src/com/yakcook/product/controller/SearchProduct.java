package com.yakcook.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.ProductVo;

@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 제품 조회 페이지 좌측 카테고리 불러 오기
		List<CategoryVo> cList = new ServiceProduct().searchCategory();
		req.setAttribute("categoryList", cList);
		
		// 제품 조회 페이지 처음 전체 제품 불러오기
		List<ProductVo> pList = new ServiceProduct().searchAllProduct();
		req.setAttribute("allProductList", pList);
		
		// 카테고리 선택시 선택 카테고리 제품만 불러오기
		if(req.getParameter("categoryNo") != null) {
			int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
			List<ProductVo> cpList = new ServiceProduct().searchSelectedCategoryProduct(categoryNo);
			req.setAttribute("categoryNo", categoryNo);
			req.setAttribute("categoryProductList", cpList);
		}
		
		// 제품 정렬 보류 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//		if(req.getParameter("range") != null) {
//			int range = Integer.parseInt(req.getParameter("range"));
//			List<ProductVo> rList = new ServiceProduct().searchRangeProduct(range);
//		}
		
		// 페이징
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		int maxPage = 5;
		req.setAttribute("maxPage", maxPage);
		
		int startPage = Integer.parseInt(currentPage) - 3;
		if(startPage < 0) startPage = 1;
		int endPage = startPage + 5;
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
//		List<ProductVo> pagingList = new ServiceProduct().paging()
		
		
		req.getRequestDispatcher("/WEB-INF/views/product/searchProduct.jsp").forward(req, resp);
	}
}
