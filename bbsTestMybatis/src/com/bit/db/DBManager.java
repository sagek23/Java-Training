package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.dao.BbsDao;
import com.bit.vo.BbsVo;

public class DBManager {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/bit/db/dbConfig.xml");			
			factory = new SqlSessionFactoryBuilder().build(reader);			
			reader.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static List<BbsVo> listAll(HashMap map)
	{
		List<BbsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("bbs.selectAll", map);
		session.close();
		return list;
	}
	
	public static int getNextNum()
	{
		SqlSession session = factory.openSession();
		int num = session.selectOne("bbs.nextNum");
		session.close();
		return num;
	}
	public static int insert(BbsVo b)
	{
		int re =-1;
		SqlSession session = factory.openSession(true);
		 re = session.insert("bbs.insert",b);
		session.close();
		return re;
	}
	public static BbsVo detail(int num)
	{
		HashMap map = new HashMap();
		map.put("num", num);
		BbsVo b = null;
		SqlSession session = factory.openSession();
		b = session.selectOne("bbs.detail", map);
		session.close();
		return b;
	}

	public static void updateStep(int bref, int bstep) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("bref", bref);
		map.put("bstep", bstep);
		SqlSession session = factory.openSession(true);
		session.update("bbs.updateStep", map);
		session.close();
		return;
	}
	public static int update(BbsVo b)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("bbs.update", b);
		session.close();
		return re;
	}
	public static int delete(int num, String pwd)
	{
		int re = -1;
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("pwd", pwd);
		SqlSession sesseion = factory.openSession(true);
		re = sesseion.delete("bbs.delete", map);
		sesseion.close();
		return re;
	}
}










