package com.bit.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	//오라클db를 이용하여 회원등록을 구현
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/exam01/beans.xml");
	MemberDao dao = (MemberDao) context.getBean("dao");
	dao.insertMember();
	}
}
