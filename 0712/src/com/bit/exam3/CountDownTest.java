package com.bit.exam3;

public class CountDownTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPrac t1 = new ThreadPrac();
		CountDownEvent t2 = new CountDownEvent("연결장치분리", 2000);
		t1.start();
		t2.start();
	}

}
