package com.bit.exam12;

public class SystemMonitor {
	private int periodTime; //�⺻�ڷ���
	private SmsSender sender; //�����ڷ���
	
	public SystemMonitor(int periodTime, SmsSender sender) {
		super();
		this.periodTime = periodTime;
		this.sender = sender;
	}

	public void monitor()
	{
		System.out.println(periodTime+"�� ��������");
		sender.send();
	}
}
