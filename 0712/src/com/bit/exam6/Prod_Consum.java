package com.bit.exam6;

public class Prod_Consum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product prod = new Product();
		Manufacturer mf = new Manufacturer(prod);
		Consumer consumer = new Consumer(prod);
		
		mf.start();
		consumer.start();
	}

}
