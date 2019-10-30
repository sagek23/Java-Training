package com.bit.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.DBManager;
import com.bit.vo.BbsVo;

@Repository
public class BbsDao {

	public List<BbsVo> listAll(HashMap map)
	{
		return DBManager.listAll(map);
	}
	
	public int insert(BbsVo b)
	{
		return DBManager.insert(b);
	}
	public int getNextNum()
	{
		return DBManager.getNextNum();
	}
	public BbsVo detail(int num)
	{
		return DBManager.detail(num);
	}
	public void updateStep(int bref, int bstep) {
		// TODO Auto-generated method stub
		DBManager.updateStep(bref, bstep);
	}
	public int update(BbsVo b)
	{
		return DBManager.update(b);
	}
	public int delete(int num, String pwd)
	{
		return DBManager.delete(num, pwd);
	}
}






