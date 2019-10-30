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
		System.out.println("새로운 정수 "+num);
		isNew = true;
		notify(); //소비를 하도록useNum을 깨움
		
		while(isNew==true)
		{
			try {
				wait(); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//if(isNew==false)
				//break;
		}//num이 만들어졌으므로 대기
		
	
		
	}
	public synchronized int useNum() {
		
		System.out.println("소비자가 소비한 정수: "+num);
		
		isNew = false;
		notify(); //생산을 깨움
		while(isNew==false)
		{
			try {
				wait();//소비를 다 하였으므로 대기
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
