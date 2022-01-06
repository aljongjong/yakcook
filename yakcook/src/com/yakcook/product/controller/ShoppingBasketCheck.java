package com.yakcook.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.member.model.vo.MemberVo;
import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.MemberCheckVo;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.product.vo.ShoppingBasketVo;

@WebServlet("/shoppingBasketCheck")
public class ShoppingBasketCheck extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(); 
		String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
		int loginUserNo = new ServiceProduct().getMemberNoForShoppingBasket(loginUserId);
		MemberCheckVo mv = new MemberCheckVo();
		mv.setMemberNo(loginUserNo);
		mv.setId(loginUserId);
		
		// 확인 회원 정보가져와서 그 회원에 대한 장바구니 생성
		ShoppingBasketVo sv = new ServiceProduct().shoppingBasket(mv);
		
//		장바구니에 이미 있는 제품있는지 확인 (있으면 메시지도 날려주기)
		int result = new ServiceProduct().checkMyShoppingBasket(sv);
		
		List<ShoppingBasketProVo> list = new ArrayList<>();
		List<ProductImgVo> piList = new ArrayList<>();
		List<ProductVo> pList = new ArrayList<>();
		int totalProductPrice = 0;
		if(result > 0) {
			// 장바구니에 제품이 있으면 그 제품들 조회해서 리턴
			list = new ServiceProduct().searchAllProductInMyShoppingBasket(sv);
					
					
			// 제품 이미지 불러오기
			piList = new ServiceProduct().searchAllProductImg();
			req.setAttribute("productImgList", piList);
			
			// 제품 조회 페이지 처음 전체 제품 불러오기
			pList = new ServiceProduct().searchAllProduct();
			req.setAttribute("allProductList", pList);
			
			// 장바구니에 담긴 총 상품 금액 불러오기
			totalProductPrice = new ServiceProduct().totalProductPrcie(sv);
			req.setAttribute("totalProductPrice", totalProductPrice);
			
			req.setAttribute("shoppingBasket", list);
			req.setAttribute("sv", sv);
			req.getRequestDispatcher("/WEB-INF/views/product/shoppingBasket.jsp").forward(req, resp);
		} else {
			// 장바구니에 제품 없으면 빈 장바구니로 이동
			req.setAttribute("msg", "장바구니가 비었습니다.");
			req.getRequestDispatcher("/WEB-INF/views/product/deleteAllShoppingBasket.jsp").forward(req, resp);
		}
		
	}
}
