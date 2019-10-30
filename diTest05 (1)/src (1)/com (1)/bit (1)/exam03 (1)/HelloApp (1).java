package com.bit.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam03/beans.xml");
		BookStore b = (BookStore)ac.getBean("bs"); //getBean은 object를 반환하므로 원하는 타입으로 캐스팅
		b.pro();
	}

}
