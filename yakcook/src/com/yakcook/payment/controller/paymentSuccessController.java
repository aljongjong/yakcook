package com.yakcook.payment.controller;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/paymentSuccess")
public class paymentSuccessController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amount = req.getParameter("amount");
		// amout값과 총상품가격(DB에저장된) 이 같은지 비교를 한다.
		String paymentKey = req.getParameter("paymentKey");
		
		String orderId = req.getParameter("orderId");
		String method = req.getParameter("method");

		if(method.equals("가상계좌")) {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://api.tosspayments.com/v1/virtual-accounts"))
					.header("Authorization", "Basic dGVzdF9za19Zb0VqYjBnbTIzUGQxN1cycWVrM3BHd0JKbjVlOg==")
					.header("Content-Type", "application/json")
					.method("POST", HttpRequest.BodyPublishers.ofString("{\"amount\":"+amount+",\"orderId\":\""+orderId+"\",\"orderName\":\"토스 티셔츠 외 2건\",\"customerName\":\"박토스\",\"bank\":\"우리\"}"))
				    .build();
			HttpResponse<String> response;
			try {
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				System.out.println(response.body());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(method.equals("카드")) {
			HttpRequest request = HttpRequest.newBuilder()
				    .uri(URI.create("https://api.tosspayments.com/v1/payments/"+paymentKey))
				    .header("Authorization", "Basic dGVzdF9za19Zb0VqYjBnbTIzUGQxN1cycWVrM3BHd0JKbjVlOg==")
				    .header("Content-Type", "application/json")
				    .method("POST", HttpRequest.BodyPublishers.ofString("{\"amount\":"+amount+",\"orderId\":\""+orderId+"\"}"))
				    .build();
			HttpResponse<String> response;
			try {
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				System.out.println(response.body());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}