package com.yakcook.review.vo;

public class deleteReviewVo {
	private String reviewNo;
	private String reviewTitle;
	private String contents;
	private String reviewDate;
	private String writer;
	
	
	public deleteReviewVo() {
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.contents = contents;
		this.reviewDate = reviewDate;
		this.writer = writer;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
