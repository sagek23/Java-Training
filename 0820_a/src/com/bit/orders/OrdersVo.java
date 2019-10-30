package com.bit.orders;

import java.sql.Date;

public class OrdersVo {

	int orderkid;
	int custid;
	int bookid;
	int saleprice;
	Date orderdate;
	public int getOrderkid() {
		return orderkid;
	}
	public void setOrderkid(int orderkid) {
		this.orderkid = orderkid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public OrdersVo(int orderkid, int custid, int bookid, int saleprice, Date orderdate) {
		super();
		this.orderkid = orderkid;
		this.custid = custid;
		this.bookid = bookid;
		this.saleprice = saleprice;
		this.orderdate = orderdate;
	}
	public OrdersVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
