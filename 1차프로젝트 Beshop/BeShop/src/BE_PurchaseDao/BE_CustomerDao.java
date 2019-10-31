package BE_PurchaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DB.ConnectionProvider;
import BE_PurchaseVo.BE_CustomerVo;
import BE_PurchaseVo.BE_OrderDeliveryVo;

import DB.ConnectionProvider;

public class BE_CustomerDao {//Dao筌띾슢諭얏묾怨뺣뮉 占쎈뻥占쎈뮉占쎈쑓 占쎈뱜�뵳�덇탢嚥∽옙 占쎄퐫占쎈선占쎈튊 占쎈막野껓옙 揶쏆늿�벉
	public int insertCustomer(BE_CustomerVo v, BE_OrderDeliveryVo vo) {
		int re=-1;
		String sql = "insert into customer values(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getbeUid());
			pstmt.setInt(2, v.getSlNum());
			pstmt.setInt(3, vo.getoNum());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	
	public int deleteCustomer(String id) {
		int re = -1;
		String sql = "delete Customer where id = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
	public ArrayList<BE_CustomerVo> CustomerlistAll(String uid) {
		ArrayList<BE_CustomerVo> list = new ArrayList<BE_CustomerVo>();
		String sql = "select * from customer where uid = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				BE_CustomerVo cv = new BE_CustomerVo();
				cv.setbeUid(rs.getString(1));
				cv.setSlNum(rs.getInt(2));
				cv.setoNum(rs.getInt(3));
				list.add(cv);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
