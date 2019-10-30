package com.bit.exam04;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean 
	public SmsSender sms()
	{
		SmsSender s = new SmsSender();
		s.setFrom("만두");
		s.setTo("벨로");
		return s;
	}
	@Bean (autowire = Autowire.BY_NAME)
	public SystemMonitor sm()
	{
		SystemMonitor sy = new SystemMonitor();
		sy.setPeriodTime(1);
		sy.setSender(sms());
		return sy;
	}
}
