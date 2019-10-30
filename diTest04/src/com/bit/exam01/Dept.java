package com.bit.exam01;

public class Dept {
	int dno;
	String dname;
	String dloc;
	public Dept(int dno, String dname, String dloc) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
		System.out.println("생성자 동작");
		System.out.println("dno: "+this.dno);
		System.out.println("dname: "+this.dname);
		System.out.println("dloc: "+this.dloc);
	}
	public Dept()
	{
		
	}
}
