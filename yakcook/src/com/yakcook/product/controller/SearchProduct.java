package com.yakcook.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;

@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 제품 이미지 불러오기
		List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
		req.setAttribute("productImgList", piList);
		
		// 제품 조회 페이지 좌측 카테고리 불러오기
		List<CategoryVo> cList = new ServiceProduct().searchCategory();
		req.setAttribute("categoryList", cList);
		
		// 제품 조회 페이지 처음 전체 제품 불러오기
		List<ProductVo> pList = new ServiceProduct().searchAllProduct();
		req.setAttribute("allProductList", pList);
		
		// 카테고리 선택시 선택 카테고리 제품만 불러오기
		if(req.getParameter("categoryNo") != null) {
			String currentPage = req.getParameter("currentPage");
			if(currentPage == null) {
				currentPage = "1";
			}
			int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
			List<ProductVo> cpList = new ServiceProduct().searchSelectedCategoryProduct(categoryNo, currentPage);
			req.setAttribute("categoryNo", categoryNo);
			req.setAttribute("categoryProductList", cpList);
		}
		
		
		// 맥스 페이지
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null) {
			currentPage = "1";
		}
		
		if(req.getParameter("categoryNo") != null) {
			int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
			int maxPage = new ServiceProduct().maxPage(categoryNo);
			req.setAttribute("maxPage", maxPage);
		} else {
			int maxPage = new ServiceProduct().maxPage();
			req.setAttribute("maxPage", maxPage);
		}
		
		// 제품 정렬
		List<ProductVo> rList = new ArrayList<>();
		int range = 0; 
		if(req.getParameter("range") != null) {
			range = Integer.parseInt(req.getParameter("range"));
			rList = new ServiceProduct().searchRangeProduct(range);
		}
		req.setAttribute("range", range);			
		req.setAttribute("rangeList", rList);
		
		System.out.println(rList.size());
		
		System.out.println("range : " + range);
		// 다음 페이지 
		int startPage = Integer.parseInt(currentPage) - 2;
		if(startPage <= 0) {
			startPage = 1;
		}
		int endPage = startPage + 5;
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
		List<ProductVo> nextPageList = new ArrayList<>();
		
		if(range == 0) {
			nextPageList = new ServiceProduct().nextPageList(currentPage);
			req.setAttribute("nextPageList", nextPageList);
		} else {
			nextPageList = new ServiceProduct().nextPageListRange(currentPage, range);
			req.setAttribute("nextPageList", nextPageList);
		}
		
		
		// 이전 페이지, 다음 페이지 버튼
		req.setAttribute("cp", currentPage);
		
		// 태그 매치
		List<ProductVo> tagProductList = new ServiceProduct().tagProductList();
		req.setAttribute("tagProductList", tagProductList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/product/searchProduct.jsp").forward(req, resp);
	}
}
