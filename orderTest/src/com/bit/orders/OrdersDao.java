package com.bit.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;

public class OrdersDao {
	public int insertOrder(OrdersVo v) {
		int re =-1;
		String sql = "insert into orders values(seq_ord.nextval,?,?,?,sysdate)";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, v.getCustid());
			pstmt.setInt(2, v.getBookid());
			pstmt.setInt(3, v.getSaleprice());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public void listOrder(OrdersVo v) {
		String sql = "select * from orders where orderkid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, v.getOrderkid());
			ResultSet rs = pstmt.executeQuery();
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	}
	public ArrayList<OrderInfoVo> listAll(String search, String keyword, String oper) {
		ArrayList<OrderInfoVo> list = new ArrayList<OrderInfoVo>();
		String sql = "select c.custid, name, bookname, price, saleprice, publisher, orderdate from customer c, orders o,"
				+ "book b where c.custid = o.custid and b.bookid = o.bookid ";
		
		if (keyword !=null && !keyword.equals(""))
		{
			if(search.endsWith("price"))
			{
				sql += "and "+search+" "+oper+"  "+Integer.parseInt(keyword);
			}
			else
			{
				sql += "and "+search+" like '%"+keyword+"%'";
			}
		}
		
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				OrderInfoVo v = new OrderInfoVo();
				v.setCustid(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setBookname(rs.getString(3));
				v.setPrice(rs.getInt(4));
				v.setSaleprice(rs.getInt(5));
				v.setPublisher(rs.getString(6));
				v.setOrderdate(rs.getDate(7));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	
}
