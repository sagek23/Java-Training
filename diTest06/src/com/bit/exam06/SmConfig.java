package com.bit.exam06;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmConfig {
	@Bean (autowire = Autowire.BY_TYPE)
	public SystemMonitor sm()
	{
		SystemMonitor s = new SystemMonitor();
		s.setPeriodTime(1);
		return s;
	}
}
