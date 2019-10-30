package BE_PurchaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import BE_PurchaseVo.BE_DeliveryComVo;

import DB.ConnectionProvider;
//택배업체정보수정
public class BE_DeliveryComDao {
	
	public int insertDeliveryCom(BE_DeliveryComVo v) {
		int re =-1;
		String sql = "insert into DeliverCom values(sec_dcnum.nextval, ?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getLicenseNum());
			pstmt.setString(2, v.getDcName());
			pstmt.setString(3, v.getDcPhone());
			pstmt.setString(4, v.getDcAddr());
			pstmt.setInt(5, v.getdCharge());
			pstmt.setString(6, v.getdStatus());
			pstmt.setString(7, v.getdNum());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int updateDeliveryCom(BE_DeliveryComVo v) {
		int re =-1;
		String sql = "update DeliverCom set DcName=?,DcPhone=?,DcAddr=?,dCharge=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, v.getDcName());
			pstmt.setString(2, v.getDcPhone());
			pstmt.setString(3, v.getDcAddr());
			pstmt.setInt(4, v.getdCharge());
		
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int updateDstatus(String dstatus) {
		int re = -1;
		String sql = "update DeliveryCom set dstatus =?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dstatus);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int deleteDeliveryCom(int dnum) {
		int re = -1;
		String sql = "delete DeliveryCom where dnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dnum);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public BE_DeliveryComVo listAllDstatus(String dnum) {
		BE_DeliveryComVo v=null;
		String sql = "select dstatus, dnum where dnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dnum);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				v = new BE_DeliveryComVo();
				v.setdStatus(rs.getString(1));
				v.setdNum(rs.getString(2));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return v;
	}
	public ArrayList<BE_DeliveryComVo> DelivertComlistAll(int dcnum){
		ArrayList<BE_DeliveryComVo> list = new ArrayList<BE_DeliveryComVo>();
		String sql = "select * from DeliveryCom where dcnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dcnum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				BE_DeliveryComVo dc = new BE_DeliveryComVo();
				dc.setDcNum(rs.getInt(1));
				dc.setLicenseNum(rs.getString(2));
				dc.setDcName(rs.getString(3));
				dc.setDcPhone(rs.getString(4));
				dc.setDcAddr(rs.getString(5));
				dc.setdCharge(rs.getInt(6));
				dc.setdNum(rs.getString(7));
				dc.setdStatus(rs.getString(8));
				
				list.add(dc);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
}
