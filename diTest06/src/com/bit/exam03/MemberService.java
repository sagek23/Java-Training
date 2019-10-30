package com.bit.exam03;

public class MemberService {
	private MemberDao md;
	private String name;
	private int age;

	public MemberService(MemberDao md, String name, int age) {
		super();
		this.md = md;
		this.name = name;
		this.age = age;
	}
	
	public void service()
	{
		md.info();
		System.out.println("이름: "+name );
		System.out.println("나이: "+age );
	}
}