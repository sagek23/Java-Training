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
		System.out.println("***������***");
		System.out.println("����ȣ: "+custid);
		System.out.println("����: "+name);
		System.out.println("�ּ�: "+address);
		System.out.println("��ȭ��ȣ: "+phone);	
	}
}
