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
		System.out.println("***������***");
		System.out.println("����ȣ: "+custid);
		System.out.println("����: "+name);
		System.out.println("�ּ�: "+address);
		System.out.println("��ȭ��ȣ: "+phone);	
	}
}
