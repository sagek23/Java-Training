package com.bit.chat.vo;

import java.sql.Date;

public class JumunVo {
	private int jumun_no;
	private String custid;
	private int total;
	private Date order_date;
	public int getJumun_no() {
		return jumun_no;
	}
	public void setJumun_no(int jumun_no) {
		this.jumun_no = jumun_no;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public JumunVo(int jumun_no, String custid, int total, Date order_date) {
		super();
		this.jumun_no = jumun_no;
		this.custid = custid;
		this.total = total;
		this.order_date = order_date;
	}
	public JumunVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
