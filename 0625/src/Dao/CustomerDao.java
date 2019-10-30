package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.ConnectionProvider;
import vo.CustomerVo;

public class CustomerDao {
	
	public int insertCustomer(CustomerVo c) //고객에 대한 정보가 CustomerVo에 실려서 옴.
											//아래 ?에 설정한 정보가 담겨있음
	{
		int re = -1; // 1이 아닌 임의의 아무 값이나 넣은 것.
		
		String sql = "insert into customer values(seq_customer.nextval, ?, ?, ?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			
			re = pstmt.executeUpdate();
		
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
		
		/*int로 값을 리턴하는 이유:
		 * int re = executeUpdate();
	데이터베이스 명령어가 Update, insert, delete일 때
	insert나 update, delete를 성공적으로 수행한 레코드의 수(정수)를
	반환하기 때문에 int로 값을 리턴
		
		*/
	}
	
}
