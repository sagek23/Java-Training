package com.bit.exam10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam10/beans.xml");
		BookStore bs = (BookStore) ac.getBean("bs");
		bs.pro();
	}

}
