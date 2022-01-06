package com.yakcook.payment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.member.model.vo.MemberVo;
import com.yakcook.payment.service.PaymentService;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.product.vo.ShoppingBasketVo;
import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.ReviewListVo;

@WebServlet("/payment")

public class PaymentPageController extends HttpServlet {

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String productNo = req.getParameter("productNo");
		String amount = req.getParameter("amount");
		String totalPrice = req.getParameter("totalPrice");
		String defaultPrice = req.getParameter("defaultPrice");
		req.setAttribute("productNo", productNo);
		
		req.setAttribute("amount", amount);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("defaultPrice", defaultPrice);
		List<ProductVo> productList = new PaymentService().selectList(productNo);
		req.setAttribute("productList", productList);
		req.setAttribute("itemList", productList.get(0).getProductName());
		
		
		
		req.getRequestDispatcher("WEB-INF/views/payment/payment.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String shoppingBagNo = req.getParameter("shoppingBagNo");
		String defaultPrice = req.getParameter("defaultPrice");
		
		List<ProductVo> shoppingList = new PaymentService().selectShoppingBag(shoppingBagNo);
		int totalPrice = 0;
		int productCount = shoppingList.size();
		String itemList = "";
		for(int i=0;i < productCount ;i++) {
			totalPrice += shoppingList.get(i).getProductSum();
			if(i==productCount-1) {
				itemList += shoppingList.get(i).getProductName();
				break;
			}
			itemList += shoppingList.get(i).getProductName()+", ";
//			totalPrice = totalPrice + ;
		}
		System.out.println(itemList);
		req.setAttribute("shoppingList", shoppingList);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("defaultPrice", defaultPrice);
		req.setAttribute("itemList",itemList);
		req.getRequestDispatcher("WEB-INF/views/payment/payment.jsp").forward(req, resp);
	}

}
