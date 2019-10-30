package com.bit.exam06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfig {
	@Bean
	public SmsSender sender()
	{
		SmsSender s = new SmsSender();
		s.setFrom("만두");
		s.setTo("벨로");
		return s;
	}
}
