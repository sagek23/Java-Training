package com.bit.exam16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public Person p() //p�� id
	{
		Person p = new Person();
		p.setAge(20);
		p.setName("ȫ�浿");
		return p;
	}
}
