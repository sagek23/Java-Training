package com.bit.exam03;

public class BookStore {
	private book book;
	private Customer cust;
	public BookStore(com.bit.exam03.book book, Customer cust) {
		super();
		this.book = book;
		this.cust = cust;
	}
	
	public void pro()
	{
		book.info();
		cust.info();
	}
}
