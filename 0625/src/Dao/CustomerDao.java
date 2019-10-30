package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.ConnectionProvider;
import vo.CustomerVo;

public class CustomerDao {
	
	public int insertCustomer(CustomerVo c) //���� ���� ������ CustomerVo�� �Ƿ��� ��.
											//�Ʒ� ?�� ������ ������ �������
	{
		int re = -1; // 1�� �ƴ� ������ �ƹ� ���̳� ���� ��.
		
		String sql = "insert into customer values(seq_customer.nextval, ?, ?, ?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			
			re = pstmt.executeUpdate();
		
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
		
		/*int�� ���� �����ϴ� ����:
		 * int re = executeUpdate();
	�����ͺ��̽� ��ɾ Update, insert, delete�� ��
	insert�� update, delete�� ���������� ������ ���ڵ��� ��(����)��
	��ȯ�ϱ� ������ int�� ���� ����
		
		*/
	}
	
}
