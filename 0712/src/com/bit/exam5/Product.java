package com.bit.exam5;

import java.util.Random;

public class Product {
	int num;
	boolean isNew;
	public synchronized void makeNum()
	{
		Random r = new Random();
		num = r.nextInt(100);
		System.out.println("새로운 정수 "+num);
		
	}
	public synchronized int useNum() {
		System.out.println("소비자가 소비한 정수: "+num);
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
