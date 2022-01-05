package com.yakcook.paymentDetail.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class paymentVo {
	private int orderNo;
	private String userId;
	private String userName;
	private String userPhone;
	private String postNo;
	private String address;
	private String detailAddress;
	private String extraAddress;
	private String memo;
	private String memoInput;
	private Date orderDate;
	private String status;
	private String payMethod;
	private ArrayList<payProductVo> payProduct = new ArrayList<payProductVo>();
	private int totalAll;
	
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMemoInput() {
		return memoInput;
	}
	public void setMemoInput(String memoInput) {
		this.memoInput = memoInput;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<payProductVo> getPayProduct() {
		return payProduct;
	}
	public void setPayProduct(ArrayList<payProductVo> payProduct) {
		this.payProduct = payProduct;
	}
	public int getTotalAll() {
		for(payProductVo pv : this.payProduct) {
			this.totalAll += pv.getTotal();
		}
		return totalAll;
	}
	public String writeDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String writeDay = formatter.format(orderDate);
		return writeDay;
	}
	
	
}
