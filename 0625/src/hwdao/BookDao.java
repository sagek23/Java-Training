package hwdao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.ConnectionProvider;
import hwvo.BookVo;

public class BookDao {
	
	public int insertBook(BookVo v)
	{
		int re = -1;
		
		String sql = "insert into book values(seq_book.nextval, ?, ? ,?)";
		//create sequence seq_book start with;
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getBookname());
			pstmt.setString(2, v.getPublisher());
			pstmt.setInt(3, v.getPrice());
			
			re= pstmt.executeUpdate();
	
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}

}
