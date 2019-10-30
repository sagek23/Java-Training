package BE_AdminDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_AdminVo.BE_AdminVo;
import BE_AdminVo.BE_EventVo;
import BE_AdminVo.BE_FaqVo;
import DB.ConnectionProvider;

public class BE_EventDao {
//	int ENum;
//	String EName;
//	Date EDate;
//	String E_Image;
	
	
	 public int InsertEvent(BE_EventVo b)
	    {
	        int re = -1;
	        try {
	            String sql = "insert into Event values(seq_Event.nextval,?,?,sysdate)";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, b.geteName());
	            pstmt.setString(2, b.getE_Image());
	            
	           
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	    }
	 
	 public int UpdateEvent(BE_EventVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "update Event set EName=?,E_Image=? where ENum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, b.geteName());
	            pstmt.setString(2, b.getE_Image());
	            pstmt.setInt(3, b.geteNum());
	            pstmt.setInt(4, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re; 
	 }
	 public int DeleteEvent(BE_EventVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "delete from Event where FaqNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, b.geteNum());
	            pstmt.setInt(2, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	 }
	 
	 
	 public ArrayList<BE_EventVo> EventlistAll()
	 {
		 String sql="selct * from Event";
		 ArrayList<BE_EventVo> list = new ArrayList<BE_EventVo>();
		 try {
			 Connection conn = ConnectionProvider.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs= stmt.executeQuery(sql);
			 
			 while(rs.next())
			 {
				 BE_EventVo b = new BE_EventVo();
				 int ENum=rs.getInt(1);
				 String EName=rs.getString(2);
				 Date EDate=rs.getDate(3);
				 String E_Image=rs.getString(4);
				 
				 b.setE_Image(EName);
				 b.seteNum(ENum);
				 b.seteDate(EDate);
				 b.setE_Image(E_Image);
				 list.add(b);
				 
			 }
			 
			 ConnectionProvider.close(conn, stmt,rs);
		 }catch (Exception e) {
			 // TODO: handle exception
			 System.out.println(e.getMessage());
		 }
		 
		 return list;
	 }
	 public BE_EventVo Eventlist(int num) {
		 BE_EventVo vo = new BE_EventVo();
		 String sql = "select * from event where enum ="+num;
		 try {
			 Connection conn = ConnectionProvider.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 if(rs.next()) {
				 vo.seteNum(rs.getInt(1));
				 vo.seteName(rs.getString(2));
				 vo.seteDate(rs.getDate(3));
				 vo.setE_Image(rs.getString(4));
			 }
		 } catch (Exception e) {
			 // TODO: handle exception
			 System.out.println(e.getMessage());
		 }
		 return vo;
	 }
	 
}
