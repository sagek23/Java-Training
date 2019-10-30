package com.bit.exam14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bit/exam14/beans.xml");
		Person p1 = (Person) ac.getBean("p");
		Person p2 = (Person) ac.getBean("p");
		
		if(p1==p2)
		{
			System.out.println("두개는 동일");
		}
		else
		{
			System.out.println("");
		}
	}

}
