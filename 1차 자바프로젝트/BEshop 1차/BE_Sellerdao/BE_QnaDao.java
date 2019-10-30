package BE_Sellerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import  BE_SellerVo.BE_QnaVo;

import DB.ConnectionProvider;

public class BE_QnaDao {
	public int insertQna(BE_QnaVo vo) {
		int re = -1;
		String sql = "insert into qna values(?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQnanum());
			pstmt.setString(2, vo.getSec_Pw());
			pstmt.setString(3, vo.getQna_Title()); 
			pstmt.setString(4, vo.getQna_Content());
			pstmt.setString(5, vo.getQna_Answer());
			pstmt.setString(6, vo.getbeUid());
			pstmt.setInt(7, vo.getpNum());
			pstmt.setDate(8, vo.getAnswer_Time());
			pstmt.setDate(9, vo.getRegist_Date());
			pstmt.setString(10, vo.getQna_Category());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	public int updateQna(BE_QnaVo vo) {
		int re = -1;
		String sql = "update qna set sec_pw=?,qna_title=?,qna_con=?,qna_answer=?,uid=?,pnum=?,answer_time=?,regist_time=?,qna_categroy=? where qnanum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSec_Pw());
			pstmt.setString(2, vo.getQna_Title());
			pstmt.setString(3, vo.getQna_Content());
			pstmt.setString(4, vo.getQna_Answer());
			pstmt.setString(5, vo.getbeUid());
			pstmt.setInt(6, vo.getpNum());
			pstmt.setDate(7,vo.getAnswer_Time());
			pstmt.setDate(8, vo.getRegist_Date());
			pstmt.setString(9, vo.getQna_Category());
			pstmt.setInt(10, vo.getQnanum());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int deleteQna(BE_QnaVo vo) {
		int re = -1;
		String sql = "delete qna where qnanum=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQnanum());
			
			re= pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
		
	}
	
	public ArrayList<BE_QnaVo> QnalistAll(){
		ArrayList<BE_QnaVo> qna_list = new ArrayList<BE_QnaVo>();
		String sql = "select * from Qna";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_QnaVo vo = new BE_QnaVo();
				vo.setQnanum(rs.getInt(1));
				vo.setSec_Pw(rs.getString(2));
				vo.setQna_Title(rs.getString(3));
				vo.setQna_Content(rs.getString(4));
				vo.setQna_Answer(rs.getString(5));
				vo.setbeUid(rs.getString(6));
				vo.setpNum(rs.getInt(7));
				vo.setAnswer_Time(rs.getDate(8));
				vo.setRegist_Date(rs.getDate(9));
				vo.setQna_Category(rs.getString(10));
				
				qna_list.add(vo);	
			}
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return qna_list;
	}
	public ArrayList<BE_QnaVo> selectQna() {
		ArrayList<BE_QnaVo> list = new ArrayList<BE_QnaVo>();
		String sql = "select * from Qna order by qnanum";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BE_QnaVo vo = new BE_QnaVo();
				vo.setQnanum(rs.getInt(1));
				vo.setSec_Pw(rs.getString(2));
				vo.setQna_Title(rs.getString(3));
				vo.setQna_Content(rs.getString(4));
				vo.setQna_Answer(rs.getString(5));
				vo.setbeUid(rs.getString(6));
				vo.setpNum(rs.getInt(7));
				vo.setAnswer_Time(rs.getDate(8));
				vo.setRegist_Date(rs.getDate(9));
				vo.setQna_Category(rs.getString(10));
				
				list.add(vo);	
			}
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public ArrayList<BE_QnaVo> selectQnaAll(int qnanum) {
		ArrayList<BE_QnaVo> list = new ArrayList<BE_QnaVo>();
		String sql = "select * from Qna where qnanum=? order by qnanum";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnanum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BE_QnaVo vo = new BE_QnaVo();
				vo.setQnanum(rs.getInt(1));
				vo.setSec_Pw(rs.getString(2));
				vo.setQna_Title(rs.getString(3));
				vo.setQna_Content(rs.getString(4));
				vo.setQna_Answer(rs.getString(5));
				vo.setbeUid(rs.getString(6));
				vo.setpNum(rs.getInt(7));
				vo.setAnswer_Time(rs.getDate(8));
				vo.setRegist_Date(rs.getDate(9));
				vo.setQna_Category(rs.getString(10));
				
				list.add(vo);	
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
}
