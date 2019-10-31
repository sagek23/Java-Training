package BE_UserDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.ConnectionProvider;
import BE_UserVo.BE_DivVo;
import BE_UserVo.BE_PointVo;
import BE_UserVo.BE_UserVo;
import BE_UserVo.BE_UsergradeVo;

public class BE_UserDao {
	
	// 회원가입 insert문
	public int InsertUser(BE_UserVo vo){
		int re = -1;
		String sql = "insert into be_user values(?, ?, ?, ?, ?, ?,sysdate, ?, ?, ?, ?, sysdate, ?, ?, ?,1) ";
		try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getBeUid());
				pstmt.setString(2, vo.getUpw());
				pstmt.setString(3, vo.getSex());
				pstmt.setDate(4, vo.getBirth());
				pstmt.setString(5, vo.getUname());
				pstmt.setString(6, vo.getScNum());;
				pstmt.setString(7, vo.getAddr1());
				pstmt.setString(8, vo.getAddr2());
				pstmt.setString(9, vo.getuPhone());
				pstmt.setString(10, vo.getEmail());
				pstmt.setString(11, vo.getPf1());
				pstmt.setString(12, vo.getPf2());
				pstmt.setString(13, vo.getPf3());
				
				re = pstmt.executeUpdate();
				ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	//
	public int UpdateUser(BE_UserVo vo, String uid) throws ClassNotFoundException, SQLException {
		int re = -1;
		
		String sql = "update be_user set upw=?,addr1=?,addr2=?,uphone=? where beuid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUpw());
			pstmt.setString(2, vo.getAddr1());
			pstmt.setString(3, vo.getAddr2());
			pstmt.setString(4, vo.getuPhone());
			pstmt.setString(5, uid);
	
			re = pstmt.executeUpdate();		
			ConnectionProvider.close(conn, pstmt);
			}catch(Exception e) {
				System.out.println(e.getMessage());
		}
		
		return re;
	}
	//id �뜝�럡�뀭�뜝�럩�젷 占쎈쑏熬곣뫅�삕�뵓怨뺣쐡占쎄퉰 �뜝�럩�꼪�뜝�럩逾�
		public boolean DeleteUserConfirm(String BUid, String beUpw) throws ClassNotFoundException, SQLException{
			boolean b = false;
			String sql = "select * from be_user where BUid=? and beupw=?";
			ResultSet rs = null;
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, BUid);
			pstmt.setString(2, beUpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = true;
			}
			ConnectionProvider.close(  conn,pstmt);
			return b;
		}
	
	
	// 회원삭제
	public int DeleteUser(String BUid) throws ClassNotFoundException, SQLException{
		boolean b = false;
		String sql = "update be_user set beuid = 0, upw = 0, uname = 0, scnum = 0, addr1 = 0, addr2 = 0, uphone = 0 where beuid=? ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, BUid);
		int re = pstmt.executeUpdate();
		if(re>0) {
			b = true;
		}
		ConnectionProvider.close(conn,pstmt);
		return re;
	}
	 
	public int UserLogin(String BUid, String beUpw)
	    {
	        int re = -1;
	        String sql = 
	        "select upw from be_user where beuid=?";
	        try {
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, BUid);
	            ResultSet rs =pstmt.executeQuery();
	            if(rs.next())
	            {
	                if(rs.getString(1).equals(beUpw))
	                {
	                    re =  1;
	                }
	                else
	                {
	                    re = 0;
	                }
	            }
	             
	            ConnectionProvider.close(conn, pstmt, rs);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        return re;
	    }
	
//	// id 繞벿살탮占쎄텢嶺뚳퐢�샑野껓옙
//	public boolean IdCheckUser(String BUid) throws ClassNotFoundException, SQLException {
//		boolean re = false;
//		String sql = "select BUid from be_user where BUid=?";
//		ResultSet rs =null;
//		Connection conn = ConnectionProvider.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, BUid);
//		rs = pstmt.executeQuery();
//		if(rs.next()) {
//			re = true;
//			System.out.println("繞벿살탮占쎄텢�뜝�럥彛� �뜝�럥�닡�뜝�럩逾졾뜝�럥�꺏 �뜝�럩肉��뜝�럥鍮띶뜝�럥堉�.");
//		} else {
//			re = false;
//			System.out.println("�뜝�럡�뀬�뜝�럩�뮔 �뤆�룊�삕�뜝�럥裕잌뜝�럥由� �뜝�럥�닡�뜝�럩逾졾뜝�럥�꺏 �뜝�럩肉��뜝�럥鍮띶뜝�럥堉�.");
//		}
//		ConnectionProvider.close(conn, pstmt, rs);
//		return re;
//	}
	
	// �뜝�럩�뤂�뜝�럩�쐸�뜝�럩�젧�솻洹⑥삕 占쎄껀占쎈쐞占쎌몠�뜝�럩沅롧뼨�먯삕 
	public ArrayList<BE_UserVo> UserListAll() throws ClassNotFoundException, SQLException{
		ArrayList<BE_UserVo> list = new ArrayList<BE_UserVo>();
		String sql = "select * from be_user";
		ResultSet rs = null;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		while(rs.next()) {
			String BUid = rs.getString("BUid");
			String beUpw = rs.getString("Upw");
			String sex = rs.getString("Sex");
			Date birth = rs.getDate("birth");
			String uname = rs.getString("uname");
			long scNum = rs.getLong("scNum");
			Date loginLog = rs.getDate("loginLog");
			String addr = rs.getString("addr");
			long uPhone = rs.getLong("uPhone");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			String pf1 = rs.getString("pf1");
			String pf2 = rs.getString("pf2");
			String pf3 = rs.getString("pf3");
			int beGradeNum = rs.getInt("beGradeNum");
			
		// ??????	
		//	list.add(new Be_UserVo(BUid, beUpw, sex, birth, uname, scNum, loginLog, addr, uPhone, email, joinDate, pf1, pf2, pf3, beGradeNum));
		}
		return list;
	}
		
	
	// �뜝�럩逾좑옙逾녑뜝占�, �뜝�럥�돻�뜝�럥援▼뜝�럥竊잏뵓怨뺣쐡占쎄퉰�슖�댙�삕 �뜝�럥�닡�뜝�럩逾졾뜝�럥�꺏 嶺뚢돦堉먪뵳占�
	public String IdSearchPhone(String uname, String uPhone) throws ClassNotFoundException, SQLException{
		String BUid = null;
		String sql = "select BUid from be_user where uname=? and uPhone=?";
		ResultSet rs = null;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uname);
		pstmt.setString(2, uPhone);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BUid = rs.getString("BUid");
		}
		
		ConnectionProvider.close(conn, pstmt, rs);
		return BUid;
	}
	// �뜝�럩逾좑옙逾녑뜝占�, �뜝�럩逾좂춯濡ル뾼占쎈뎄�슖�댙�삕 �뜝�럥�닡�뜝�럩逾졾뜝�럥�꺏 嶺뚢돦堉먪뵳占�
	public String IdSearchEmail(String uname, String email) throws ClassNotFoundException, SQLException {
		String BUid = null;
		String sql = "select BUid from be_user where uname=? and email=?";
		ResultSet rs = null;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uname);
		pstmt.setString(2, email);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BUid = rs.getString("BUid");
		}
		
		ConnectionProvider.close(conn, pstmt, rs);
		return BUid;
	}
	// 占쎈쐻占쎈윪�얠쥜�삕�얜뀘�쐻�뜝占�, 占쎈쐻占쎈윥占쎈뤋占쎈쐻占쎈윥�뤃�뼹�쐻占쎈윥塋딆엺�쐻占쎈윪筌뤿뱶�뒙占쎈뙔占쎌굲 �뜝�럥�몡�넭怨ｋ쳟占쎌굲占쎈탶�⑤베�맇�뜝�럡�돭 癲ル슓�룱�젆癒る뎨�뜝占�
	public String PwSearchPhone(String uname, String uPhone,String BUid) throws ClassNotFoundException, SQLException{
		String pwd = null;
		String sql = "select upw from be_user where uname=? and uPhone=? and  bUid=?";
		ResultSet rs = null;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uname);
		pstmt.setString(2, uPhone);
		pstmt.setString(3, BUid);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			pwd = rs.getString("upw");
		}
		
		ConnectionProvider.close(conn, pstmt, rs);
		return pwd;
	}//수정들어가서 파일수정
	// 占쎈쐻占쎈윪�얠쥜�삕�얜뀘�쐻�뜝占�, 占쎈쐻占쎈윪�얠쥉異�嚥▲꺂毓쇔뜝�럥�럡占쎌뒙占쎈뙔占쎌굲 �뜝�럥�몡�넭怨ｋ쳟占쎌굲占쎈탶�⑤베�맇�뜝�럡�돭 癲ル슓�룱�젆癒る뎨�뜝占�
	public String PwSearchEmail(String uname, String email,String BUid) throws ClassNotFoundException, SQLException {
		String pwd = null;
		String sql = "select upw from be_user where uname=? and email=? and  bUid=?";
		ResultSet rs = null;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uname);
		pstmt.setString(2, email);
		pstmt.setString(3, BUid);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			pwd = rs.getString("upw");
		}
		
		ConnectionProvider.close(conn, pstmt, rs);
		return pwd;
	}
	
	public BE_UserVo user_info(String beuid) {
		BE_UserVo vo = new BE_UserVo();
		String sql = "select * from be_user where beuid = '"+beuid+"'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo.setBeUid(rs.getString(1));
				vo.setUpw(rs.getString(2));
				vo.setSex(rs.getString(3));
				vo.setBirth(rs.getDate(4));
				vo.setUname(rs.getString(5));
				vo.setScNum(rs.getString(6));
				vo.setLoginLog(rs.getDate(7));
				vo.setAddr1(rs.getString(8));
				vo.setAddr2(rs.getString(9));
				vo.setuPhone(rs.getString(10));
				vo.setEmail(rs.getString(11));
				vo.setJoinDate(rs.getDate(12));
				vo.setPf1(rs.getString(13));
				vo.setPf2(rs.getString(14));
				vo.setPf3(rs.getString(15));
				vo.setGradeNum(rs.getInt(16));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vo;
	}
	
	
	
	
	
	
	
	
	
}
