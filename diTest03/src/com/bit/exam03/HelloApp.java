package com.bit.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageBean ob = null;
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/exam03/beans.xml");
		ob=(MessageBean)context.getBean("mb");
		ob.sayHello("±æµ¿");
		
	}

}
