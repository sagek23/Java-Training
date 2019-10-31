package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_SellerVo.BE_ChannelVo;

import DB.ConnectionProvider;

public class BE_ChannelDao {
	public int insertChannel(BE_ChannelVo vo) {
		int re = -1;
		String sql = "insert into channel values(?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getChnum()); //채널번호
			pstmt.setInt(2, vo.getSnum()); // 판매자번호
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;	
	}
	public int updateChannel(BE_ChannelVo vo) {
		int re = -1;
		String sql = "update channel set chnum=?, snum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getChnum()); //채널번호
			pstmt.setInt(2, vo.getSnum()); // 판매자번호
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;	
	}
	public int deleteChannel(BE_ChannelVo vo) {
		int re = -1;
		String sql = "delete channel where chnum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getChnum()); //채널번호
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;	
	}
	
	public ArrayList<BE_ChannelVo> ChannellistAll(){
		ArrayList<BE_ChannelVo> ch_list = new ArrayList<BE_ChannelVo>();
		String sql = "select * from channel";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_ChannelVo vo = new BE_ChannelVo();
				vo.setChnum(rs.getInt(1));
				vo.setSnum(rs.getInt(2));
				ch_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return ch_list;
	}
}
