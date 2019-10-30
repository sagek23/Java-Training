package com.bit.exam4;

public class Account {

	int balance;
	
	public synchronized void deposit(int ammount)
	{
		balance +=ammount;
	}
	
	public int getBalance() {
		
		return balance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
