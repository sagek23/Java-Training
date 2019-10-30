package com.bit.exam6;

import java.util.Random;

public class Manufacturer extends Thread{
	Product prod;
	public Manufacturer(Product prod) {
		// TODO Auto-generated constructor stub
		this.prod = prod;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		for(int i=1;i<=10;i++)
		{
			prod.makeNum();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
		}

		}
		
	}
	
	
	
}
