package com.bit.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BbsDao;
import com.bit.dao.MemberDao;
import com.bit.util.HelloUtil;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		BbsDao bbsDao = (BbsDao)context.getBean("bbsDao");
		MemberDao memberDao = (MemberDao)context.getBean("memberDao");
		HelloUtil helloUtil = (HelloUtil)context.getBean("helloUtil");
		helloUtil.sayHello("벨로");
		bbsDao.insert();
		memberDao.insert("만두");
		List<String> list = memberDao.listMember();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}

}
