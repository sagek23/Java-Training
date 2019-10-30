package com.bit.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.text.AbstractDocument.Content;

public class ConnectionProvider {
	public static void close(Connection conn, Statement stmt, ResultSet rs)
	{
		try {
			if(rs !=null)
			{
				rs.close();
			}
			if(stmt !=null)
			{
				stmt.close();
			}
			if(conn !=null)
			{
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void close(Connection conn, Statement stmt)
	{
		try {
			if(stmt !=null)
			{
				stmt.close();
			}
			if(conn !=null)
			{
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection()
	{	
		Connection conn = null;
		try {
			Context context = new InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource)context.lookup("java:/comp/env/oracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
