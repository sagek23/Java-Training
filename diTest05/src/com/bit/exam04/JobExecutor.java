package com.bit.exam04;

public class JobExecutor {
	public JobExecutor(String name, int seconds)
	{
		System.out.println("������ȣ��1");
	}
	public JobExecutor(String name, long seconds)
	{
		System.out.println("������ȣ��2");
	}
	public JobExecutor(String name, String seconds)
	{
		System.out.println("������ȣ��3");
	}
	
	public void pro()
	{
		System.out.println("JobExecutor�� pro");
	}
}
