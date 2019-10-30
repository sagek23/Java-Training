package com.bit.exam4;

public class ARS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		Donator d1 = new Donator("Tony",account);
		Donator d2 = new Donator("Peter",account);
		Donator d3 = new Donator("Steve",account);
		Donator d4 = new Donator("Bruce",account);
		Donator d5 = new Donator("Nat",account);
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("¸ð±Ý¾×:"+account.getBalance());
	}

}
