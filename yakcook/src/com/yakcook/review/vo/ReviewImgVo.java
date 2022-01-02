package com.yakcook.review.vo;

import java.sql.Timestamp;

public class ReviewImgVo {
	
	private String imgServerFile1;
	private String imgServerFile2;
	private String imgServerFile3;
	private Timestamp imgDate;
	private String imgDelete;
	
	
	
	public ReviewImgVo() {
		this.imgServerFile1 = imgServerFile1;
		this.imgServerFile2 = imgServerFile2;
		this.imgServerFile3 = imgServerFile3;
		this.imgDate = imgDate;
		this.imgDelete = imgDelete;
	}
	public String getImgServerFile1() {
		return imgServerFile1;
	}
	public void setImgServerFile1(String imgServerFile1) {
		this.imgServerFile1 = imgServerFile1;
	}
	public String getImgServerFile2() {
		return imgServerFile2;
	}
	public void setImgServerFile2(String imgServerFile2) {
		this.imgServerFile2 = imgServerFile2;
	}
	public String getImgServerFile3() {
		return imgServerFile3;
	}
	public void setImgServerFile3(String imgServerFile3) {
		this.imgServerFile3 = imgServerFile3;
	}
	public Timestamp getImgDate() {
		return imgDate;
	}
	public void setImgDate(Timestamp imgDate) {
		this.imgDate = imgDate;
	}
	public String getImgDelete() {
		return imgDelete;
	}
	public void setImgDelete(String imgDelete) {
		this.imgDelete = imgDelete;
	}
	
}
	