package BE_ShoppingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_SellerVo.BE_SellerVo;
import BE_ShoppingVo.BE_ProductVo;
import BE_ShoppingVo.BE_ShopListVo;
import DB.ConnectionProvider;

public class BE_ShopListDao {
	public int insertShoplist(BE_ShopListVo so){
		int r=0;
		String sql="insert into shoplist values((select max(slnum)+1 from shoplist),?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, so.getPnum());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	public int deleteShoplist(int no){
		int r=0;
		String sql="delete shoplist where slnum="+no;
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
	public int updateShoplist(BE_ShopListVo so){
		int r =0;
		String sql = "update shoplist set pnum=? where slnum=? ";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, so.getPnum());
			ps.setInt(2, so.getSlnum());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	public ArrayList<BE_ShopListVo> ShopListlistAll(String uid){
		ArrayList<BE_ShopListVo> Product_list = new ArrayList<BE_ShopListVo>();
		String sql = "select * from shoplist";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_ShopListVo vo = new BE_ShopListVo();
				int Slnum;
				int Pnum;
	
				vo.setSlnum(rs.getInt(1));
				vo.setPnum(rs.getInt(2));
				
				Product_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
}
