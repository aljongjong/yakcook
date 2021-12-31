package com.yakcook.payment.vo;

public class PaymentVo {
	
	private String order;
	private String phone1;
	private String phone2;
	private String phone3;
	private String postcode;
	private String address;
	private String detailaddress;
	private String extra;
	private String memo_option;
	private String input_memo;
	
	
	
	public PaymentVo() {
		this.order = order;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.postcode = postcode;
		this.address = address;
		this.detailaddress = detailaddress;
		this.extra = extra;
		this.memo_option = memo_option;
		this.input_memo = input_memo;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getMemo_option() {
		return memo_option;
	}
	public void setMemo_option(String memo_option) {
		this.memo_option = memo_option;
	}
	public String getInput_memo() {
		return input_memo;
	}
	public void setInput_memo(String input_memo) {
		this.input_memo = input_memo;
	}
	
}