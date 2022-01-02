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
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;

@WebServlet("/tagSearchProduct")
public class TagSearchProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tagName = req.getParameter("tagName");
		
		System.out.println("tagName:" + tagName);
		req.setAttribute("tagName", tagName);
		
		// 같은 태그를 가지고 있는 제품들 검색 후 리턴
		List<ProductVo> list = new ArrayList<>();
		list = new ServiceProduct().tagSearchProduct(tagName);
		
		if(list.size() > 0) {
			req.setAttribute("tagSearchList", list);
		} else {
			req.setAttribute("msg", "검색한 태그 결과가 없습니다.");
		}
		
		// 제품 이미지 불러오기
		List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
		req.setAttribute("productImgList", piList);
		
		// 태그 매치
		List<ProductVo> tagProductList = new ServiceProduct().tagProductList();
		req.setAttribute("tagProductList", tagProductList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/product/tagSearchProduct.jsp").forward(req, resp);
	}
}
