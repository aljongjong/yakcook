package com.yakcook.serviceManage.model.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class QNAVo {
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private String managerId;
	private String userId;
	private String qnaCategory;
	private String managerQuestion;
	private int managerNo;
	private Timestamp qnaDate;
	
	
	public Timestamp getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Timestamp qnaDate) {
		this.qnaDate = qnaDate;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQnaCategory() {
		return qnaCategory;
	}
	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}
	public String getManagerQuestion() {
		return managerQuestion;
	}
	public void setManagerQuestion(String managerQuestion) {
		this.managerQuestion = managerQuestion;
	}
	public String writeDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String writeDay = formatter.format(qnaDate);
		return writeDay;
	}
	public int getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}
	
	
}
