package com.bit.exam1;
/*
 runnable�������̽��� �����Ͽ� Person�� �Ȱ��� �����ϵ��� ����
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
			System.out.println("�ȳ�," + name);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	}

	public static void main(String[] args) {
		Person2 p1 = new Person2("ȫ�浿");
		Person2 p2 = new Person2("������");
		Thread thr = new Thread(p1);		
		Thread thr2 = new Thread(p2);
		thr.start();
		(new Thread(p2)).start();
	
	}
}
