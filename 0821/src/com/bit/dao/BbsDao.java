package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BbsVo;

public class BbsDao {
	public ArrayList<BbsVo> listBbs(){
		ArrayList<BbsVo> list =  new ArrayList<BbsVo>();
		String sql = "select num, title, writer, credate from bbs";
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
		String sql = "insert into bbs values((select nvl(max(num),0)+1 from bbs), ?,?,?,?,0,sysdate,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getTitle());
			pstmt.setString(2, v.getWriter());
			pstmt.setString(3, v.getPwd());
			pstmt.setString(4, v.getContent());
			pstmt.setString(5, v.getIp());
			pstmt.setString(6, v.getFname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
