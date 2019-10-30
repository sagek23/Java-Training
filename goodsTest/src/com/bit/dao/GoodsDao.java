package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.bit.db.ConnectionProvider;
import com.bit.vo.GoodsVo;

public class GoodsDao {
	GoodsVo v = new GoodsVo();
	public int insertGoods(GoodsVo vo) {
		int re = -1;
		String sql = "insert into goods values((select nvl(max(no),0)+1 from goods),?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getQty());
			pstmt.setString(4, vo.getFname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
	public ArrayList<GoodsVo> listAll(){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				v.setNo(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setPrice(rs.getInt(3));
				v.setQty(rs.getInt(4));
				v.setFname(rs.getString(5));
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	public GoodsVo detailGoods(int no){
		String sql = "select * from goods where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				v.setNo(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setPrice(rs.getInt(3));
				v.setQty(rs.getInt(4));
				v.setFname(rs.getString(5));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return v;
	}
}
