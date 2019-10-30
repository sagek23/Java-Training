package com.bit.exam16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		Person p = ac.getBean("p", Person.class);
		//p.setName("ȫ�浿");
	//	p.setAge(20);
		p.info();
	}

}
