package com.bit.exam02;

public class Dept {
	int dno;
	String dname;
	String dloc;

	public void setDno(int dno) {
		this.dno = dno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public Dept()
	{
		
	}
	
	public void info()
	{
		System.out.println("dno: "+dno );
		System.out.println("dname: "+dname );
		System.out.println("dloc: "+dloc );
	}
}
