package com.bit.bookStore.dao;

import org.springframework.stereotype.Repository;

import com.bit.bookStore.db.DBManager;
import com.bit.bookStore.vo.BookVo;
import com.bit.bookStore.vo.MethodLog;

@Repository
public class MethodLogDao {

	public int insert(MethodLog m)
	{
		return DBManager.insertMethodLog(m);
	}
}
