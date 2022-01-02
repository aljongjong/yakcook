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
import com.yakcook.product.vo.MemberVo;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.product.vo.ShoppingBasketVo;

@WebServlet("/updateShoppingBasket")
public class UpdateShoppingBasket extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int shoppingBasketNo = Integer.parseInt(req.getParameter("shoppingBasketNo"));
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		int changeInventory = Integer.parseInt(req.getParameter("changeInventory"));
		
		System.out.println("수정한 장바구니번호 : " + shoppingBasketNo);
		System.out.println("수정한 제품번호 : " + productNo);
		System.out.println("수정한 제품수량 : " + changeInventory);
		
		ShoppingBasketProVo sbp = new ShoppingBasketProVo();
		sbp.setProductNo(productNo);
		sbp.setShoppingBasketNo(shoppingBasketNo);
		sbp.setInventory(changeInventory);
		
		List<ShoppingBasketProVo> list = new ArrayList<>();
		list = new ServiceProduct().updateShoppingBasket(sbp);
		
		int memberNo = 1;
		String name = "YC";
//		회원정보 받아왔다고 생각하고
//		int memberNo = Integer.parseInt(req.getParameter("id"));
//		String name = req.getParameter("name");
		MemberVo mv = new MemberVo();
		mv.setMemberNo(memberNo);
		mv.setName(name);
		
//		나중에 합칠때 미리님 서블릿으로 이용 회원 확인 회원 정보가져와서 그 회원에 대한 장바구니 생성
		ShoppingBasketVo sv = new ServiceProduct().shoppingBasket(mv);
		
		// 제품 이미지 불러오기
		List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
		req.setAttribute("productImgList", piList);
		
		// 제품 조회 페이지 처음 전체 제품 불러오기
		List<ProductVo> pList = new ServiceProduct().searchAllProduct();
		req.setAttribute("allProductList", pList);
		
		// 장바구니에 담긴 총 상품 금액 불러오기
		int totalProductPrice = new ServiceProduct().totalProductPrcie(sv);
		req.setAttribute("totalProductPrice", totalProductPrice);
		
		req.setAttribute("shoppingBasket", list);
		req.setAttribute("sv", sv);

		req.getRequestDispatcher("/WEB-INF/views/product/shoppingBasket.jsp").forward(req, resp);
	}
}