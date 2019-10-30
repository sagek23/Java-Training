package com.bit.exam08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam08/beans.xml");
		ProtocolHandler ph = (ProtocolHandler) ac.getBean("ph");
		ph.service();
	}

}
