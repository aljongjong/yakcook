package com.yakcook.customerService.model.vo;

import java.sql.Timestamp;

public class FAQVo {
	private int faqNumber;
	private int managerNumber;
	private String category;
	private String faqTitle;
	private String faqContent;
	private String DELETE_YN;
	
	public FAQVo() {
		
	}
	
	
	
	public FAQVo(int faqNumber, int managerNumber, String category, String faqTitle, String faqContent, String dELETE_YN) {
		this.faqNumber = faqNumber;
		this.managerNumber = managerNumber;
		this.category = category;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.DELETE_YN = dELETE_YN;
	}



	public int getFaqNumber() {
		return faqNumber;
	}
	public void setFaqNumber(int faqNumber) {
		this.faqNumber = faqNumber;
	}
	public int getManagerNumber() {
		return managerNumber;
	}
	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getDELETE_YN() {
		return DELETE_YN;
	}
	public void setDELETE_YN(String dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}
	
	
}
