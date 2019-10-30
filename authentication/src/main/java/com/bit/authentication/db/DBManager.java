package com.bit.authentication.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.authentication.vo.SmsVo;

public class DBManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/authentication/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<SmsVo> listAll()
	{
		List<SmsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("sms.selectAll");
		session.close();
		return list;
	}
	public static int join(SmsVo m)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("sms.join", m);
		session.close();
		return re;
	}
}
