package com.bit.exam01;

public class MemberService {
	private UpdateInfo info;

	public void setInfo(UpdateInfo info) {
		this.info = info;
	}
	public boolean update(String memberId)
	{
		System.out.println(memberId+"�� ������ "+info.getId()+"�� �����Ͽ����ϴ�");
		return true;
	}
}
