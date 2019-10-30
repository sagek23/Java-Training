package com.bit.authentication.vo;

public class SmsVo {
	
	private String id;
	private String email;
	private int pay;
	private String phone;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public SmsVo(String id, String email, int pay, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.pay = pay;
		this.phone = phone;
	}

	public SmsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
