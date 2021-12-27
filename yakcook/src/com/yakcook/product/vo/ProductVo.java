package com.yakcook.product.vo;

import java.sql.Timestamp;

public class ProductVo {
	
	private int productNo;
	private String productName;
	private int price;
	private Timestamp categoryDate;
	private String productContents;
	private String productDelete;
	private Timestamp lasteditDate;
	private int inventory;
	private int categoryNo;
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getCategoryDate() {
		return categoryDate;
	}
	public void setCategoryDate(Timestamp categoryDate) {
		this.categoryDate = categoryDate;
	}
	public String getProductContents() {
		return productContents;
	}
	public void setProductContents(String productContents) {
		this.productContents = productContents;
	}
	public String getProductDelete() {
		return productDelete;
	}
	public void setProductDelete(String productDelete) {
		this.productDelete = productDelete;
	}
	public Timestamp getLasteditDate() {
		return lasteditDate;
	}
	public void setLasteditDate(Timestamp lasteditDate) {
		this.lasteditDate = lasteditDate;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	
}
