package com.bit.exam01;

public class MemberService {
	private UpdateInfo info;

	public void setInfo(UpdateInfo info) {
		this.info = info;
	}
	public boolean update(String memberId)
	{
		System.out.println(memberId+"의 정보를 "+info.getId()+"로 수정하였습니다");
		return true;
	}
}
