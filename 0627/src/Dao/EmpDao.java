package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import Connection.ConnectionProvider;
import Vo.EmpVo;

public class EmpDao {

	//��� ����� �˻��� ����� ArrayList�� ��� ��ȯ�ϴ� �޼ҵ�
	//��� �Ѹ� �Ѹ��� ������ EmpVo�� ����
	public ArrayList<EmpVo> listEmp()
	{
		String sql = "select * from emp";
		ArrayList<EmpVo> list= new ArrayList<EmpVo>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				EmpVo v = new EmpVo();
				v.setEno(rs.getInt(1));
				v.setEname(rs.getString(2));
				v.setAddr(rs.getString(3));
				v.setSal(rs.getInt(4));
				v.setComm(rs.getInt(5));
				v.setJob(rs.getString(6));
				v.setTel(rs.getString(7));
				v.setHiredate(rs.getDate(8));
				v.setMgr(rs.getInt(9));
				v.setDno(rs.getInt(10));
				v.setEmail(rs.getString(11));
				
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
