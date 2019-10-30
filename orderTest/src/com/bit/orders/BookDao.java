package com.bit.orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;

public class BookDao {
	public ArrayList<BookVo> listBookid() {
		String sql = "select * from book";
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BookVo v = new BookVo();
				v.setBookid(rs.getInt(1));
				v.setBookname(rs.getString(2));
				v.setPublisher(rs.getString(3));
				v.setPrice(rs.getInt(4));
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
