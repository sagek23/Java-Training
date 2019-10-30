package com.bit.dao;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BbsVo;

public class BbsDao {
	
	public int getNextNo()
	{
		int re = 0;
		try {
			String sql = "select nvl(max(num),0)+1 from bbs";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				re = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public ArrayList<BbsVo> listBbs(){
		ArrayList<BbsVo> list =  new ArrayList<BbsVo>();
		String sql = "select num, title, writer, credate, b_ref, b_level, b_step from bbs order by b_ref desc, b_step";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				v.setNum(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setWriter(rs.getString(3));
				v.setCredate(rs.getDate(4));
				v.setB_ref(rs.getInt(5));
				v.setB_level(rs.getInt(6));
				v.setB_step(rs.getInt(7));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public BbsVo listBbsDetail(int num){
		BbsVo v = new BbsVo();
		String sql = "select * from bbs where num =?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				v.setNum(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setWriter(rs.getString(3));
				v.setContent(rs.getString(5));
				v.setViews(rs.getInt(6));
				v.setCredate(rs.getDate(7));
				v.setFname(rs.getString(9));
				v.setB_ref(rs.getInt(10));
				v.setB_level(rs.getInt(11));
				v.setB_step(rs.getInt(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return v;
	}
	public int insertBbs(BbsVo v) {
		int re = -1;
		String sql = "insert into bbs values(?, ?,?,?,?,0,sysdate,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, v.getNum());
			pstmt.setString(2, v.getTitle());
			pstmt.setString(3, v.getWriter());
			pstmt.setString(4, v.getPwd());
			pstmt.setString(5, v.getContent());
			pstmt.setString(6, v.getIp());
			pstmt.setString(7, v.getFname());
			pstmt.setInt(8, v.getB_ref());
			pstmt.setInt(9, v.getB_level());
			pstmt.setInt(10, v.getB_step());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public void updateStep(int b_ref, int b_step) {
		// TODO Auto-generated method stub
		String sql = "update bbs set b_step = b_step+1 where b_ref=? and b_step > ?"; 
		//새로운 답글이 작성될 경우 원래의 b_step을 업데이트
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
