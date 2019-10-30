package com.bit.bookStore.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.bookStore.vo.BookVo;
import com.bit.bookStore.vo.GoodsVo;
import com.bit.bookStore.vo.MailVo;
import com.bit.bookStore.vo.MethodLog;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/bookStore/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<MailVo> listMail()
	{
		List<MailVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("mail.selectAll");
		session.close();
		return list;
	}
	
	public static List<GoodsVo> listGoods()
	{
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
	public static int insertMethodLog(MethodLog m)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("methodlog.insert",m);
		session.close();
		return re;
	}
	
	public static GoodsVo detailGoods(int no) 
	{
		HashMap map = new HashMap();
		map.put("no", no);
		GoodsVo goods;
		SqlSession session = factory.openSession();
		goods = session.selectOne("goods.detail", map);
		session.close();
		return goods;
	}
	
	public static int getCount()
	{
		SqlSession session = factory.openSession();
		int re= -1;
		re = session.selectOne("book.getCount");
		session.close();
		return re;
	}
	
	public static List<BookVo> listAll(int start, int end)
	{
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		SqlSession session = factory.openSession();
		List<BookVo> list = session.selectList("book.selectAll", map);
		session.close();
		return list;
	}
	
	public static int insertBook(BookVo b)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("book.insert", b);
		session.close();
		return re;
	}
	public static int updateBook(BookVo b)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("book.update", b);
		session.close();
		return re;
	}
	public static int deleteBook(BookVo b)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("book.delete", b);
		session.close();
		return re;
	}
	
	
}
