package BE_UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import BE_UserVo.BE_PointVo;
import DB.ConnectionProvider;

public class BE_PointDao {

		//포인트 충전 내역
		public  ArrayList<BE_PointVo> PointSearch(String beUid){ 
			ArrayList<BE_PointVo> list = new ArrayList<BE_PointVo>();
			String sql = "select pointpurnum, pointdetails, changemethod,changedate from point where beuid = ? order by changedate desc";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, beUid);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					BE_PointVo vo = new BE_PointVo();
					vo.setPointPurNum(rs.getInt(1));
					vo.setPointDetails(rs.getInt(2));
					vo.setChangeMethod(rs.getString(3));
					vo.setChangeDate(rs.getDate(4));
					
					list.add(vo);
				}	
				ConnectionProvider.close(conn, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			return list;
		}
	//현재 잔액 조회
		public BE_PointVo PointBalance(String beUid){ 
			BE_PointVo vo = new BE_PointVo();
			String sql = "select  pointbalance from point where beuid=?";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, beUid);
				ResultSet rs = pstmt.executeQuery();
				if(rs .next()){
					vo.setPointBalance(rs.getInt(1));
				}
				ConnectionProvider.close(conn, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}	
			return vo;
		}
		
		public int UpdatePoint(String beUid, int pointbalance){
			int re = -1;
			BE_PointVo vo = new BE_PointVo();
			String sql = "update point set pointbalance=pointbalance+? where beuid=?";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,  pointbalance);
				pstmt.setString(2, beUid);
				re = pstmt.executeUpdate();
				ConnectionProvider.close(conn, pstmt);
			} catch(Exception e ){
				System.out.println(e.getMessage());
			}
			return re;
		}
	
	// 占쎌맄占쎈뻻�뵳�딅뮞占쎈뱜 鈺곌퀬�돳
		public String WishlistSearch() throws ClassNotFoundException, SQLException{
			String wishlist = "";
			String sql = "select bechnum, bevnum, besnm from BE_chanel, BE_video, BE_wishlist, BE_seller, BE_user where BE_chanel.besnum = BE_seller.besnum and BE_video.besnum = BE_seller.besnum and BE_wishlist.besnum = BE_chanel.besnum and BE_wishlist.beuid = BE_user.beuid order by formdate desc;";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//wishlist = rs.getString("formdate");
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			return wishlist;
		}
}
