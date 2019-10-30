package com.bit.dao;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	public void insert(String name)
	{
		System.out.println(name+"의 정보를 등록하였습니다");
	}
	public List<String> listMember()
	{
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("유관순");
		list.add("강감찬");
		System.out.println("회원목록:"+list);
		System.out.println("맨 마지막자료: "+list.get(100));
		return list;
	}
}
