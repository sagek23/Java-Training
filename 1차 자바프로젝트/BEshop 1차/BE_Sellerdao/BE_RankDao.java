package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_SellerVo.BE_VideoVo;
import BE_ShoppingVo.BE_ProductVo;
import DB.ConnectionProvider;


public class BE_RankDao {
	
	// 랭킹 검색(video 테이블)
	public int SearchRank(int vnum) {
		int re = -1;
		BE_VideoVo vo = new BE_VideoVo();
		
		String sql = "select v.vnum, v.vname, v.vupdate, v.beuid, p.hits, p.likes "
				+ "from channel c, video v, product p, seller s where v.snum = s.snum "
				+ "and s.pnum = p.pnum and c.snum = v.snum order by likes desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			pstmt.setInt(1, vo.getPnum());
			while(rs.next()) {
				vo.setBeUid(rs.getString(1));
				
			}
			
			
		ConnectionProvider.close(conn, pstmt, rs);	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return re;
	}
	
	// 	video 제목 조회
	public BE_VideoVo searchTitle(int vnum) {
		BE_VideoVo vo = new BE_VideoVo();
	
		String sql = "select * from video where vnum =" +vnum;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				vo.setVnum(rs.getInt(1));
				vo.setVname(rs.getString(2));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println("ss"+e.getMessage());
		}
//		System.out.println(vo.toString());
		return  vo;
	}
	
	// video 등록일 조회
	public BE_VideoVo searchVupdate(int vnum) {
		BE_VideoVo vo = new BE_VideoVo();
		String sql = "select * from video where vnum =" + vnum;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo.setVnum(rs.getInt(1));
				vo.setVupdate(rs.getDate(4));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		System.out.println(vo.toString());
		
		return vo;
	}
	
	// 판매자 아이디 조회
	public BE_VideoVo searchBuid(int vnum) {
		BE_VideoVo vo = new BE_VideoVo();
		String sql = "select * from video where vnum =" + vnum;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo.setVnum(rs.getInt(1));
				vo.setBeUid(rs.getString(6));
			}
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		System.out.println(vo.toString());
		return vo;
	}
	
	// video 리스트 
	public ArrayList<BE_VideoVo> VideolistAll(){
		ArrayList<BE_VideoVo> video_list = new ArrayList<BE_VideoVo>();
//		String sql = "select * from video where beuid='"+bUid+"'";
		String sql = "select * from video ";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BE_VideoVo vo = new BE_VideoVo();
	
				vo.setVnum(rs.getInt(1));
				vo.setVname(rs.getString(2));
				vo.setVfile(rs.getString(3));
				vo.setVupdate(rs.getDate(4));
				vo.setPnum(rs.getInt(5));
				vo.setBeUid(rs.getString(6));
				vo.setSnum(rs.getInt(7));
				vo.setFormnum(rs.getInt(8));
				vo.setFormdate(rs.getDate(9));
				vo.setVtime(rs.getTime(10));
				vo.setVtag(rs.getString(11));
				video_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		//System.out.println(video_list.toString());
		return video_list;
	}
	
	// 조회수 증가
	public BE_ProductVo videoHit(int pnum) {
		BE_ProductVo vo = new BE_ProductVo();
		String sql = "update product set hits = hits + 1 where pnum =" + pnum;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		System.out.println(vo.toString());
		return vo;
	}
	
}
