package com.bit.exam1;

public class Person extends Thread {
	String name;
	public Person(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=1;i<=10;i++)
		{
			System.out.println(name+"이/가 사과를"+i+"째 먹어요");
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("우현아");
		Person p2 = new Person("임창성");
		Person p3 = new Person("최민우");
		p1.setPriority(Thread.MAX_PRIORITY);
		p2.setPriority(Thread.MIN_PRIORITY);
		p3.setPriority(Thread.NORM_PRIORITY);
		p1.start();
		p2.start();
		p3.start();
	}

}
