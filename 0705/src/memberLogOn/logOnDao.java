package memberLogOn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Connection.ConnectionProvider;
import bbs.BbsDao;
import bbs.BbsVo;

public class logOnDao {
	public int login(logOnVo vo)
	{
		int re = -1;
		String sql = "select id, pwd from member where id = ? and pwd = ?";
		//where에 아이디와 패스워드를 둘다 입력하므로, 둘다 맞는지 둘다 틀렸는지 밖에 비교할 수 없음.
		//id, pwd 따로 비교하려면 
		/*
		 * "select pwd from member where id = ?" 이어야 가능.
		 *
		 */
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				if(rs.getString(1).equals(vo.getId())&&rs.getString(2).equals(vo.pwd))
				{
					re= 1;
					
				}
				
				else
				{
					re = -1;
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
