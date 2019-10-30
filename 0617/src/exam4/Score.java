package exam4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.sun.corba.se.spi.orbutil.fsm.State;

public class Score extends JFrame {
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	JLabel lb5;
	JLabel lb6;
	JLabel lb7;
		
	JTextField tfNum;
	JTextField tfName;
	JTextField tfKor;
	JTextField tfEng;
	JTextField tfMath;
	
	JButton btnAdd;
	JButton btnRead;
	JTable jt;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public Score()
	{
		lb1 = new JLabel("번호");
		lb2 = new JLabel("이름");
		lb3 = new JLabel("국어");
		lb4 = new JLabel("영어");
		lb5 = new JLabel("수학");
		lb6 = new JLabel("총점");
		lb7 = new JLabel("평균");
			
		tfNum = new JTextField(10);
		tfName = new JTextField(10);
		tfKor = new JTextField(10);
		tfEng = new JTextField(10);
		tfMath = new JTextField(10);
		
		btnAdd = new JButton("등록");
		btnRead = new JButton("출력");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colNames.add("번호");
		colNames.add("이름");
		colNames.add("국어");
		colNames.add("영어");
		colNames.add("수학");
		colNames.add("총점");
		colNames.add("평균");
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		jp.add(lb1);
		jp.add(tfNum);
		jp.add(lb2);
		jp.add(tfName);
		jp.add(lb3);
		jp.add(tfKor);
		jp.add(lb4);
		jp.add(tfEng);
		jp.add(lb5);
		jp.add(tfMath);
		jp.add(btnAdd);
		jp.add(btnRead);

		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertSco();
				
			}
		});
		btnRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				printSco();
			}
		});
	}
		
	
			private void insertSco() {
				// TODO Auto-generated method stub
			
		
			
		try {
			if(tfName.getText().trim().equals("")||tfNum.getText().trim().equals("")||tfKor.getText().trim().equals("")||
					tfEng.getText().trim().equals("")||tfMath.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "제대로 입력했는지 확인하시오");
				tfNum.setText("");
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
				tfMath.setText("");
				return;
			}
			String num = tfNum.getText();
			int n = Integer.parseInt(num);
			String name = tfName.getText();
			String kor = tfKor.getText();
			int k = Integer.parseInt(kor);
			String eng = tfEng.getText();
			int e = Integer.parseInt(eng);
			String math = tfMath.getText();
			int m = Integer.parseInt(math);
			int total = k+e+m;
			int avr = total/3;
			String sql = "insert into student values("+n+",'"+name+"',"+k+","+e+","+m+","+total+","+avr+")";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			int c = stmt.executeUpdate(sql);
			if (c==1)
				System.out.println("추가성공");
			else
				System.out.println("추가실패");
			
			stmt.close();
			conn.close();
			printSco();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
			private void printSco() {
				// TODO Auto-generated method stub
					
			rowData.clear();
			String sql = "select * from student";
				
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
						
				while(rs.next())
				{
					Vector<String> v= new Vector<String>();
					v.add(rs.getInt(1)+"");
					v.add(rs.getString(2));
					v.add(rs.getInt(3)+"");
					v.add(rs.getInt(4)+"");
					v.add(rs.getInt(5)+"");
					v.add(rs.getInt(6)+"");
					v.add(rs.getInt(7)+"");
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
		
	}

