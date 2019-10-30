package com.bit.exam1;
/*
 runnable인터페이스를 구현하여 Person과 똑같이 동작하도록 구현
 */
public class Person2 implements Runnable{
	String name;

	public Person2(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("안녕," + name);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	}

	public static void main(String[] args) {
		Person2 p1 = new Person2("홍길동");
		Person2 p2 = new Person2("유관순");
		Thread thr = new Thread(p1);		
		Thread thr2 = new Thread(p2);
		thr.start();
		(new Thread(p2)).start();
	
	}
}
