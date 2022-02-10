package com.prohk.model;

public class NoticeDto {
	private int no;
	private String title;
	private String contents;
	private String regDate;
	
	public NoticeDto() {}

	public NoticeDto(int no, String title, String contents, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "NoticeDto [no=" + no + ", title=" + title + ", contents=" + contents + ", regDate=" + regDate + "]";
	}
}
