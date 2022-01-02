package com.yakcook.review.vo;

import java.sql.Timestamp;

public class ReviewVo {
	private String title;
	private String contents;
	private String writer;
	private String id;
	private Timestamp date;

	public ReviewVo() {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.id = id;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}	
}