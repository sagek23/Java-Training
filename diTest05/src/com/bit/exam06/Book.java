package com.bit.exam06;

public class Book {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void info()
	{
		System.out.println("***��������***");
		System.out.println("������ȣ: "+bookid);
		System.out.println("������: "+bookname);
		System.out.println("���ǻ�: "+publisher);
		System.out.println("��������: "+price);
	}
}
