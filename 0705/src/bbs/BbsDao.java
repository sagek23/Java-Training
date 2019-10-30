package bbs;

import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import Connection.ConnectionProvider;
import member.memberDao;
import member.memberVo;

public class BbsDao {

	public int bbsWrite(BbsVo vo)
	{
	
		int re = -1;
		
		String sql = "insert into bbs values (seq_board.nextval, ?,?,?,?,0,sysdate)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getContent());
			//pstmt.setInt(5, vo.getViews());
		
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public int bbsUpdate(BbsVo vo)
	{
		int re = -1;
		
		
		try {
			String sql = "update bbs set title = ?, content=?  where num = ? and pwd = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			pstmt.setString(4, vo.getPwd());
			
			re = pstmt.executeUpdate();
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
	
	public int deleteBbs(int num, String pwd)
	{
		int re =-1;
		int del = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
		if (del!=0);
		String sql = "delete bbs where num = ? and pwd = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pwd);
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if(re>0)
				JOptionPane.showMessageDialog(null, "삭제성공");
			else
				JOptionPane.showMessageDialog(null, "삭제실패");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	
	public ArrayList<BbsVo> listAll()
	{
		
		ArrayList<BbsVo> list = new ArrayList<BbsVo>();
		String sql = "select * from bbs";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String pwd = rs.getString(4);
				String content = rs.getString(5);
				int views = rs.getInt(6);
				Date creDate = rs.getDate(7);
				
				v.setNum(num);
				v.setTitle(title);
				v.setWriter(writer);
				v.setPwd(pwd);
				v.setContent(content);
				v.setViews(views);
				v.setCreDate(creDate);
			
				list.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		return list;
	}
	
	public ArrayList<BbsVo> listMine(String id)
	{
		
		ArrayList<BbsVo> list = new ArrayList<BbsVo>();
		String sql = "select * from bbs where writer = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String pwd = rs.getString(4);
				String content = rs.getString(5);
				int views = rs.getInt(6);
				Date creDate = rs.getDate(7);
				
				v.setNum(num);
				v.setTitle(title);
				v.setWriter(writer);
				v.setPwd(pwd);
				v.setContent(content);
				v.setViews(views);
				v.setCreDate(creDate);
			
				list.add(v);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		return list;
	}
	
	public ArrayList<BbsVo> listSearch(String tfSearch, String search)
	{	
		ArrayList<BbsVo> listS = new ArrayList<BbsVo>();

		String sql = "select * from bbs where "+tfSearch+" like '%"+search+"%'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String pwd = rs.getString(4);
				String content = rs.getString(5);
				int views = rs.getInt(6);
				Date creDate = rs.getDate(7);
				
				v.setNum(num);
				v.setTitle(title);
				v.setWriter(writer);
				v.setPwd(pwd);
				v.setContent(content);
				v.setViews(views);
				v.setCreDate(creDate);
			
				listS.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		return listS;
	}
	
	public ArrayList<BbsVo> listBbs(String writer, boolean top5, String  searchField, String keyword, String sort)
	{	
		ArrayList<BbsVo> listS = new ArrayList<BbsVo>();

		String sql = "select * from bbs ";
		
		if(!writer.equals(""))
		{
			sql = sql+" where writer '"+writer+"'";
		}
		else if(top5 ==true)
		{
			sql = "select * from (select * from (select * from bbs order by views desc) where rownum <=2)";
		}
		else if(!keyword.equals(""))
		{
			sql = sql+" where "+searchField+" like '%"+keyword+"%'";
		}
			
		if(!sort.equals(""))
		{
			sql = sql+" order by "+sort;
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String pwd = rs.getString(4);
				String content = rs.getString(5);
				int views = rs.getInt(6);
				Date creDate = rs.getDate(7);
				
				v.setNum(num);
				v.setTitle(title);
				v.setWriter(id);
				v.setPwd(pwd);
				v.setContent(content);
				v.setViews(views);
				v.setCreDate(creDate);
			
				listS.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		return listS;
	}
	public void updateView(int num)
	{
		String sql = "update bbs set views = views+1 where num = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void Orderby(String column)
	{
		String sql = "select"+"'+column+'"+" from bbs order by "+"'+column+'"+"desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		
	}

	public ArrayList<BbsVo> listTop(int view)
	{

		ArrayList<BbsVo> listTop = new ArrayList<BbsVo>();
		String sql ="select * from (select * from (select * from bbs order by views desc) where rownum <=2)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				BbsVo v = new BbsVo();
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String pwd = rs.getString(4);
				String content = rs.getString(5);
				int views = rs.getInt(6);
				Date creDate = rs.getDate(7);
				
				v.setNum(num);
				v.setTitle(title);
				v.setWriter(writer);
				v.setPwd(pwd);
				v.setContent(content);
				v.setViews(views);
				v.setCreDate(creDate);
			
				listTop.add(v);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return listTop;
	}
	
}
