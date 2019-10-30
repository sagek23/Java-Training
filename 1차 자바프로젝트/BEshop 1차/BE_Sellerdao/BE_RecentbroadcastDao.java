package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import  BE_SellerVo.BE_QnaVo;
import  BE_SellerVo.BE_RecentbroadcastVo;

import DB.ConnectionProvider;

public class BE_RecentbroadcastDao {
	public int insertRecent(BE_RecentbroadcastVo vo) {
		int re = -1;
		String sql = "insert into Recentbroadcast values(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getbeUid());
			pstmt.setInt(2, vo.getvNum());
			pstmt.setInt(3, vo.getpNum());
			re = pstmt.executeUpdate();
			
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	
	public int updateRecent(BE_RecentbroadcastVo vo) {
		int re = -1;
		String sql = "update recentbroadcast set vnum=?, pnum=? where uid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getvNum());
			pstmt.setInt(2, vo.getpNum());
			pstmt.setString(3, vo.getbeUid());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int deleteRecent(BE_RecentbroadcastVo vo) {
		int re = -1;
		String sql = "delete recentbroadcast where uid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbeUid());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<BE_RecentbroadcastVo> RecentlistAll(){
		ArrayList<BE_RecentbroadcastVo> recent_list = new ArrayList<BE_RecentbroadcastVo>();
		String sql = "select * from Recentbroadcast";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_RecentbroadcastVo vo = new BE_RecentbroadcastVo();
				vo.setbeUid(rs.getString(1));
				vo.setvNum(rs.getInt(2));
				vo.setpNum(rs.getInt(3));
				recent_list.add(vo);	
			}
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return recent_list;
	}
	
	
}
