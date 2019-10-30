package com.bit.bookStore.vo;

public class MailVo {
	private String id;
	private String email;
	private int pay;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public MailVo(String id, String email, int pay) {
		super();
		this.id = id;
		this.email = email;
		this.pay = pay;
	}
	public MailVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
