package com.bit.bookStore.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.bit.bookStore.db.DBManager;
import com.bit.bookStore.vo.BookVo;

@Repository
public class BookDao {
	@Scheduled(fixedRate = 100000)
	public void pro() {
		System.out.println("aa");
	}
	
	public List<BookVo> listAll(int start, int end)
	{
		return DBManager.listAll(start, end);
	}
	public int insert(BookVo b)
	{
		return DBManager.insertBook(b);
	}
	public int update(BookVo b)
	{
		return DBManager.updateBook(b);
	}
	public int delete(BookVo b)
	{
		return DBManager.deleteBook(b);
	}
	
	public int count()
	{
		return DBManager.getCount();
	}
	
}
