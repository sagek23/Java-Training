package com.bit.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.DBManager;
import com.bit.vo.BookVo;
@Repository
public class BookDao {

	public List<BookVo> listAll(HashMap map)
	{
		return DBManager.listAll(map);
	}
	public int count(HashMap map)
	{
		return DBManager.count(map);
	}
}
