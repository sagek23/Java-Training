package com.bit.exam02;

public class MemberService {
	private Member member;

	public MemberService(Member member) { //member �ʱ�ȭ
		super();
		this.member = member;
	}
	
	public void service()
	{
		member.info();
	}
}
