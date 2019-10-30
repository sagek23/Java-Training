package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.SqlMapperException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.BookVo;

public class BookManager {
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
	
	public static List<BookVo> listAll()
	{
		List<BookVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("book.selectAll");
		session.close();
		return list;
	}
	public static BookVo detailBook(int bookid)
	{
		HashMap map = new HashMap();
		map.put("bookid", bookid);
		BookVo b = null;
		SqlSession session = factory.openSession();
		b = session.selectOne("book.detailBook", map);
		session.close();
		return b;
	}
	public static int insertBook(BookVo b)
	{
		int re=-1;
		SqlSession session = factory.openSession();
		re = session.insert("book.insertBook", b);
		session.commit();
		session.close();
		return re;
	}
	public static int updateBook(BookVo b)
	{
		int re=-1;
		SqlSession session = factory.openSession(true); //true를 주면 오토커밋이 된다.
		re = session.insert("book.updateBook", b);
		session.close();
		return re;
	}
	public static int deleteBook(int bookid)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("bookid", bookid); //Mapper에서 실어준 이름과 같아야함
		re = session.delete("book.deleteBook", map);
		session.close();
		return re;
	}
}
