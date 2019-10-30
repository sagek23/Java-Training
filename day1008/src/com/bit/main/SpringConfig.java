package com.bit.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bit.advice.ProfilingAdvice;
import com.bit.dao.BbsDao;
import com.bit.dao.MemberDao;
import com.bit.util.HelloUtil;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
	@Bean
	public ProfilingAdvice pro()
	{
		return new ProfilingAdvice();
	}
	
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	@Bean
	public BbsDao bbsDao()
	{
		return new BbsDao();
	}
	@Bean
	public HelloUtil helloUtil()
	{
		return new HelloUtil();
	}
}
