package BE_ShoppingDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import BE_ShoppingVo.BE_ProductVo;
import BE_ShoppingVo.BE_ReviewVo;
import DB.ConnectionProvider;

public class BE_ReViewDao {
	public int insertReview(BE_ReviewVo ro){
		int r=0;
		String sql = "insert into review values((select max(renum)+1 from review),?,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ro.getbeUid());
			ps.setInt(2, ro.getpNum());
			ps.setString(3, ro.getReTitle());
			ps.setInt(4, ro.getReGrade());
			ps.setInt(5, ro.getRe_Hits());
			ps.setDate(6, (Date)ro.getReDate());
			ps.setString(7, ro.getReContent());
			ps.setString(8, ro.getRe_Answer());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	public int deleteReview(int no){
		int r=0;
		String sql="delete review where renum="+no;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			r = st.executeUpdate(sql);
			ConnectionProvider.close(conn, st, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	public int updateReview(BE_ReviewVo ro){
		int r=0;
		String sql="update review set uid=?,pnum=?,retitle=?,regrade=?,re_his=?,redate=?,re_con=?,re_answer=? where renum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ro.getbeUid());
			ps.setInt(2, ro.getpNum());
			ps.setString(3, ro.getReTitle());
			ps.setInt(4, ro.getReGrade());
			ps.setInt(5, ro.getRe_Hits());
			ps.setDate(6, (Date)ro.getReDate());
			ps.setString(7, ro.getReContent());
			ps.setString(8, ro.getRe_Answer());
			ps.setInt(9, ro.getReNum());
			r = ps.executeUpdate();
			ConnectionProvider.close(conn, ps, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	public ArrayList<BE_ReviewVo> ReViewlistAll(String uid){
		ArrayList<BE_ReviewVo> Review_list = new ArrayList<BE_ReviewVo>();
		String sql = "select * from review where beuid = '"+uid+"'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_ReviewVo vo = new BE_ReviewVo();
				int Renum;
				String Uid;
				int Pnum;
				String Retitle;
				int Regrade;
				int Re_his;
				Date Redate;
				String Re_con;
				String Re_answer;
				
				vo.setReNum(rs.getInt(1));
				vo.setbeUid(rs.getString(2));
				vo.setpNum(rs.getInt(3));
				vo.setReTitle(rs.getString(4));
				vo.setReGrade(rs.getInt(5));
				vo.setRe_Hits(rs.getInt(6));
				vo.setReDate(rs.getDate(7));
				vo.setReContent(rs.getString(8));
				vo.setRe_Answer(rs.getString(9));
			
				
				Review_list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return Review_list;
		
	}
	
public BE_ReviewVo ReViewlist(int renum){
		
		String sql = "select * from review where renum = ?";
		BE_ReviewVo vo = new BE_ReviewVo();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, renum);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.next()) {
				
				vo.setReNum(rs.getInt(1));
				vo.setbeUid(rs.getString(2));
				vo.setpNum(rs.getInt(3));
				vo.setReTitle(rs.getString(4));
				vo.setReGrade(rs.getInt(5));
				vo.setRe_Hits(rs.getInt(6));
				vo.setReDate(rs.getDate(7));
				vo.setReContent(rs.getString(8));
				vo.setRe_Answer(rs.getString(9));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return vo;
	}
	
public ArrayList<BE_ReviewVo> selectReviewAll(int renum){
	ArrayList<BE_ReviewVo> Review_list = new ArrayList<BE_ReviewVo>();
	String sql = "select * from review where renum= ? order by renum";
	try {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, renum);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			BE_ReviewVo vo = new BE_ReviewVo();
			vo.setReNum(rs.getInt(1));
			vo.setbeUid(rs.getString(2));
			vo.setpNum(rs.getInt(3));
			vo.setReTitle(rs.getString(4));
			vo.setReGrade(rs.getInt(5));
			vo.setRe_Hits(rs.getInt(6));
			vo.setReDate(rs.getDate(7));
			vo.setReContent(rs.getString(8));
			vo.setRe_Answer(rs.getString(9));
		
			
			Review_list.add(vo);
		}
		ConnectionProvider.close(conn, pstmt, rs);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return Review_list;
	
}
public ArrayList<BE_ReviewVo> selectReview(){
	ArrayList<BE_ReviewVo> list = new ArrayList<BE_ReviewVo>();
	String sql = "select * from review order by renum";
	try {
		Connection conn = ConnectionProvider.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			BE_ReviewVo vo = new BE_ReviewVo();
			vo.setReNum(rs.getInt(1));
			vo.setbeUid(rs.getString(2));
			vo.setpNum(rs.getInt(3));
			vo.setReTitle(rs.getString(4));
			vo.setReGrade(rs.getInt(5));
			vo.setRe_Hits(rs.getInt(6));
			vo.setReDate(rs.getDate(7));
			vo.setReContent(rs.getString(8));
			vo.setRe_Answer(rs.getString(9));
			list.add(vo);
		}
		ConnectionProvider.close(conn, stmt, rs);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return list;
}

}
