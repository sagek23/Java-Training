package BE_PurchaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_PurchaseVo.BE_PayVo;
import BE_PurchaseVo.BE_PurchaseVo;

import DB.ConnectionProvider;

public class BE_PayDao {
	public int insertPay(BE_PayVo v) {
		int re=-1;
		String sql = "insert into pay values(seq_pay.nextval, ?,?,sysdate,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getPayWay());
			pstmt.setString(2, v.getPayCondition());
			pstmt.setInt(3, v.getPayPrice());
			pstmt.setInt(4, v.getApproveNum());
			pstmt.setInt(5, v.getPcNum());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int deletePay(int paynum,int approveNum) {
		int re = -1;
		String sql = "delete pay where paynum=? ApproveNum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paynum);
			pstmt.setInt(2, approveNum);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
	public ArrayList<BE_PayVo> PaylistAll(){
		ArrayList<BE_PayVo> list = new ArrayList<BE_PayVo>();
		String sql = "select * from Pay";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BE_PayVo v= new BE_PayVo();
				v.setPayNum(rs.getInt(1));
				v.setPayWay(rs.getString(2));
				v.setPayCondition(rs.getString(3));
				v.setPayDate(rs.getDate(4));
				v.setPayPrice(rs.getInt(5));
				v.setApproveNum(rs.getInt(6));
				v.setPcNum(rs.getInt(7));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
