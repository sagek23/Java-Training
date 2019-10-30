package com.bit.exam05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
	@Bean
	public Person person()
	{
		Person p = new Person();
		p.setName("ȫ�浿");
		p.setAge(20);
		return p;
	}
}
