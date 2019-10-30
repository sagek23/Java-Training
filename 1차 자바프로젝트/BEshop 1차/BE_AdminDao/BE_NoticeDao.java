package BE_AdminDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import BE_AdminVo.BE_AdminVo;
import BE_AdminVo.BE_FaqVo;
import BE_AdminVo.BE_NoticeVo;
import BE_AdminVo.BE_NoticeVo;
import DB.ConnectionProvider;

public class BE_NoticeDao {
	
	
	 public int InsertNotice(BE_NoticeVo b)
	    {
	        int re = -1;
	        try {
	            String sql = "insert into Notice values(seq_FAQ.nextval,?,?,?,?)";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, b.getNotice_Ca());
	            pstmt.setDate(2, b.getNoticeDate());
	            pstmt.setString(3, b.getNotice_Con());
	            pstmt.setString(4, b.getNoticeName());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	    }
	 public int UpdateNotice(BE_NoticeVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "update Notice set NoticeName=?,Notice_Con=? where NoticeNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, b.getNoticeName());
	            pstmt.setString(2, b.getNotice_Con());
	            pstmt.setInt(3, b.getNoticeNum());
	            pstmt.setInt(4, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re; 
	 }
	 
	 public int DeleteNotice(BE_NoticeVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "delete from Notice where FaqNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, b.getNoticeNum());
	            pstmt.setInt(2, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	 }
	 

	 public ArrayList<BE_NoticeVo> NoticelistAll()
		{
		String sql="selct * from Notice";
		ArrayList<BE_NoticeVo> list = new ArrayList<BE_NoticeVo>();
	    try {
	        Connection conn = ConnectionProvider.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs= stmt.executeQuery(sql);
	         
	        while(rs.next())
	        {
	        	BE_NoticeVo b = new BE_NoticeVo();
	        	int NoticeNum=rs.getInt(1);
	        	String Notice_Ca=rs.getString(2);
	        	Date NoticeDate=rs.getDate(3);
	        	String Notice_Con=rs.getString(4);
	        	String NoticeName=rs.getString(5);
	          
	             
	            b.setNotice_Ca(Notice_Ca);
	            b.setNoticeNum(NoticeNum);
	            b.setNoticeDate(NoticeDate);
	           // b.setNotice_Con(Notice_Con);
	            list.add(b);
	             
	        }
	         
	        ConnectionProvider.close(conn, stmt,rs);
	    }catch (Exception e) {
	        // TODO: handle exception
	        System.out.println(e.getMessage());
	    }
	     
	    return list;
	}
}
