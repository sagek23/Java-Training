package com.bit.exam02;

public class Member {
	private String name;
	private int age;
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void info() 
	{
		System.out.println("�̸�: "+name);
		System.out.println("����: "+age);
	}
}
