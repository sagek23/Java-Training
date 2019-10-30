package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsVo;

public class GoodsManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/sqlMapConfig.xml");
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
		list = session.selectList("goods.selectGoods");
		session.close();
		return list;
	}
	
	public static GoodsVo detail(int no)
	{
		HashMap map = new HashMap();
		map.put("no", no);
		GoodsVo g = null;
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.detailGoods", map);
		session.close();
		return g;
	}
	public static int insert(GoodsVo g) //Vo에서 값을 가져오는 것.
	{
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.insertGoods", g);
		session.commit();
		session.close();
		return re;
	}
	public static int update(GoodsVo g)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("goods.updateGoods", g);
		session.close();
		return re;
	}
	public static int delete(int no)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("no", no);
		re = session.delete("goods.deleteGoods", map);
		session.close();
		return re;
	}
}
