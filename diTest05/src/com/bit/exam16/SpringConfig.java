package com.bit.exam16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public Person p() //p´Â id
	{
		Person p = new Person();
		p.setAge(20);
		p.setName("È«±æµ¿");
		return p;
	}
}
