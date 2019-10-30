package com.bit.bookStore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.bookStore.db.DBManager;
import com.bit.bookStore.vo.GoodsVo;
@Repository
public class GoodsDao {
	public List<GoodsVo> listAll()
	{
		return DBManager.listGoods();
	}

	public GoodsVo detailGoods(int no)
	{
		return DBManager.detailGoods(no);
	}
}
