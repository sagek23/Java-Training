package com.bit.exam03;

public class book {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	public book(int bookid, String bookname, String publisher, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
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
