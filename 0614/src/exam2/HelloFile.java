package exam2;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HelloFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		int age;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ���==> ");
		name = sc.next();
		System.out.print("���̸� �Է��ϼ���==> ");
		age = sc.nextInt();
		
		
		try{
			String sql = "insert into member values('"+name+"',"+age+")";
			
			//1.JDBC ����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB������ �����Ѵ�.
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			//@�ڴ� IP�ּ�:1521:XE
			
			//3.Statement ��ü�� ����. sql��ɾ� �������� ������ �ִ� Ŭ����
			Statement stmt = conn.createStatement();
			
			//4.�����ͺ��̽� ����� ���� 
		    //executeQuery(�ڷ�Ȯ��), executeUpdate(�ڷ��߰�, ����, ���� �� DB�� ������ ���� �� )
			int re = stmt.executeUpdate(sql);
			if (re==1)
				System.out.println("�߰�����");
			else
				System.out.println("�߰�����");
			//5.����ߴ� �ڿ��� �ݾ��ش�. ���߿� ���� �ͺ��� �ݱ�/
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
				// TODO: handle exception
			System.out.println(e.getMessage());
			}
		}
}

