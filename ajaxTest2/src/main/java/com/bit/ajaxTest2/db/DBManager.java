package com.bit.ajaxTest2.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.ajaxTest2.vo.GoodsVo;

public class DBManager {
	private static SqlSessionFactory factory;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/ajaxTest2/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static List<GoodsVo> listAll()
	{
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	public static GoodsVo detail(int no)
	{
		HashMap map = new HashMap();
		map.put("no", no);
		GoodsVo g = new GoodsVo();
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.detail", map);
		session.close();
		return g;
	}
	public static int insert(GoodsVo g)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}
}
