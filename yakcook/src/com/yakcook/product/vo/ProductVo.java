package com.yakcook.product.vo;

import java.sql.Timestamp;
import java.util.Date;

public class ProductVo {
	
	private int productNo;
	private String productName;
	private int price;
	private Date categoryDate;
	private String productContents;
	private String productDelete;
	private Date lasteditDate;
	private int inventory;
	private int categoryNo;
	private String tagName;
	private String categoryName;
	private int productSum;
	
	
	
	
	public ProductVo() {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.categoryDate = categoryDate;
		this.productContents = productContents;
		this.productDelete = productDelete;
		this.lasteditDate = lasteditDate;
		this.inventory = inventory;
		this.categoryNo = categoryNo;
		this.tagName = tagName;
		this.categoryName = categoryName;
		this.productSum = productSum;
	}
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
	public Date getCategoryDate() {
		return categoryDate;
	}
	public void setCategoryDate(Date categoryDate) {
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
	public Date getLasteditDate() {
		return lasteditDate;
	}
	public void setLasteditDate(Date lasteditDate) {
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
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getProductSum() {
		return productSum;
	}
	public void setProductSum(int productSum) {
		this.productSum = productSum;
	}
	
}