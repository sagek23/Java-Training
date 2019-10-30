package com.bit.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;

public class GoodsDao {
	public ArrayList<GoodsVo> listAll( String search, String oper, String keyword){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods ";

		if (keyword !=null && !keyword.equals(""))
		{
			if(search.endsWith("price")&&search.endsWith("qty"))
			{
				sql += "where "+search+" "+oper+"  "+Integer.parseInt(keyword);
			}
			else
			{
				sql += "where "+search+" like '%"+keyword+"%'";
			}
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				GoodsVo v = new GoodsVo();
				v.setNo(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setPrice(rs.getInt(3));
				v.setQty(rs.getInt(4));
				v.setFname(rs.getString(5));
				list.add(v);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public int insertGoods(GoodsVo v) {
		int re = -1;
		String sql = "insert into goods values((select max(no)+1 from goods), ?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setInt(3, v.getQty());
			pstmt.setString(4, v.getFname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
