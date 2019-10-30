package com.bit.exam03;

public class Customer {
	private int custid;
	private String name;
	private String address;
	private String phone;
	public Customer(int custid, String name, String address, String phone) {
		super();
		this.custid = custid;
		this.name = name;
		this.address = address;
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
