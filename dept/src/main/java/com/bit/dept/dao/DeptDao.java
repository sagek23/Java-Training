package com.bit.dept.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.dept.db.DBManager;
import com.bit.dept.vo.DeptVo;
@Repository
public class DeptDao {
	public List<DeptVo> listAll(String name)
	{
		return DBManager.listAll(name);
	}
}
