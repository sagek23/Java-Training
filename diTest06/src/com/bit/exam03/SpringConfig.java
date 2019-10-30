package com.bit.exam03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public MemberDao md()
	{
		MemberDao dao = new MemberDao();
		dao.setUrl("aaa");
		dao.setUser("c##madang");
		dao.setPwd("madang");
		return dao;
	}
	@Bean
	public MemberService ms()
	{
		MemberService m = new MemberService(md(), "ȫ�浿", 20);
		return m;
	}
}
