package com.bit.vo;

import java.sql.Date;

public class BbsVo {
	int num;
	String title;
	String writer;
	String pwd;
	String content;
	int views;
	Date credate;
	String ip;
	String fname;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public BbsVo(int num, String title, String writer, String pwd, String content, int views, Date credate, String ip,
			String fname) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.content = content;
		this.views = views;
		this.credate = credate;
		this.ip = ip;
		this.fname = fname;
	}

	public BbsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
