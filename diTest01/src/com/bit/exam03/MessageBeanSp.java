package com.bit.exam03;

import com.bit.exam02.MessageBean;

public class MessageBeanSp implements MessageBean {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("Hola"+" "+name);
	}

}
