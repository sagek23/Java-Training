package com.bit.exam07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class SpringConfig {
	@Bean(initMethod = "monitor") //���۽� ����� �޼ҵ� �ڵ�����
	@Scope(value = "prototype") //�ι� ����
	public SystemMonitor sm()
	{
		SystemMonitor s = new SystemMonitor();
		s.setPeriodTime(10);
		return s;
	}
}
