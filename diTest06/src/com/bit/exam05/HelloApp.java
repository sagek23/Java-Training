package com.bit.exam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig.class, DaoCofig.class);
		MemberDao m = (MemberDao)ac.getBean("dao");
		m.insert();
		BbsDao b = (BbsDao)ac.getBean("bd");
		b.insert();
		Person p = (Person)ac.getBean("person");
		p.info();
	}

}
