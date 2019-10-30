package book;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	public ArrayList<BookVo> selectAll(){
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo bv = null;
		String sql = "Select * from book order by bookid";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				bv = new BookVo();
				bv.setBookid(rs.getInt(1));
				bv.setBookname(rs.getString(2));
				bv.setPublisher(rs.getString(3));
				bv.setPrice(rs.getInt(4));
				list.add(bv);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
