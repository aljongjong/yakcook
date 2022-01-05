package com.yakcook.paymentDetail.model.vo;

public class payProductVo {
	private String productName;
	private int productPrice;
	private int quantity;
	private int total;
	
	public payProductVo() {
		
	}
	
	public payProductVo(String productName, int productPrice, int quantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		total = productPrice * quantity;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}
	
	
}
