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
			System.out.println(i+"초 전입니다");

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.err.println("발사");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		//(new CountDownEvent("연결장치분리", 2000)).start();
		//(new CountDownEvent("발사", 20000)).start();
		//(new ThreadPrac()).start();
	
			
	}
}
