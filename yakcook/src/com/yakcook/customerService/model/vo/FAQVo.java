package com.yakcook.customerService.model.vo;

import java.sql.Timestamp;

public class FAQVo {
	private int faqNumber;
	private int managerNumber;
	private String category;
	private String faqTitle;
	private String faqContent;
	private Timestamp writeDate;
	private Timestamp modifyDate;
	private String DELETE_YN;
	
	public FAQVo() {
		
	}
	
	
	
	public FAQVo(int faqNumber, int managerNumber, String category, String faqTitle, String faqContent,
			Timestamp writeDate, Timestamp modifyDate, String dELETE_YN) {
		this.faqNumber = faqNumber;
		this.managerNumber = managerNumber;
		this.category = category;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.writeDate = writeDate;
		this.modifyDate = modifyDate;
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
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getDELETE_YN() {
		return DELETE_YN;
	}
	public void setDELETE_YN(String dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}
	
	
}
