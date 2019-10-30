package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionProvider;

public class memberDao extends JFrame {

	public int insertMember(memberVo vo)
	{
		int re = -1;
		String sql = "insert into member values(?,?,?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		return re;
	}
	
	public int login(String id, String pwd)
	{
		int re = -1;
	
		String sql = "select pwd from member where id = ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString(1).equals(pwd))
				{
					re=1;
				}
				else
				{
					re=0;
				}
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	
}
