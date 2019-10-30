package BE_ShoppingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_SellerVo.BE_SellerVo;
import BE_ShoppingVo.BE_CategoryVo;
import DB.ConnectionProvider;

public class BE_CategoryDao {
	public int insertCategory(BE_CategoryVo co){
		int r=0;
		String sql = "insert into category values((select max(ctnum)+1 from category),?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, co.getBigName());
			ps.setString(2, co.getSmName());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn,ps,null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;

	}
	public int deleteCategory(int no){
		int r=0;
		String sql = "delete category where ctnum="+no;
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
	public int updateCategory(BE_CategoryVo co){
		int r=0;
		String sql = "update category set bigname=?,smname=? where ctnum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, co.getBigName());
			ps.setString(2, co.getSmName());
			ps.setInt(3, co.getCtnum());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	public ArrayList<BE_SellerVo> CategorylistAll(String uid){
		ArrayList<BE_CategoryVo> Category_list = new ArrayList<BE_CategoryVo>();
		String sql = "select * from Category";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_CategoryVo vo = new BE_CategoryVo();
				vo.setCtnum(rs.getInt(1));
				vo.setBigName(rs.getString(2));
				vo.setSmName(rs.getString(3));
				
				
				Category_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("?2"+e.getMessage());
		}
		return null;
		
	}
	public ArrayList<String> getBigName(){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct bigname from category";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, st, rs);
		} catch (Exception e) {
			System.out.println("?1"+e.getMessage());
		}
		return list;
	}
	public ArrayList<String> getSMName(String bigname){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select smname from category where bigname = ? group by smname";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bigname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, ps, rs);
		} catch (Exception e) {
			System.out.println("?33"+e.getMessage());
		}
		return list;
	}
	
}
