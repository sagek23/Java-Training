package com.bit.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsVo;
import com.sun.org.apache.regexp.internal.recompile;
@Repository
public class GoodsDao {
	public List<GoodsVo> listAll(HashMap map)
	{
		return GoodsManager.listAll(map);
	}
	public GoodsVo detail(int no)
	{
		return GoodsManager.detail(no);
	}
	public int insert(GoodsVo g)
	{
		return GoodsManager.insert(g);
	}
	public int update(GoodsVo g)
	{
		return GoodsManager.update(g);
	}
	public int delete(int no)
	{
		return GoodsManager.delete(no);
	}
	public int count(HashMap map)
	{
		return GoodsManager.count(map);
	}
}
