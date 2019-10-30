package com.bit.orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.bit.db.ConnectionProvider;

public class CustomerDao {
	public ArrayList<CustomerVo> listCust() {
		String sql = "select * from customer";
		ArrayList<CustomerVo> list = new ArrayList<CustomerVo>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				CustomerVo v = new CustomerVo();
				v.setCustid(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setAddress(rs.getString(3));
				v.setPhone(rs.getString(4));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return  list;
	}
}
