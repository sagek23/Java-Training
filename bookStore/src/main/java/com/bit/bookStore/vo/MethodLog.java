package com.bit.bookStore.vo;

import java.util.Date;

public class MethodLog {
	private int no;
	private String methodname;
	private Date calldate;
	private int requiredTime;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public Date getCalldate() {
		return calldate;
	}
	public void setCalldate(Date calldate) {
		this.calldate = calldate;
	}
	public int getRequiredTime() {
		return requiredTime;
	}
	public void setRequiredTime(int requiredTime) {
		this.requiredTime = requiredTime;
	}
	
	public MethodLog(int no, String methodname, Date calldate, int requiredTime) {
		super();
		this.no = no;
		this.methodname = methodname;
		this.calldate = calldate;
		this.requiredTime = requiredTime;
	}
	public MethodLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MethodLog [no=" + no + ", methodname=" + methodname + ", calldate=" + calldate + ", taketime="
				+ requiredTime + "]";
	}
	
	
	
}
