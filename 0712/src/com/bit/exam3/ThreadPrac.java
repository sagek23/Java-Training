package com.bit.exam3;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ThreadPrac extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		for(int i=20;i>0;i--)
		{
			System.out.println(i+"�� ���Դϴ�");

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.err.println("�߻�");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		//(new CountDownEvent("������ġ�и�", 2000)).start();
		//(new CountDownEvent("�߻�", 20000)).start();
		//(new ThreadPrac()).start();
	
			
	}
}
