package com.bit.vo;

public class DeptVo {
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
	
	public int getDno() {
		return dno;
	}
	public String getDname() {
		return dname;
	}
	public String getDloc() {
		return dloc;
	}
	public DeptVo(int dno, String dname, String dloc) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
	}
	public DeptVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
