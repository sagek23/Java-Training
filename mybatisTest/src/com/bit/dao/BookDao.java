package com.bit.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.BookManager;

import com.bit.vo.BookVo;
@Repository
public class BookDao {
	public List<BookVo> listAll()
	{
		return BookManager.listAll();
	}
	public BookVo detailBook(int bookid)
	{
		return BookManager.detailBook(bookid);
	}
	public int insertBook(BookVo b)
	{
		return BookManager.insertBook(b);
	}
	public int updateBook(BookVo b)
	{
		return BookManager.updateBook(b);
	}
	public int deleteBook(int bookid)
	{
		return BookManager.deleteBook(bookid);
	}
}
