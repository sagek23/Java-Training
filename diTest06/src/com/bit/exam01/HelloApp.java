package com.bit.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		//new ClassPathXmlApplicationContext("com/bit/exam01/beans.xml");
		MemberService ms = (MemberService) ac.getBean("ms");
		ms.update("lion");
	}

}
