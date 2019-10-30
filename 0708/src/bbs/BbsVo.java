package bbs;

import java.sql.Date;

public class BbsVo {

	String title;
	String writer;
	String pwd;
	int hit;
	String content;
	int no;
	Date regdate;
	public BbsVo(String title, String writer, String pwd, int hit, String content, int no, Date regdate) {
		super();
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.hit = hit;
		this.content = content;
		this.no = no;
		this.regdate = regdate;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
