package com.bit.exam02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public SmsSender sms()
	{
		SmsSender ss = new SmsSender();
		ss.setFrom("����");
		ss.setTo("����");
		return ss;
	}
	@Bean
	public SystemMonitor sm()
	{
		SystemMonitor sym = new SystemMonitor();
		sym.setPeriodTime(1);
		sym.setSender(sms());
		return sym;
	}
}
