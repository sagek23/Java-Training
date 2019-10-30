package bbs;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connection.ConnectionProvider;

public class BbsDao {

	public int bbsWrite(BbsVo vo)
	{
		int re = -1;
		
		String sql = "insert into board values (seq_board.nextval, ?,?,?,?,0,sysdate)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getContent());
		
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int bbsUpd(BbsVo vo)
	{
		int re = -1;
		String sql = "update bbs set title = ?, content=?  where num = ? and pwd = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			pstmt.setString(4, vo.getPwd());
			
			ConnectionProvider.close(conn, pstmt);
			if (re>0)
				JOptionPane.showMessageDialog(null, "수정성공");
			else
				JOptionPane.showMessageDialog(null, "수정실패");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	public ArrayList<BbsVo> listSea()
	{
		ArrayList<BbsVo> list = new ArrayList<BbsVo>();
		String sql = "select * from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				v.setNo(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setWriter(rs.getString(3));
				v.setPwd(rs.getString(4));
				v.setContent(rs.getString(5));
				v.setHit(rs.getInt(6));
				v.setRegdate(rs.getDate(7));
				list.add(v);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
