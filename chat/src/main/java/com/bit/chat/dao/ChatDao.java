package com.bit.chat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.chat.db.DBManager;
import com.bit.chat.vo.ChatVo;

@Repository
public class ChatDao {
	public int insertChat(ChatVo c)
	{
		return DBManager.insertChat(c);
	}
	public List<ChatVo> listAll()
	{
		return DBManager.listAll();
	}
}
