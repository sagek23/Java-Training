package exam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Scores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int key=0;
		int kor=0;
		int eng=0;
		int math=0;
		String name="";
		
			System.out.print("��ȣ�� �Է��Ͻÿ�==> ");
			key=sc.nextInt();
			System.out.print("�̸��� �Է��Ͻÿ�==>");
			name=sc.next();
			System.out.print("���������� �Է��Ͻÿ�==>");
			kor=sc.nextInt();
			System.out.print("���������� �Է��Ͻÿ�==>");
			kor=sc.nextInt();
			System.out.print("���������� �Է��Ͻÿ�==>");
			math=sc.nextInt();
		
		try {
				String sql = "insert into student values("+key+",'"+name+"',"+kor+","+eng+","+math+")";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
				Statement stmt = conn.createStatement();
				
				int re=stmt.executeUpdate(sql);
				if(re==1)
					System.out.println("�߰� ����");
				else
					System.out.println("�߰�����");
				
				stmt.close();
				conn.close();
				
		}catch(Exception e) {System.out.println(e.getMessage());}
		
	}

}
