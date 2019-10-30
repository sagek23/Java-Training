package com.bit.exam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam12/beans.xml");
		SystemMonitor sm = (SystemMonitor) ac.getBean("sm");
		sm.monitor();
	}

}
