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
		//where�� ���̵�� �н����带 �Ѵ� �Է��ϹǷ�, �Ѵ� �´��� �Ѵ� Ʋ�ȴ��� �ۿ� ���� �� ����.
		//id, pwd ���� ���Ϸ��� 
		/*
		 * "select pwd from member where id = ?" �̾�� ����.
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
