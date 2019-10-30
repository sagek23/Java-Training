package com.bit.exam11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam11/beans.xml");
		WriteArticleService wa = (WriteArticleService)ac.getBean("ws");
		wa.insert();
	}

}
