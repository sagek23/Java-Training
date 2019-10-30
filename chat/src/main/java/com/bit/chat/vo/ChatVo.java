package com.bit.chat.vo;

public class ChatVo {
	private  int no;
	private String name;
	private String message;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ChatVo(int no, String name, String message) {
		super();
		this.no = no;
		this.name = name;
		this.message = message;
	}
	public ChatVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
