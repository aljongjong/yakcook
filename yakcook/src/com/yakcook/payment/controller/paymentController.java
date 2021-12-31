package com.yakcook.payment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.payment.service.PaymentService;
import com.yakcook.payment.vo.PaymentVo;
@WebServlet("/orderinfo")
public class paymentController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	//입력한 주문정보 가져오기
	String order =	req.getParameter("order");
	String phone1 =	req.getParameter("phone1");
	String phone2 =	req.getParameter("phone2");
	String phone3 =	req.getParameter("phone3");
	
	
	String postcode =  req.getParameter("postcode");
	String address =  req.getParameter("address");
	String detailaddress =  req.getParameter("detailaddress");
	String extra =  req.getParameter("extra");
	
	String memo_option = req.getParameter("memo_option");
	String input_memo = req.getParameter("input_memo");
	System.out.println(address);
	
	PaymentVo p = new PaymentVo();
	p.setOrder(order);
	p.setPhone1(phone1);
	p.setPhone2(phone2);
	p.setPhone3(phone3);
	p.setPostcode(postcode);
	p.setAddress(address);	
	p.setDetailaddress(detailaddress);
	p.setExtra(extra);
	p.setMemo_option(memo_option);
	p.setInput_memo(input_memo);
	
	
	int result = new PaymentService().insertOrder(p);
	
	
	}
}
