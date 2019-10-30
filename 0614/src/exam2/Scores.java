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
		
			System.out.print("번호를 입력하시오==> ");
			key=sc.nextInt();
			System.out.print("이름을 입력하시오==>");
			name=sc.next();
			System.out.print("국어점수를 입력하시오==>");
			kor=sc.nextInt();
			System.out.print("영어점수를 입력하시오==>");
			kor=sc.nextInt();
			System.out.print("수학점수를 입력하시오==>");
			math=sc.nextInt();
		
		try {
				String sql = "insert into student values("+key+",'"+name+"',"+kor+","+eng+","+math+")";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
				Statement stmt = conn.createStatement();
				
				int re=stmt.executeUpdate(sql);
				if(re==1)
					System.out.println("추가 성공");
				else
					System.out.println("추가실패");
				
				stmt.close();
				conn.close();
				
		}catch(Exception e) {System.out.println(e.getMessage());}
		
	}

}
