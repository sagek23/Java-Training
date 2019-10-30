package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {
	
	public static void close(Connection conn, Statement stmt, ResultSet rs)
	{
		try {
			if(rs != null)
			{
				rs.close();
			}
			
			if(stmt != null)
			{
				stmt.close();
			}
			
			if(conn != null)
			{
				conn.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void close(Connection conn, Statement stmt)
	{
		try {
			if(stmt != null)
			{
				stmt.close();
			}
			
			if(conn != null)
			{
				conn.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public static Connection getConnection()
	{		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.168.0.220:1521:XE", "c##beshop", "bit1120");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}
}








