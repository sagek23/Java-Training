package BE_ShoppingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import BE_ShoppingVo.BE_ShoppingVo;
import DB.ConnectionProvider;

import DB.ConnectionProvider;
//리스트올없음

public class BE_ShoppingDao {
	public int insertShopping(BE_ShoppingVo so){
		int r=0;
		String sql="insert into shopping values((select max(pnum)+1 from shopping),?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, so.getChNum());
			ps.setInt(2, so.getgNum());
			ps.setString(3, so.getSmall_Search());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	public int deleteShopping(int no){
		int r=0;
		String sql="delete shopping where pnum="+no;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			r = st.executeUpdate(sql);
			ConnectionProvider.close(conn, st, null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	public int updateShopping(BE_ShoppingVo so){
		int r=0;
		String sql="update shopping set chnum=?,gnum=?,small_search=? where pnum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, so.getChNum());
			ps.setInt(2, so.getgNum());
			ps.setString(3, so.getSmall_Search());
			ps.setInt(4, so.getpNum());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	
}
