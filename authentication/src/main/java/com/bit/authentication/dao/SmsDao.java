package com.bit.authentication.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.authentication.db.DBManager;
import com.bit.authentication.vo.SmsVo;
@Repository
public class SmsDao {
	public List<SmsVo> listAll()
	{
		return DBManager.listAll();
	}
	public int join(SmsVo m)
	{
		return DBManager.join(m);
	}
}
