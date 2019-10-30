package bankDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDao {

	public int getBalance(int no)
	{
			int balance = 0;
			String sql="select balance from bank where no=?";
try {
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				balance = rs.getInt(1);
			}
		
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	
		return balance;
	}
	
	public boolean updBalnce(int from, int to, int amount) {
		boolean re= false;
		//반환자료형은 아무것이나 가능. int, String 등..
		
		int balance = getBalance(from);
		if(amount>balance)	
		{
			return false;
		}
		String sql="update bank set balance = balance - ? where no=?";
		//String sql="update bank set balance = balance - ? where no=? and balance>=?";
		String sql2="update bank set balance = balance + ? where no=?";
		
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);

			pstmt.setInt(1, amount);
			pstmt.setInt(2, from);	
			//pstmt.setInt(3, amount);	
			
			pstmt2.setInt(1, amount);
			pstmt2.setInt(2, to);	
			
		
		
			int re1 = pstmt.executeUpdate();
			int re2 = pstmt2.executeUpdate();
			int a = 0;
			if(re1>0&&re2>0)
			{
				conn.commit();
				re = true;
			}
			else
			{
				conn.rollback();
			}
			
			pstmt.close();
			pstmt2.close();
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		return re;
	}
}
