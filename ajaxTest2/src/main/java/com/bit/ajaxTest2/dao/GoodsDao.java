package com.bit.ajaxTest2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.ajaxTest2.db.DBManager;
import com.bit.ajaxTest2.vo.GoodsVo;
@Repository
public class GoodsDao {
	public List<GoodsVo> listAll()
	{
		return DBManager.listAll();
	}
	public GoodsVo detail(int no)
	{
		return DBManager.detail(no);
	}
	public int insert(GoodsVo g)
	{
		return DBManager.insert(g);
	}
}
