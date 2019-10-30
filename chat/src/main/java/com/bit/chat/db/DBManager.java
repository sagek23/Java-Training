package com.bit.chat.db;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.chat.vo.ChatVo;
import com.bit.chat.vo.GoodsVo;
import com.bit.chat.vo.Jumun;
import com.bit.chat.vo.JumunDetailVo;
import com.bit.chat.vo.JumunVo;

public class DBManager {
	public static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/bit/chat/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static int insertChat(ChatVo c)
	{
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("chat.insert", c);
		session.commit();
		session.close();
		return re;
	}
	
	public static int insertOrder(Jumun jumun)
	{
		int r = 0;
		int re  = 0;
		SqlSession session = factory.openSession();
		int jumun_no = session.selectOne("nextOrderNo");
		JumunVo jumunVo = new JumunVo();
		jumunVo.setJumun_no(jumun_no);
		jumunVo.setTotal(jumun.getTotal());
		jumunVo.setCustid(jumun.getCustid());
		
		re += session.insert("jumun.insertOrder", jumunVo);
		
		ArrayList<JumunDetailVo> list = jumun.getJumunList();
		for(JumunDetailVo vo:list)
		{
			vo.setJumun_no(jumun_no);
			re+= session.insert("jumun.insertOrderDetail", vo);
			re += session.update("goods.updateQty", vo);
		}
		if(re == (list.size()*2)+1) //위에서 re를 두번 + 해주므로 *2
		{
			session.commit();
			r= 1;
		}
		else
		{
			session.rollback();
		}
		session.close();
		
		return r;
	}
	
	public static List<ChatVo> listAll()
	{
		List<ChatVo> list =  null;
		SqlSession session = factory.openSession();
		list = session.selectList("chat.selectAll");
		session.close();
		return list;
	}
	
	public static List<GoodsVo> listGoods()
	{
		List<GoodsVo>list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
	public static int getCount()
	{
		int re = 0;
		SqlSession session = factory.openSession();
		re = session.selectOne("goods.getCount");
		session.close();
		return re;
	}
	
	public static List<GoodsVo> selectPage(HashMap map)
	{
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectPage", map);
		session.close();
		return list;
	}
}
