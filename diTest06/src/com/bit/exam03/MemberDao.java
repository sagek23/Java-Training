package com.bit.exam03;

public class MemberDao {
	private String url;
	private String user;
	private String pwd;
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void info()
	{
		System.out.println(url+","+user+","+pwd);
	}
}
