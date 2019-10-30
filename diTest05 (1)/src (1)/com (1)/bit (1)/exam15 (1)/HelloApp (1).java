package com.bit.exam15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		MemberService m = ac.getBean("member1", MemberService.class); //메소드이름이 id
		m.update("tiger");
	}

}
