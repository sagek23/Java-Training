package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectionProvider.ConnectionProvider;

public class ManagerDao {
	public void createManager() {
		try {
			Connection conn = connectionProvider.ConnectionProvider.getConnection();
			String sql = "create table manager(id varchar2(20) primary key,pwd varchar2(20))";
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertManager() {

		try {
			Connection conn = connectionProvider.ConnectionProvider.getConnection();
			String sql = "insert into manager values('tiger','tiger')";
			java.sql.Statement stmt= conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void insertManager(String id, String pwd) {
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "insert into manager values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void dropManager()
	{
		try {
			Connection conn = connectionProvider.ConnectionProvider.getConnection();
			String sql = "drop table manager";
			java.sql.Statement stmt= conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	public boolean isManager(String id, String pwd)
	{
		boolean r = false;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "select * from manager where id=? and pwd =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				r = true;
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return r;
	}
}
