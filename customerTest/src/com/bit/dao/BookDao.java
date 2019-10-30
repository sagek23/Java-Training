package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BookVo;
@Repository
public class BookDao {
	public ArrayList<BookVo> listAll()
	{
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BookVo v = new BookVo();
				v.setBookid(rs.getInt(1));
				v.setBookname(rs.getString(2));
				v.setPublisher(rs.getString(3));
				v.setPrice(rs.getInt(4));
				list.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public BookVo detailBook(int bookid)
	{
		BookVo v = null;
		String sql = "select * from book where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				v = new BookVo();
				v.setBookid(rs.getInt(1));
				v.setBookname(rs.getString(2));
				v.setPublisher(rs.getString(3));
				v.setPrice(rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return v;
	}
	
	public int insertBook(BookVo b)
	{
		int re = -1;
		String sql = "insert into book values(?, ?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			re= pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int updateBook(BookVo b)
	{
		int re=-1;
		String sql = "update book set bookname=?, publisher=?, price=?  WHERE bookid = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getPrice());
			pstmt.setInt(4, b.getBookid());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
