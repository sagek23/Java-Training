package com.bit.exam07;

public class SystemMonitor {
	private int periodTime;

	public void setPeriodTime(int periodTime) {
		this.periodTime = periodTime;
	}
	public void monitor()
	{
		System.out.println(periodTime+"�� �������� ����͸�");
	}
}
