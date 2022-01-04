package com.yakcook.review.vo;

import java.sql.Timestamp;

public class ReviewListVo {
	private int reviewNo;
	private String reviewTitle;
	private String reviewContents;
	private Timestamp reviewDate;
	private String userId;
	private int reviewLike;
	private int reviewDeclaration;
	private int reviewViews;
	private String reviewDelete;
	private String reviewImg;
	
	
	
	public ReviewListVo() {
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
		this.userId = userId;
		this.reviewLike = reviewLike;
		this.reviewDeclaration = reviewDeclaration;
		this.reviewViews = reviewViews;
		this.reviewDelete = reviewDelete;
		this.reviewImg = reviewImg;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public Timestamp getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getReviewLike() {
		return reviewLike;
	}
	public void setReviewLike(int reviewLike) {
		this.reviewLike = reviewLike;
	}
	public int getReviewDeclaration() {
		return reviewDeclaration;
	}
	public void setReviewDeclaration(int reviewDeclaration) {
		this.reviewDeclaration = reviewDeclaration;
	}
	public int getReviewViews() {
		return reviewViews;
	}
	public void setReviewViews(int reviewViews) {
		this.reviewViews = reviewViews;
	}
	public String getReviewDelete() {
		return reviewDelete;
	}
	public void setReviewDelete(String reviewDelete) {
		this.reviewDelete = reviewDelete;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	
	
}