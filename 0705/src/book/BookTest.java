package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connection.ConnectionProvider;

public class BookTest {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String name = "������";
		String sql = 
				"(select bookid from " + 
				"orders where custid in (select custid " + 
				"from ( select custid, count(o.bookid) " + 
				"from orders o, (select bookid from " + 
				"customer c, orders o " + 
				"where c.custid = o.custid and " + 
				"name = ? ) list " + 
				"where o.bookid = list.bookid and " + 
				"custid != (select custid from customer where name=?) " + 
				"group by custid " + 
				"order by count(o.bookid) desc ) count_list " + 
				"where rownum <= 2)) " + 
				"minus " + 
				"(select bookid from " + 
				"customer c, orders o " + 
				"where c.custid = o.custid and " + 
				"name = ?)";
		
		String sql2 = 
				"(select bookid from " + 
				"(select bookid, count(bookid) " + 
				"from orders " + 
				"group by bookid " + 
				"order by count(bookid) desc) " + 
				"where rownum <= 3) " + 
				"minus " + 
				"(select bookid from " + 
				"customer c, orders o " + 
				"where c.custid = o.custid and " + 
				"name = ?)";

		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			pstmt.setString(3, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				do
				{
					System.out.println(rs.getInt(1));
				}while(rs.next());
			}
			else
			{
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, name);
				ResultSet rs2 = pstmt2.executeQuery();
				while(rs2.next())
				{
					System.out.println(rs2.getInt(1));
				}
				ConnectionProvider.close(null, pstmt2, rs2);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		*/
		new BookFrame();
	}

}
