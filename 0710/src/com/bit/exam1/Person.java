package com.bit.exam1;

public class Person extends Thread{
	String name;

	public Person(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("¾È³ç," + name);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("È«±æµ¿");
		Person p2 = new Person("À¯°ü¼ø");
		p1.start();
		p2.start();
	
	}
}
