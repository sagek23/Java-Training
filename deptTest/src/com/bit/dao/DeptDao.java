package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.DeptVo;

public class DeptDao {
	public ArrayList<DeptVo> listAll()
	{
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		String sql = "select * from dept";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				DeptVo v=new DeptVo();
				v.setDno(rs.getInt(1));
				v.setDname(rs.getString(2));
				v.setDloc(rs.getString(3));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int insert(DeptVo d) {
		// TODO Auto-generated method stub
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		try {
			Connection conn= ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re= pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
