package com.yakcook.manager.model.vo;

public class managerVo {
	private int managerNo;
	private String managerId;
	private String managerPwd;
	private int managerLevel;
	private int check = 0;
	
	public managerVo(int managerNo, String managerId, String managerPwd, int managerLevel) {
		this.managerNo = managerNo;
		this.managerId = managerId;
		this.managerPwd = managerPwd;
		this.managerLevel = managerLevel;
	}
	public managerVo() {
		
	}
	
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public int getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	public int getManagerLevel() {
		return managerLevel;
	}
	public void setManagerLevel(int managerLevel) {
		this.managerLevel = managerLevel;
	}
	
	
}
