package com.bit.vo;

public class MemberVo {
	String id;
	String pwd;
	String name;
	int age;
	String tel;
	String addr;
	String hobby;
	String job;
	String sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public MemberVo(String id, String pwd, String name, int age, String tel, String addr, String hobby, String job,
			String sex) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.addr = addr;
		this.hobby = hobby;
		this.job = job;
		this.sex = sex;
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
