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
		
		System.out.print("이름을 입력하세요==> ");
		name = sc.next();
		System.out.print("나이를 입력하세요==> ");
		age = sc.nextInt();
		
		
		try{
			String sql = "insert into member values('"+name+"',"+age+")";
			
			//1.JDBC 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB서버에 연결한다.
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			//@뒤는 IP주소:1521:XE
			
			//3.Statement 객체를 생성. sql명령어 실행기능을 가지고 있는 클래스
			Statement stmt = conn.createStatement();
			
			//4.데이터베이스 명령을 실행 
		    //executeQuery(자료확인), executeUpdate(자료추가, 수정, 삭제 등 DB에 변동이 있을 때 )
			int re = stmt.executeUpdate(sql);
			if (re==1)
				System.out.println("추가성공");
			else
				System.out.println("추가실패");
			//5.사용했던 자원을 닫아준다. 나중에 만든 것부터 닫기/
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
				// TODO: handle exception
			System.out.println(e.getMessage());
			}
		}
}

