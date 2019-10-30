package com.bit.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(SmConfig.class, SmsConfig.class);
	
		SystemMonitor s = (SystemMonitor) ac.getBean("sm");
		s.monitor();
	}

}
