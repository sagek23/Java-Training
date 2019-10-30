package com.bit.exam02;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageBean ob = null;
		org.springframework.core.io.Resource resource = new FileSystemResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		ob = (MessageBean)factory.getBean("mb");
		ob.sayHello("Xavi");
	}

}
