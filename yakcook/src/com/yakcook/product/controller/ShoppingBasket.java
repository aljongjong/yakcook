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

import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.MemberVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.product.vo.ShoppingBasketVo;

@WebServlet("/shoppingBasket")
public class ShoppingBasket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String productNo = req.getParameter("productNo");
		String price = req.getParameter("price");
		String categoryNo = req.getParameter("categoryNo");
		String productName = req.getParameter("productName");
		String amount = req.getParameter("amount");
		
		ProductVo pv = new ProductVo();
		pv.setProductNo(Integer.parseInt(productNo));
		pv.setPrice(Integer.parseInt(price));
		pv.setCategoryNo(Integer.parseInt(categoryNo));
		pv.setProductName(productName);
		pv.setInventory(Integer.parseInt(amount));
		
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
		
		
//		장바구니에 이미 있는 제품인지 확인 (있으면 메시지도 날려주기)
		int result = new ServiceProduct().checkMyShoppingBasket(sv, pv);
		
//		가져온 장바구니 번호에 제품 넣기 , 장바구니에 그 제품이 없을때
		List<ShoppingBasketProVo> list = new ArrayList<>();
		if(result != 0) {
			list = new ServiceProduct().putShoopingBasket(sv, pv);
		}
		
		req.setAttribute("shoppingBasket", list);
		req.setAttribute("pv", pv);
		
		req.getRequestDispatcher("/WEB-INF/views/product/shoppingBasket.jsp").forward(req, resp);
	}
}
