package com.bit.exam04;

public class Person {
	private String name;
	
	
	
	public Person(String name) {
		super();
		this.name = name;
		System.out.println("생성자 동작");
		System.out.println(this.name);
	}
	/*
	public Person()
	{
		System.out.println("Person의 생성자 동작함");
	}
	*/
	public void pro()
	{
		System.out.println("Person pro");
	}
}
