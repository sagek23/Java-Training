package com.bit.exam6;

import java.util.Random;

public class Product {
	int num;
	int count;
	boolean isNew;
	public synchronized void makeNum()
	{
		
		Random r = new Random();
		num = r.nextInt(100);
		System.out.println("���ο� ���� "+num);
		isNew = true;
		notify(); //�Һ� �ϵ���useNum�� ����
		
		while(isNew==true)
		{
			try {
				wait(); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//if(isNew==false)
				//break;
		}//num�� ����������Ƿ� ���
		
	
		
	}
	public synchronized int useNum() {
		
		System.out.println("�Һ��ڰ� �Һ��� ����: "+num);
		
		isNew = false;
		notify(); //������ ����
		while(isNew==false)
		{
			try {
				wait();//�Һ� �� �Ͽ����Ƿ� ���
			} catch (Exception e) {
				// TODO: handle exception
			}	
		}
		
		
		return num;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
