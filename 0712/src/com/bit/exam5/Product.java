package com.bit.exam5;

import java.util.Random;

public class Product {
	int num;
	boolean isNew;
	public synchronized void makeNum()
	{
		Random r = new Random();
		num = r.nextInt(100);
		System.out.println("���ο� ���� "+num);
		
	}
	public synchronized int useNum() {
		System.out.println("�Һ��ڰ� �Һ��� ����: "+num);
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
