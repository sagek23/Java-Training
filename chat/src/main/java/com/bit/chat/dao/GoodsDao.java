package com.bit.chat.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.chat.db.DBManager;
import com.bit.chat.vo.GoodsVo;
@Repository
public class GoodsDao {
	public List<GoodsVo> listAll()
	{
		return DBManager.listGoods();
	}
	public int count()
	{
		return DBManager.getCount();
	}
	public List<GoodsVo> selectPage(HashMap map)
	{
		return DBManager.selectPage(map);
	}
	
}
