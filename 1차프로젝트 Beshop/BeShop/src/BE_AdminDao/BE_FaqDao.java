package BE_AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import BE_AdminVo.BE_AdminVo;
import BE_AdminVo.BE_FaqVo;
import DB.ConnectionProvider;

public class BE_FaqDao {
	
		 public int InsertFaq(BE_FaqVo b)
	    {
	        int re = -1;
	        try {
	            String sql = "insert into FAQ values(seq_FAQ.nextval,?,?)";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, b.getFaqName());
	            pstmt.setString(2, b.getFaq_Con());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	    }
		 public int UpdateFaq(BE_FaqVo b,BE_AdminVo a)
		 {
			 int re = -1;
		        try {
		            String sql = "update FAQ set FaqName=?,Faq_Con=? where FaqNum=? and AdminNum=?";
		            Connection conn = ConnectionProvider.getConnection();
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, b.getFaqName());
		            pstmt.setString(2, b.getFaq_Con());
		            pstmt.setInt(3, b.getFaqNum());
		            pstmt.setInt(4, a.getAdminNum());
		        
		            re = pstmt.executeUpdate();
		            ConnectionProvider.close(conn, pstmt);
		             
		        }catch (Exception e) {
		            // TODO: handle exception
		            System.out.println(e.getMessage());
		        }
		        return re; 
		 }
		 
	 public int DeleteFaq(BE_FaqVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "delete from FAQ where FaqNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, b.getFaqNum());
	            pstmt.setInt(2, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	 }
	 
	
	 public ArrayList<BE_FaqVo> FaqlistAll()
		{
		String sql="selct * from FAQ";
		ArrayList<BE_FaqVo> list = new ArrayList<BE_FaqVo>();
	    try {
	        Connection conn = ConnectionProvider.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs= stmt.executeQuery(sql);
	         
	        while(rs.next())
	        {
	            BE_FaqVo b = new BE_FaqVo();
	            int FaqNum = rs.getInt(1);
	            String FaqName = rs.getString(2);
	            //String Faq_Con = rs.getString(3);
	          
	             
	            b.setFaqNum(FaqNum);
	            b.setFaqName(FaqName);
	            //b.setFaq_Con(Faq_Con);
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
