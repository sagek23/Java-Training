package com.bit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bit.db.ConnectionProvider;
import com.bit.vo.CustomerVo;
@Repository
public class CustomerDao {
	public ArrayList<CustomerVo> listAll()
	{
		ArrayList<CustomerVo> list = new ArrayList<CustomerVo>();
		
		String sql = "select * from customer";
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
		return list;
	}
}
