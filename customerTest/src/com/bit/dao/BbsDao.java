package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BbsVo;
@Repository
public class BbsDao {
	public ArrayList<BbsVo> listAll(){
		ArrayList<BbsVo> list = new ArrayList<BbsVo>();
		String sql = "select * from bbs";
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
				v.setPwd(rs.getString(4));
				v.setContent(rs.getString(5));
				v.setViews(rs.getInt(6));
				v.setCredate(rs.getDate(7));
				v.setIp(rs.getString(8));
				v.setFname(rs.getString(9));
				v.setBref(rs.getInt(10));
				v.setBlevel(rs.getInt(11));
				v.setBstep(rs.getInt(12));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}

	public BbsVo getBbs(int num) {
		// TODO Auto-generated method stub
		BbsVo v = null;
		String sql = "select * from bbs where num = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				v = new BbsVo();
				v.setNum(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setWriter(rs.getString(3));
				v.setPwd(rs.getString(4));
				v.setContent(rs.getString(5));
				v.setViews(rs.getInt(6));
				v.setCredate(rs.getDate(7));
				v.setIp(rs.getString(8));
				v.setFname(rs.getString(9));
				v.setBref(rs.getInt(10));
				v.setBlevel(rs.getInt(11));
				v.setBstep(rs.getInt(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return v;
	}

	public int insert(BbsVo v) {
		// TODO Auto-generated method stub
		int re = -1;
		String sql = "insert into bbs values((select nvl(max(num),0)+1),?,?,?,?,0,sysdate,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
}
