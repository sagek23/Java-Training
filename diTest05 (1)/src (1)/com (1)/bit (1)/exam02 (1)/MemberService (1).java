package com.bit.exam02;

public class MemberService {
	private Member member;

	public MemberService(Member member) { //member √ ±‚»≠
		super();
		this.member = member;
	}
	
	public void service()
	{
		member.info();
	}
}
