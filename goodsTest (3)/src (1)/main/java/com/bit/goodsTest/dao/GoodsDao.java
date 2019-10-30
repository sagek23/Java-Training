package com.bit.goodsTest.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bit.goodsTest.vo.GoodsVo;

@Repository
public class GoodsDao {
	public ArrayList<GoodsVo> listAll()
	{
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		list.add(new GoodsVo(1,"축구공",25000,100,"ball1.jpg"));
		list.add(new GoodsVo(2,"축구화",150000,100,"shoe1.jpg"));
		list.add(new GoodsVo(3,"져지",100000,100,"cloth1.jpg"));
		return list;
	}
}
