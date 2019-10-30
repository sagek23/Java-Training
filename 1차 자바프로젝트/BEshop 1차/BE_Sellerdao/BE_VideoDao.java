package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import  BE_SellerVo.BE_SellerVo;
import  BE_SellerVo.BE_VideoVo;
import BE_ShoppingVo.BE_ProductVo;
import DB.ConnectionProvider;

public class BE_VideoDao {
	public int insertVideo(BE_VideoVo vo) {
		int re = -1;
		
		String sql = "insert into video values(?,?,?,?,?,?,?,?,?,)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getVnum());
			pstmt.setDate(2, vo.getVupdate());
			pstmt.setInt(3, vo.getPnum());
			pstmt.setString(4, vo.getBeUid());
			pstmt.setInt(5, vo.getSnum());
			pstmt.setInt(6, vo.getFormnum());
			pstmt.setDate(7, vo.getFormdate());
			pstmt.setTime(8, vo.getVtime());
			pstmt.setString(9, vo.getVname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	
	
	public int updateVideo(BE_VideoVo vo) {
		int re = -1;
		String sql = "update video set pnum=?, snum=?, formnum=?, vtime=?, vname=? where vnum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			pstmt.setInt(2, vo.getSnum());
			pstmt.setInt(3, vo.getFormnum());
			pstmt.setTime(4, vo.getVtime());
			pstmt.setString(5, vo.getVname());
			pstmt.setInt(6, vo.getVnum());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int deleteVideo(BE_VideoVo vo) {
		int re = -1;
		String sql = "delete video where vnum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getVnum());
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<BE_VideoVo> VideolistAll(){
		ArrayList<BE_VideoVo> video_list = new ArrayList<BE_VideoVo>();
		String sql = "select * from video where uid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_VideoVo vo = new BE_VideoVo();
				vo.setVnum(rs.getInt(1));
				vo.setVupdate(rs.getDate(2));
				vo.setPnum(rs.getInt(3));
				vo.setBeUid(rs.getString(4));
				vo.setSnum(rs.getInt(5));
				vo.setFormnum(rs.getInt(6));
				vo.setFormdate(rs.getDate(7));
				vo.setVtime(rs.getTime(8));
				vo.setVname(rs.getString(9));
				video_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return video_list;
	}
	
	public ArrayList<BE_VideoVo> getVideo(int num){
		ArrayList<BE_VideoVo> video_list = new ArrayList<BE_VideoVo>();
		String sql="select vfile from video where vnum = "+num;
		try {
			System.out.println(sql);
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_VideoVo vo = new BE_VideoVo();
				
//				vo.setVnum(rs.getInt(1));
//				vo.setVname(rs.getString(2));
				vo.setVfile(rs.getString(1));
//				vo.setVupdate(rs.getDate(4));
//				vo.setPnum(rs.getInt(5));
//				vo.setBeUid(rs.getString(6));
//				vo.setSnum(rs.getInt(7));
//				vo.setFormnum(rs.getInt(8));
//				vo.setFormdate(rs.getDate(9));
//				vo.setVtime(rs.getTime(10));
//				vo.setVtag(rs.getString(11));

				video_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return video_list;
	}
	
	public int getnum() {
		String sql = "select count(vnum) from video";
		int r=0;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				r = rs.getInt(1);
			}
			ConnectionProvider.close(conn, st, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return r;
	}
}
