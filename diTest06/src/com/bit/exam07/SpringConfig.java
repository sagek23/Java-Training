package com.bit.exam07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class SpringConfig {
	@Bean(initMethod = "monitor") //시작시 모니터 메소드 자동동작
	@Scope(value = "prototype") //두번 동작
	public SystemMonitor sm()
	{
		SystemMonitor s = new SystemMonitor();
		s.setPeriodTime(10);
		return s;
	}
}
