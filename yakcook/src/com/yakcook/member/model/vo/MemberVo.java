package com.yakcook.member.model.vo;

import java.sql.Timestamp;

public class MemberVo {
	private int memberNo;
	private String id;
	private String pwd;
	private String name;
	private int detail;
	private Timestamp enrollDate;
	private Timestamp modifyDate;
	private String openYn;
	private String email;
	private String phone;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDetail() {
		return detail;
	}
	public void setDetail(int detail) {
		this.detail = detail;
	}
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	} 
}