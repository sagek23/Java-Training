package com.bit.exam3;

import java.util.concurrent.Delayed;

public class CountDownEvent extends Thread {
	String msg;
	int delay;
	public CountDownEvent(String msg, int delay) {
		super();
		this.msg = msg;
		this.delay = delay;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//	super.run();
		try {
			Thread.sleep(delay);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(msg);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new CountDownEvent("연결장치분리", 2000)).start();
	}

}
