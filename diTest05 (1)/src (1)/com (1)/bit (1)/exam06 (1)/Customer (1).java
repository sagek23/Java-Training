package com.bit.exam06;

public class Customer {
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	public void setCustid(int custid) {
		this.custid = custid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void info()
	{
		System.out.println("***고객정보***");
		System.out.println("고객번호: "+custid);
		System.out.println("고객명: "+name);
		System.out.println("주소: "+address);
		System.out.println("전화번호: "+phone);	
	}
}
