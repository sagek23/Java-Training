package LogOn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Connection.ConnectionProvider;

public class LogOnDao {

	public int isMember(LogOnVO vo)
	{
		int re = -1;
		String sql = 
				"select pwd from member where id=?";
				try {
					Connection conn = ConnectionProvider.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vo.getId());
					
					ResultSet rs = pstmt.executeQuery();
					while(rs.next())
					{
						if(rs.getString(1).equals(vo.getPwd()))
						{
							re = 1;
						}
						else
							re= 0;
					}
					ConnectionProvider.close(conn, pstmt, rs);
					
				
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
		
		return re;
	}
}
