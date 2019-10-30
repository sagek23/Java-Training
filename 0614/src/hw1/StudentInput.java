package hw1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentInput extends JFrame implements ActionListener {

	JLabel lb1;
	JLabel lb2;
	JTextField tfName, tfNo;
	JButton btn;
	
	StudentInput()
	{
		setLayout(new FlowLayout());
		setTitle("학생 등록");
		lb1 = new JLabel("이름");
		lb2 = new JLabel("번호");
		tfName = new JTextField(10);
		tfNo = new JTextField(10);
		btn = new JButton("등록");
		
		add(lb1);
		add(tfName);
		add(lb2);
		add(tfNo);
		add(btn);
		btn.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = tfName.getText();
		String no = tfNo.getText();
		int num = Integer.parseInt(no);
		
		try {
			String sqls = "insert into student values ('"+name+"',"+num+")";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			int a = stmt.executeUpdate(sqls);
			if (a==1)
				System.out.println("추가 성공");
			else
				System.out.println("추가 실패");
			
			stmt.close();
			conn.close();
			
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
			
			
		}
	}

}
