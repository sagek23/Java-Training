package BE_AdminDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BE_AdminVo.BE_AdminVo;
import BE_AdminVo.BE_CqnaVo;
import BE_AdminVo.BE_AdministrationVo;
import BE_AdminVo.BE_CqnaVo;
import BE_AdminVo.BE_FaqVo;
import DB.ConnectionProvider;

public class BE_CqnaDao {
	
	
	
	 public int InsertCqna(BE_CqnaVo b)
	    {
	        int re = -1;
	        try {
	            String sql = "insert into Cqna values(seq_FAQ.nextval,?,?,?,?)";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	           
	            pstmt.setInt(1, b.getCqnaS());
	            pstmt.setString(2, b.getCqnaName());
	            pstmt.setString(3, b.getCqna_Con());
	            pstmt.setString(4, b.getCq_Answer());

	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	    }
	 
	
	 public int UpdateCqna(BE_CqnaVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "update Cqna set Cqnas=?,Cqna_Con=?,CqnaName=?,Cq_Answer=? where CqNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	  	        pstmt.setInt(1, b.getCqnaS());
	            pstmt.setString(2, b.getCqna_Con());
	            pstmt.setString(3, b.getCqnaName());
	            pstmt.setString(4, b.getCq_Answer());
	            pstmt.setInt(5, b.getCqNum());
	            pstmt.setInt(6, a.getAdminNum());
	            
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re; 
	 }
	 public int DeleteCqna(BE_CqnaVo b,BE_AdminVo a)
	 {
		 int re = -1;
	        try {
	            String sql = "delete from Cqna where NoNum=? and AdminNum=?";
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, b.getCqNum());
	            pstmt.setInt(2, a.getAdminNum());
	        
	            re = pstmt.executeUpdate();
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	 }
	 
	 public ArrayList<BE_CqnaVo> CqnalistAll()
		{
		String sql="select * from Cqna";
		ArrayList<BE_CqnaVo> list = new ArrayList<BE_CqnaVo>();
	    try {
	        Connection conn = ConnectionProvider.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs= stmt.executeQuery(sql);
	         
	        while(rs.next())
	        {
	        	BE_CqnaVo b = new BE_CqnaVo();
	        	int CqNum=rs.getInt(1);
	        	int CqnaS=rs.getInt(2);
	        	String CqnaName=rs.getString(3);
	        	String Cqna_Con=rs.getString(4);
	        	String Cq_Answer=rs.getString(5);
	        	
	        	b.setCqNum(CqNum);
	        	b.setCqnaS(CqnaS);
	        	b.setCqnaName(CqnaName);
	        	b.setCqna_Con(Cqna_Con);
	        	b.setCq_Answer(Cq_Answer);
	        	
	            list.add(b);
	             
	        }
	         
	        ConnectionProvider.close(conn, stmt,rs);
	    }catch (Exception e) {
	        // TODO: handle exception
	        System.out.println(e.getMessage());
	    }
	     
	    return list;
	}
	 public ArrayList<BE_CqnaVo> CqnalistAll(String str)
		{
		String sql="select * from Cqna where cqnaname like '"+str+"%'";
		ArrayList<BE_CqnaVo> list = new ArrayList<BE_CqnaVo>();
	    try {
	        Connection conn = ConnectionProvider.getConnection();
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        while(rs.next())
	        {
	        	BE_CqnaVo b = new BE_CqnaVo();
	        	
	        	b.setCqNum(rs.getInt(1));
	        	b.setCqnaS(rs.getInt(2));
	        	b.setCqnaName(rs.getString(3));
	        	b.setCqna_Con(rs.getString(4));
	        	b.setCq_Answer(rs.getString(5));
	            list.add(b);
	        }
	         
	        ConnectionProvider.close(conn, st ,rs);
	    }catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	     
	    return list;
	}
}
