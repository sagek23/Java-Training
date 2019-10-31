package BE_AdminDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import BE_AdminVo.BE_AdminVo;
import BE_AdminVo.BE_FaqVo;
import BE_AdminVo.BE_NotifyVo;
import BE_AdminVo.BE_NotifyVo;
import DB.ConnectionProvider;

public class BE_NotifyDao {
	
	
	//공지사항 제목없음
	 public int InsertNotify(BE_NotifyVo b)
	    {
	        int re = -1;
	        try {
	            String sql = "insert into Notify values(seq_FAQ.nextval,?,?,?,?,?)";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, b.getNoNum());
	            pstmt.setString(2, b.getNoTitle());
	            pstmt.setString(3, b.getNo_Con());
	            pstmt.setString(4, b.getbeUid());
	            pstmt.setInt(1, b.getvNum());
	            pstmt.setInt(1, b.getpNum());
	            
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	    }
	 public int UpdateNotify(BE_NotifyVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "update Notify set Notitle=?,No_Con=?,Pnum=?,Vnum=? where NoNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, b.getNoTitle());
	            pstmt.setString(2, b.getNo_Con());
	            pstmt.setInt(3, b.getpNum());
	            pstmt.setInt(3, b.getvNum());
	            pstmt.setInt(3, b.getNoNum());
	            pstmt.setInt(4, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re; 
	 }
	 public int DeleteNotify(BE_NotifyVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "delete from Notify where NoNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, b.getNoNum());
	            pstmt.setInt(2, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	 }
	 
	
	 public ArrayList<BE_NotifyVo> NotifylistAll()
		{
		String sql="selct * from Notify";
		ArrayList<BE_NotifyVo> list = new ArrayList<BE_NotifyVo>();
	    try {
	        Connection conn = ConnectionProvider.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs= stmt.executeQuery(sql);
	         
	        while(rs.next())
	        {
	        	BE_NotifyVo b = new BE_NotifyVo();
	        	
	        	int NoNum=rs.getInt(1);
	        	String NoTitle=rs.getString(2);
	        	String No_Con=rs.getString(3);
	        	String UId=rs.getString(4);
	        	int VNum=rs.getInt(5);
	        	int	PNum=rs.getInt(6);
	           
	        	b.setNoNum(NoNum);
	        	b.setNoTitle(NoTitle);
	        	b.setNo_Con(No_Con);
	        	b.setUid(UId);
	        	b.setvNum(VNum);
	        	b.setpNum(PNum);
	        	
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
