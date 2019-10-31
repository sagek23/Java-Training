package BE_UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BE_UserVo.BE_DivVo;
import BE_UserVo.BE_UserVo;
import BE_UserVo.BE_UsergradeVo;
import DB.ConnectionProvider;

public class BE_UserGradeDao {

	// 占쎈쾻疫뀐옙 鈺곌퀬�돳
		public String gradeSearch(BE_UsergradeVo gvo, BE_UserVo uvo) throws ClassNotFoundException, SQLException{
			String grade ="";
			String sql = "select begrade(select begrade from BE_usergrade g, BE_user u where g.begradenum = u.begradenum and beuid=?), count(beonum), sum(beoprice) from BE_orderdilivery o, BE_user u, BE_customer c where u.beuid = c.beuid and u.beuid = o.beuid and beuid =?";
			ResultSet rs = null;
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uvo.getBeUid() );
			rs = pstmt.executeQuery();
			if(rs.next()) {
				grade = rs.getString("begrade");
				
				ConnectionProvider.close(conn, pstmt, rs);
			}
			return grade;
		}
		
		// �뤃�됲뀋 占쎈쾻疫뀐옙
		public int divGrade(BE_DivVo vo) throws ClassNotFoundException, SQLException{
			int re = -1;
			String sql ="select beuid from bediv where bednum =? "; 
			ResultSet rs = null;
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getdNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(vo.getdNum()) == 0) {
					re = rs.getInt(0);
				}else if(rs.getInt(vo.getdNum()) ==1) {
					re = rs.getInt(1);
				}else if(rs.getInt(vo.getdNum()) == 2) {
					re = rs.getInt(2);
				}
				
			}
			ConnectionProvider.close(conn, pstmt, rs);
			return re;
			
		}
}
