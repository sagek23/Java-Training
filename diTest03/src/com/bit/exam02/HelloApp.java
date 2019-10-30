package com.bit.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/exam02/beans2.xml");
		System.out.println("2");
		Person p = (Person)context.getBean("p");
		System.out.println("3");
		p.pro();
	}

}
