package com.bit.exam5;

public class Consumer extends Thread {
	Product prod;
	public Consumer(Product prod)
	{
		this.prod = prod;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=1;i<=10;i++)
		{
			prod.useNum();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
