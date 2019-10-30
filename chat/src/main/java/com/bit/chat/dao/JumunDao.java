package com.bit.chat.dao;

import org.springframework.stereotype.Repository;

import com.bit.chat.db.DBManager;
import com.bit.chat.vo.Jumun;
import com.bit.chat.vo.JumunVo;

@Repository
public class JumunDao {
	public int insertOrder(Jumun jumun)
	{
		return DBManager.insertOrder(jumun);
	}
}
