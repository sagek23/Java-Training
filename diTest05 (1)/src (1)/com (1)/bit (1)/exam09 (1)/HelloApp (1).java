package com.bit.exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam09/beans.xml");
		WriteArticleServiceImp wa = (WriteArticleServiceImp)ac.getBean("wa");
		wa.insert();
	}

}
