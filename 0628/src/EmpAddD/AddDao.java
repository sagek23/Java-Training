package EmpAddD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import Connection.ConnectionProvider;
import EmpAdd.AddVo;

public class AddDao {

	public int insertDao(AddVo v)
	{
		int re = 0;
		String sql = "insert into emp values(seq_emp.nextval, ?,?,?,?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.geteName());
			pstmt.setString(2, v.getAddr());
			pstmt.setInt(3, v.getSal());
			pstmt.setInt(4, v.getComm());
			pstmt.setString(5, v.getJob());
			pstmt.setString(6, v.getTel());
			pstmt.setString(7, v.getStrHiredate());
			pstmt.setInt(8, v.getMgr());
			pstmt.setInt(9, v.getDno());
			pstmt.setString(10, v.getEmail());
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
