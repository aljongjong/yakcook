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
		
		
		String orderId = req.getParameter("orderId");

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(
						"https://api.tosspayments.com/v1/payments/test_sk_YoEjb0gm23Pd17W2qek3pGwBJn5e"))
				.header("Authorization", "Basic dGVzdF9za196WExrS0V5cE5BcldtbzUwblgzbG1lYXhZRzVSOg==")
				.header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString("{\"amount\":15000,\"orderId\":\"K2eeCEJEuzKbfV1MEoO4N\"}"))
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