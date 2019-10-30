package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.BookVo;

public class DBManager {

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
	
	public static List<BookVo> listAll(HashMap map)
	{
		List<BookVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("book.selectAll", map);
		session.close();
		return list;
	}
	public static int count(HashMap map)
	{
		int cnt = 0;
		SqlSession session = factory.openSession();
		cnt = session.selectOne("book.count", map);
		session.close();
		return cnt;
	}
	
}
