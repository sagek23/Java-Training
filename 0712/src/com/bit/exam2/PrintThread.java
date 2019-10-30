package com.bit.exam2;

public class PrintThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		new Thread(new PrintThread()).start();
	}

}
