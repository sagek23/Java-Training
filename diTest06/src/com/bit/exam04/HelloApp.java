package com.bit.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		SystemMonitor sm = (SystemMonitor) ac.getBean("sm");
		sm.monitor();
	}

}
