package com.yakcook.serviceManage.model.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class noticeVo {
	private int noticeNo;
	private int managerNo;
	private String noticeTitle;
	private String noticeContent;
	private Timestamp writeDate;

	public noticeVo() {
		
	}
	
	public noticeVo(int noticeNo, int managerNo, String noticeTitle, String noticeContent, Timestamp writeDate) {
		this.noticeNo = noticeNo;
		this.managerNo = managerNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.writeDate = writeDate;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public int getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public String writeDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String writeDay = formatter.format(writeDate);
		return writeDay;
	}
	
	
}
