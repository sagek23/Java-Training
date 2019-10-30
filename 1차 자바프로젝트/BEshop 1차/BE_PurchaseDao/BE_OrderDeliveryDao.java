package BE_PurchaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import BE_PurchaseVo.BE_DeliveryComVo;
import BE_PurchaseVo.BE_OrderDeliveryVo;

import DB.ConnectionProvider;
public class BE_OrderDeliveryDao { 
	
	public int insertOrderDelivery(BE_OrderDeliveryVo v, BE_DeliveryComVo vo) {
		int re=-1;
		String sql = "insert into orderDelivery values(seq_onum.nextval, ?,?,sysdate,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getbeUid());
			pstmt.setInt(2, v.getpNum());
			pstmt.setInt(3, vo.getDcNum());
			pstmt.setInt(4, v.getoCount());
			pstmt.setInt(5, v.getoPrice());
			pstmt.setString(6, v.getOdAddr1());
			pstmt.setString(7, v.getOdAddr2());
			pstmt.setString(8, v.getoPhone()); 
			pstmt.setString(9, v.getOdZip());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int updateOrderDelivery(String odAddr1, String odAddr2, String ophone) {
		int re =-1;
		String sql = "update OrderDelivery set odAddr1 =?, odAddr2=?, ophone=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, odAddr1);
			pstmt.setString(2, odAddr2);
			pstmt.setString(3, ophone);
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	public int deleteOrderDelivery(int onum) {
		int re = -1;
		String sql = "delete OrderDelivery where onum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, onum);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public BE_OrderDeliveryVo OrderDetaillistAll(String id){
		BE_OrderDeliveryVo od = null;
		BE_DeliveryComVo vo=null;
		String sql = 
				"select onum, pname, ocount, oprice, odate, odAddr1, odAddr2, ophone, odzip, dstatus, dnum, dcname" + 
				"from (select pname, pnum from (select pnum from OrderDelivery o, product p where o.pnum=p.pnum) op," + 
				"product p , (select dstatus, dnum, dcname from deliverycom) d, orderDelivery o where o.pnum = op.pnum" + 
				" and d.dcnum= o.dcnum and id=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				vo = new BE_DeliveryComVo();
				od = new BE_OrderDeliveryVo();
				od.setoNum(rs.getInt(1));
				rs.getString(2);//pname
				od.setoCount(rs.getInt(3));
				od.setoPrice(rs.getInt(4));
				od.setoDate(rs.getDate(5));
				od.setOdAddr1(rs.getString(6));
				od.setOdAddr2(rs.getString(7));
				od.setoPhone(rs.getString(8));
				od.setOdZip(rs.getString(9));
				vo.setdStatus(rs.getString(10));
				vo.setdNum(rs.getString(11));
				vo.setDcName(rs.getString(10));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return od;
	}
	
	public ArrayList<BE_OrderDeliveryVo> OrderDeliverylistAll(int onum){
		ArrayList<BE_OrderDeliveryVo> list = new ArrayList<BE_OrderDeliveryVo>();
		String sql = "select  * from OrderDelivery where onum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, onum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				BE_OrderDeliveryVo od = new BE_OrderDeliveryVo();
				od.setoNum(rs.getInt(1));
				od.setbeUid(rs.getString(2));
				od.setpNum(rs.getInt(3));
				od.setDcNum(rs.getInt(4));
				od.setoCount(rs.getInt(5));
				od.setoPrice(rs.getInt(6));
				od.setOdAddr1(rs.getString(7));
				od.setOdAddr2(rs.getString(8));
				od.setoPhone(rs.getString(9));
				od.setoDate(rs.getDate(10));
				od.setOdZip(rs.getString(11));
				
				list.add(od);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
}
