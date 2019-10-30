package com.bit.orders;

import java.sql.Date;

public class OrderInfoVo {
	int custid;
	String name;
	String bookname;
	int price;
	int saleprice;
	String publisher;
	Date orderdate;
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public OrderInfoVo(int custid, String name, String bookname, int price, int saleprice, String publisher,
			Date orderdate) {
		super();
		this.custid = custid;
		this.name = name;
		this.bookname = bookname;
		this.price = price;
		this.saleprice = saleprice;
		this.publisher = publisher;
		this.orderdate = orderdate;
	}
	public OrderInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
