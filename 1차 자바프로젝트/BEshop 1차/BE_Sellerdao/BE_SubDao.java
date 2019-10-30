package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_SellerVo.BE_SubVo;
import BE_SellerVo.BE_VideoVo;
import DB.ConnectionProvider;


public class BE_SubDao {
	public int insertSub(BE_SubVo vo) {
		int re = -1;
		String sql = "insert into sub values(?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSnum()); //�Ǹ��ڹ�ȣ
			pstmt.setString(2, vo.getbeUid()); // ���̵�
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return re;	
	}
	public int updateSub(BE_SubVo vo) {
		int re = -1;
		String sql = "update sub set snum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSnum()); //�Ǹ��ڹ�ȣ
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn , pstmt, null);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;	
	}
	public int deleteSub(BE_SubVo vo) {
		int re = -1;
		String sql = "delete sub where uid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbeUid()); // ���̵�
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;	
	}
	public ArrayList<BE_SubVo> SublistAll(){
		ArrayList<BE_SubVo> sub_list = new ArrayList<BE_SubVo>();
		String sql = "select * from sub";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_SubVo vo = new BE_SubVo();
				vo.setSnum(rs.getInt(1));
				vo.setbeUid(rs.getString(6));
				sub_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return sub_list;
	}
	
	
	// 판매자 영상제목 호출
	public BE_VideoVo searchTitle(int vnum) {
		BE_VideoVo vo = new BE_VideoVo();
	
		String sql = "select * from video where vnum = "+vnum;
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
			System.out.println(e.getMessage());
		}
		//System.out.println(vo.toString());
		return  vo;
	}
	
	// video 테그 보여주기
	public BE_VideoVo searchTag(int vnum) {
		BE_VideoVo vo = new BE_VideoVo();
		String sql = "select * from video where vnum = " + vnum;
//		String sql = "select * from video ";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				vo.setVtag(rs.getString(11));
			}
			
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//System.out.println(vo.toString());
		
		return vo;
	}
	public ArrayList<BE_VideoVo> SearchNameList() {
		ArrayList<BE_VideoVo> list = new ArrayList<BE_VideoVo>();
		String sql = "";
		
		
		
		return list;
	}
	
}
