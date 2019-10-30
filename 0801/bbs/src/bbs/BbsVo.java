package bbs;

import java.util.Date;

public class BbsVo {

	int num;
	String title;
	String writer;
	String pwd;
	String content;
	int views;
	Date creDate;
	String ip;
	String fname;
	
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
	public int CreDate() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
	public int getViews() {
		return views;
	}
	public BbsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

