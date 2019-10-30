package hw2;

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

public class Book extends JFrame {
//	책(책번호 pk,책이름,가격,저자,출판사)
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	JLabel lb5;
	
	JTextField tfNum;
	JTextField tfName;
	JTextField tfPri;
	JTextField tfAut;
	JTextField tfPub;
	
	JButton btnS;
	JButton btnR;
	
	JTable jt;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public Book()
	{
		lb1 = new JLabel("책번호");
		lb2 = new JLabel("책이름");
		lb3 = new JLabel("가격");
		lb4 = new JLabel("저자");
		lb5 = new JLabel("출판사");
		
		tfNum = new JTextField(10);
		tfName = new JTextField(10);
		tfPri = new JTextField(10);
		tfAut = new JTextField(10);
		tfPub= new JTextField(10);
		
		btnS = new JButton("등록");
		btnR= new JButton("읽어오기");
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("책번호");
		colNames.add("책이름");
		colNames.add("가격");
		colNames.add("저자");
		colNames.add("출판사");
		
		jt = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		JPanel jp = new JPanel();
		
		setLayout(new BorderLayout());
		jp.setLayout(new FlowLayout());
		jp.add(lb1);
		jp.add(tfNum);
		jp.add(lb2);
		jp.add(tfName);
		jp.add(lb3);
		jp.add(tfPri);
		jp.add(lb4);
		jp.add(tfAut);
		jp.add(lb5);
		jp.add(tfPub);
		jp.add(btnS);
		jp.add(btnR);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1000, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBook();
			}
		});
		btnR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printBook();
			}
		});
		
		
	}

	protected void addBook() {
		// TODO Auto-generated method stub
		rowData.clear();
		try {
			if(tfNum.getText().trim().equals("")||tfName.getText().trim().equals("")||tfPri.getText().trim().equals("")||
					tfAut.getText().trim().equals("")||tfPub.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "제대로 입력했는지 확인하시오");
				tfNum.setText("");
				tfName.setText("");
				tfPri.setText("");
				tfAut.setText("");
				tfPub.setText("");
				return;
			}
			int num = Integer.parseInt(tfNum.getText());
			String name = tfName.getText();
			int pri = Integer.parseInt(tfPri.getText());
			String aut = tfAut.getText();
			String pub = tfPub.getText();
			
			String sql = "insert into book values("+num+",'"+name+"',"+pri+",'"+aut+"','"+pub+"')";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97", "c##bit1235", "bit1235");
			Statement stmt = conn.createStatement();
			int a = stmt.executeUpdate(sql);
			
			if (a==1)
				System.out.println("추가성공");
			else
				System.out.println("추가실패");
			stmt.close();
			conn.close();
			printBook();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	protected void printBook() {
		// TODO Auto-generated method stub
		
		rowData.clear();
		String sql = "select * from book order by bnum";
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1235", "bit1235");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
					
			while(rs.next())
			{
				Vector<String> v= new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));
				v.add(rs.getInt(3)+"");
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				
				rowData.add(v);
			}
				rs.close();
				stmt.close();
				conn.close();
					
				jt.updateUI();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
