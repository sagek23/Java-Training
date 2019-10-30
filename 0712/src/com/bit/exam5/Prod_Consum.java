package com.bit.exam5;

public class Prod_Consum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product();
		Manufacturer mf = new Manufacturer(product);
		Consumer consumer = new Consumer(product);
		
		mf.start();
		consumer.start();
	}

}
