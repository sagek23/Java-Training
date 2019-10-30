package com.bit.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService ms()
	{
		MemberService m = new MemberService();
		m.setInfo(ui());
		return m;
	}
	
	@Bean
	public UpdateInfo ui()
	{
		UpdateInfo info = new UpdateInfo();
		info.setId("tiger");
		return info;
	}
}
