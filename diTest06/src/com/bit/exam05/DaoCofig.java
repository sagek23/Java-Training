package com.bit.exam05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoCofig {
	@Bean
	public MemberDao dao()
	{
		MemberDao m = new MemberDao();
		return m;
	}
	@Bean
	public BbsDao bd()
	{
		BbsDao b = new BbsDao();
		return b;
	}
}
