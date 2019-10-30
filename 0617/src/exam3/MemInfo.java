package exam3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MemInfo extends JFrame{

	JLabel lb1;
	JLabel lb2;
	JTextField tfName;
	JTextField tfAge;
	JButton btnAdd;
	JButton btnRead;
	JTable jt;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public MemInfo()
	{
		lb1= new JLabel("이름");
		lb2= new JLabel("나이");
		tfName = new JTextField(10);
		tfAge = new JTextField(10);
		
		btnAdd = new JButton("등록");
		btnRead = new JButton("출력");
		
		
		colNames  = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colNames.add("이름");
		colNames.add("나이");
		
		jt = new JTable(rowData,colNames);
		
		jt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jt.getSelectedRow();
				System.out.println(row);
			}
		});
		
		
		
		
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel up = new JPanel(); //일종의 컨테이너로 아래의 속성을 담아 하나로 만든다.
		up.setLayout(new FlowLayout());
		up.add(lb1);
		up.add(tfName);
		up.add(lb2);
		up.add(tfAge);
		up.add(btnAdd);
		up.add(btnRead);
		
		
		add(up, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertMem();
			}
		});//ActionListener 인터페이스를 구현한 클래스의 객체
		btnRead.addActionListener(new ActionListener() { //()안에 클래스 생성
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMem();
			}
		});
	}
	
	

	private void printMem() {
		// TODO Auto-generated method stub
		
		rowData.clear();
		
		String sql = "select * from member";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:xe", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			//int a = stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) //다음 인덱스가 있는 동안 루프
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1)); //인덱스를 1부터 카운트
				v.add(rs.getInt(2)+"");
				rowData.add(v);
			}
			rs.close();
			stmt.close();
			conn.close();
			
			jt.updateUI();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void insertMem() {
		// TODO Auto-generated method stub

		
		if (tfName.getText().trim().equals("") || tfAge.getText().trim().equals(""))
		{  //공백만 입력하거나 입력을 하지않고 등록을 눌렀을 때
			
			//System.out.println("입력값을 확인하세요");
			//System.exit(0); //프로그램 종료
			JOptionPane.showMessageDialog(this, "이름과 나이를 입력하세요.");
			tfName.setText("");
			tfAge.setText("");
			return;
		}
		String name = tfName.getText();
		try {
		String age = tfAge.getText();
		int a = Integer.parseInt(age);
		String sql="insert into member values ('"+name+"',"+a+")";
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
		Statement stmt = conn.createStatement();
		int b = stmt.executeUpdate(sql);
		if (b==1)
			System.out.println("추가성공");
		else
			System.out.println("추가실패");
		
		stmt.close();
		conn.close();
	
		printMem();
		
		}catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "예외발생"+e.getMessage());
		}
	}

}
