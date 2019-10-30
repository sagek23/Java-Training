package com.bit.exam4;

public class Donator extends Thread {
	String name;
	Account account;
	int depo = 1000;
	public Donator(String name, Account account)
	{
		// TODO Auto-generated constructor stub
		this.name = name;
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		for(int i =1;;i++)
		{
			if(account.balance==3000)
				break;
				
			account.deposit(depo);
			if(i<=4)
			{}
			System.out.println(name+"의"+i+"번째 "+depo+"원 기부");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

	

}
