package com.bit.dao;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	public void insert(String name)
	{
		System.out.println(name+"�� ������ ����Ͽ����ϴ�");
	}
	public List<String> listMember()
	{
		List<String> list = new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("������");
		list.add("������");
		System.out.println("ȸ�����:"+list);
		System.out.println("�� �������ڷ�: "+list.get(100));
		return list;
	}
}
