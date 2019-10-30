package com.bit.exam12;

public class SystemMonitor {
	private int periodTime; //기본자료형
	private SmsSender sender; //참조자료형
	
	public SystemMonitor(int periodTime, SmsSender sender) {
		super();
		this.periodTime = periodTime;
		this.sender = sender;
	}

	public void monitor()
	{
		System.out.println(periodTime+"분 간격으로");
		sender.send();
	}
}
