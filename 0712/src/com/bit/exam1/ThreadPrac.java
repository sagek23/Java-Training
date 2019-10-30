package com.bit.exam1;

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
			System.out.println(i+"초 전입니다");

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		(new ThreadPrac()).start();
	
			
	}
}
