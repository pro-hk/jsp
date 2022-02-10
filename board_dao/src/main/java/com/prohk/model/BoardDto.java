package com.prohk.model;

public class BoardDto {
	private int no;
	private String name;
	private String subject;
	private String email;
	private String password;
	private String contents;
	private String regdate;
	private int hit;
	
	public BoardDto() {}

	public BoardDto(int no, String name, String subject, String email, String password, String contents, String regdate,
			int hit) {
		super();
		this.no = no;
		this.name = name;
		this.subject = subject;
		this.email = email;
		this.password = password;
		this.contents = contents;
		this.regdate = regdate;
		this.hit = hit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String eamil) {
		this.email = eamil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", name=" + name + ", subject=" + subject + ", email=" + email + ", password="
				+ password + ", contents=" + contents + ", regdate=" + regdate + ", hit=" + hit + "]";
	}
}
