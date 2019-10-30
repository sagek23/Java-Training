package com.bit.exam10;

public class BookStore {
	private Book book;
	private Customer cust;
	
	
	public void setBook(Book book) {
		this.book = book;
	}


	public void setCust(Customer cust) {
		this.cust = cust;
	}


	public void pro()
	{
		book.info();
		cust.info();
	}
}
