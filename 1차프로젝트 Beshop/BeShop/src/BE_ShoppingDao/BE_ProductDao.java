package BE_ShoppingDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_SellerVo.BE_SellerVo;
import BE_ShoppingVo.BE_CategoryVo;
import BE_ShoppingVo.BE_ProductVo;
import DB.ConnectionProvider;

public class BE_ProductDao {
	public int insertProduct(BE_ProductVo po){
		int r=0;
			String sql="insert into product values((select max(pnum)+1 from product),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, po.getCtNum());
				ps.setDate(2, (Date)po.getP_Date());
				ps.setString(3, po.getAs_Info());
				ps.setDate(4, (Date)po.getP_Cdate());
				ps.setString(5,po.getPname());
				ps.setString(6, po.getBrand());
				ps.setInt(7, po.getStock());
				ps.setString(8, po.getP_Category());
				ps.setString(9, po.getP_Image());
				ps.setString(10, po.getP_Sangse());
				ps.setString(11, po.getCompany());
				ps.setString(12, po.getSelect_Op());
				ps.setInt(13, po.getLikes());
				ps.setInt(14, po.getHits());
				r = ps.executeUpdate();
				ConnectionProvider.close(conn, ps, null);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		return r;
	}
	public int deleteProduct(int no){
		int r=0;
		String sql="delete product where pnum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	public int updateProdut(BE_ProductVo po){
		int r=0;
		String sql = "update product set ctnum=?,p_date=?,as_info=?,p_cdate=?,pname=?,stock=?,p_category=?,p_image=?,p_sangse=?,company=?,select_op=?,likes=?,hits=? where pnum=?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, po.getCtNum());
			ps.setDate(2, (Date)po.getP_Date());
			ps.setString(3, po.getAs_Info());
			ps.setDate(4, (Date)po.getP_Cdate());
			ps.setString(5,po.getPname());
			ps.setString(6, po.getBrand());
			ps.setInt(7, po.getStock());
			ps.setString(8, po.getP_Category());
			ps.setString(9, po.getP_Image());
			ps.setString(10, po.getP_Sangse());
			ps.setString(11, po.getCompany());
			ps.setString(12, po.getSelect_Op());
			ps.setInt(13, po.getLikes());
			ps.setInt(14, po.getHits());
			ps.setInt(15, po.getpNum());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	public ArrayList<BE_ProductVo> ProductlistAll(int num){
		ArrayList<BE_ProductVo> Product_list = new ArrayList<BE_ProductVo>();
		String sql = "select * from Product where pnum ="+num;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_ProductVo vo = new BE_ProductVo();
				
	
				vo.setpNum(rs.getInt(1));
				vo.setCtNum(rs.getInt(2));
				vo.setP_Date(rs.getDate(3));
				vo.setAs_Info(rs.getString(4));
				vo.setP_Cdate(rs.getDate(5));
				vo.setPname(rs.getString(6));
				vo.setBrand(rs.getString(7));
				vo.setStock(rs.getInt(8));
				vo.setP_Category(rs.getString(9));
				vo.setP_Image(rs.getString(10));
				vo.setP_Sangse(rs.getString(11));
				vo.setCompany(rs.getString(12));
				vo.setSelect_Op(rs.getString(13));
				vo.setLikes(rs.getInt(14));
				vo.setHits(rs.getInt(15));
				vo.setP_Price(rs.getInt(16));
				vo.setOrigin(rs.getString(17));
				
				Product_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Product_list;
		
	}
		public int listDetailProduct(BE_ProductVo p)
		{
			
			return 0;
			
		}
		
		public ArrayList<BE_ProductVo> ProductlistAll(){
			ArrayList<BE_ProductVo> Product_list = new ArrayList<BE_ProductVo>();
			String sql = "select * from Product";
			try {
				Connection conn = ConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					BE_ProductVo vo = new BE_ProductVo();
					
					vo.setpNum(rs.getInt(1));
					vo.setCtNum(rs.getInt(2));
					vo.setP_Date(rs.getDate(3));
					vo.setAs_Info(rs.getString(4));
					vo.setP_Cdate(rs.getDate(5));
					vo.setPname(rs.getString(6));
					vo.setBrand(rs.getString(7));
					vo.setStock(rs.getInt(8));
					vo.setP_Category(rs.getString(9));
					vo.setP_Image(rs.getString(10));
					vo.setP_Sangse(rs.getString(11));
					vo.setCompany(rs.getString(12));
					vo.setSelect_Op(rs.getString(13));
					vo.setLikes(rs.getInt(14));
					vo.setHits(rs.getInt(15));
					vo.setP_Price(rs.getInt(16));
					
					Product_list.add(vo);
				}
				ConnectionProvider.close(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return Product_list;
		}
		public int getProductMax() {
			String sql="select max(pnum) from product";
			int i=0;
			try {
				Connection conn = ConnectionProvider.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) i=rs.getInt(1);
				ConnectionProvider.close(conn, st, null);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return i;
		}
		
	}















