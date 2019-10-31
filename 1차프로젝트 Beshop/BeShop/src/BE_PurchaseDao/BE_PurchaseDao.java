package BE_PurchaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BE_PurchaseVo.BE_PurchaseVo;

import DB.ConnectionProvider;

public class BE_PurchaseDao {
	public int insertPurchase(BE_PurchaseVo v) {
		int re=-1;
		String sql="insert into purchase values(seq_pcnum.nextval, ?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, v.getpNum());
			pstmt.setInt(2, v.getPcCount());
			pstmt.setInt(3, v.getPcPrice());
			pstmt.setInt(4, v.getDiscount());
			pstmt.setString(5, v.getPcPhone());
			pstmt.setString(6, v.getZipcode());
			pstmt.setString(7, v.getPcAddr1());
			pstmt.setString(7, v.getPcAddr2());
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int deletePurchase(int pcnum) {
		int re = -1;
		String sql = "delete purchase where pcnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pcnum);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
				
		return re;
	}
	public ArrayList<BE_PurchaseVo> PurchaselistAll(int pcnum){
		ArrayList<BE_PurchaseVo> list = new ArrayList<BE_PurchaseVo>();
		String sql = "select * where pcnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pcnum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				BE_PurchaseVo pv = new BE_PurchaseVo();
				pv.setPcNum(rs.getInt(1));
				pv.setpNum(rs.getInt(2));
				pv.setPcCount(rs.getInt(3));
				pv.setDiscount(rs.getInt(4));
				pv.setPcPrice(rs.getInt(5));
				pv.setPcAddr1(rs.getString(6));
				pv.setPcAddr2(rs.getString(7));
				pv.setZipcode(rs.getString(8));
				pv.setPcPhone(rs.getString(9));
				list.add(pv);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		return list;
	}
}
