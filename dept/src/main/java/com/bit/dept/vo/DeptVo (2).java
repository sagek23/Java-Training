package com.bit.dept.vo;

public class DeptVo {
	private int eno;
	private String ename;
	private String dname;
	private String dloc;
	private int esal;
	private String hiredate;
	private int wmonths;
	private String email;
	public void setEno(int eno) {
		this.eno = eno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public void setWmonths(int wmonths) {
		this.wmonths = wmonths;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEno() {
		return eno;
	}
	public String getEname() {
		return ename;
	}
	public String getDname() {
		return dname;
	}
	public String getDloc() {
		return dloc;
	}
	public int getEsal() {
		return esal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public int getWmonths() {
		return wmonths;
	}
	public String getEmail() {
		return email;
	}
	public DeptVo(int eno, String ename, String dname, String dloc, int esal, String hiredate, int wmonths,
			String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dname = dname;
		this.dloc = dloc;
		this.esal = esal;
		this.hiredate = hiredate;
		this.wmonths = wmonths;
		this.email = email;
	}
	public DeptVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

