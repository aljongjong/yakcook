package com.yakcook.member.model.vo;

import java.sql.Timestamp;

public class MemberQnAVo {
	private int qna_no;
	private String user_id;
	private String qna_title;
	private String qna_content;
	private Timestamp qna_date;
	private int manager_number;
	private String qna_category;
	private String manager_answer;

	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Timestamp getQna_date() {
		return qna_date;
	}
	public void setQna_date(Timestamp qna_date) {
		this.qna_date = qna_date;
	}
	public int getManager_number() {
		return manager_number;
	}
	public void setManager_number(int manager_number) {
		this.manager_number = manager_number;
	}
	public String getQna_category() {
		return qna_category;
	}
	public void setQna_category(String qna_category) {
		this.qna_category = qna_category;
	}
	public String getManager_answer() {
		return manager_answer;
	}
	public void setManager_answer(String manager_answer) {
		this.manager_answer = manager_answer;
	}
	
}
