package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import  BE_SellerVo.BE_SellerVo;
import DB.ConnectionProvider;

public class BE_SellerDao {
	public int insertSeller(BE_SellerVo vo) {
		int re = -1;
		
		String sql = "insert into seller values(?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getsNum());
			pstmt.setInt(2, vo.getSuNum());
			pstmt.setString(3, vo.getbeUid());
			pstmt.setInt(4, vo.getpNum());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}

	
	
	public int updateSeller(BE_SellerVo vo) {
		int re = -1;
		String sql="update seller set snum=?, sunum=?, pnum=? where uid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getsNum());
			pstmt.setInt(2, vo.getSuNum());
			pstmt.setInt(3, vo.getpNum());
			pstmt.setString(4, vo.getbeUid());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);	
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int deleteSeller(BE_SellerVo vo) {
		int re = -1;
		String sql="delete seller where uid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbeUid());
			re= pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<BE_SellerVo> SellerlistAll(String uid){
		ArrayList<BE_SellerVo> seller_list = new ArrayList<BE_SellerVo>();
		String sql = "select * from seller where uid="+uid;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_SellerVo vo = new BE_SellerVo();
				vo.setsNum(rs.getInt(1));
				vo.setSuNum(rs.getInt(2));
				vo.setbeUid(rs.getString(3));
				vo.setpNum(rs.getInt(4));
				
				seller_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return seller_list;
	}
	
	
}
	

/*


*/