package bbs;

import java.sql.Date;

public class BbsVo {
	int num;
	String title;
	String writer;
	String pwd;
	int views;
	String content;
	Date creDate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
	public BbsVo(int num, Date creDate) {
		super();
		this.num = num;
		this.creDate = creDate;
	}
	public BbsVo(String title, String writer, String pwd, int views) {
		super();
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.views = views;
	}
	public BbsVo() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public BbsVo(String content) {
		super();
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
