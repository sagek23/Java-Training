package com.bit.exam07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		SystemMonitor s1 = (SystemMonitor)ac.getBean("sm");
		SystemMonitor s2 = (SystemMonitor)ac.getBean("sm");
		if(s1 == s2)
		{
			System.out.println("동일");
		}
		else
		{
			System.out.println("다름");
		}
	}

}
