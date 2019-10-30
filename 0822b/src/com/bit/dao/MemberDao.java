package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bit.db.ConnectionProvider;
import com.bit.vo.MemberVo;

public class MemberDao {
	public int insertMem(MemberVo v) {
		int re = -1;
		String sql ="insert into member values(?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			pstmt.setString(5, v.getTel());
			pstmt.setString(6, v.getAddr());
			pstmt.setString(7, v.getHobby());
			pstmt.setString(8, v.getJob());
			pstmt.setString(9, v.getSex());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
