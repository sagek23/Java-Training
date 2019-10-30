package hw3;

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

public class Customer extends JFrame {

	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	
	JTextField tfNum;
	JTextField tfName;
	JTextField tfAddr;
	JTextField tfTel;
	
	JButton btnA;
	JButton btnR;
	
	JTable jt;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public Customer()
	{
		lb1 = new JLabel("고객번호");
		lb2 = new JLabel("고객명");
		lb3 = new JLabel("주소");
		lb4 = new JLabel("전화번호");
		
		tfNum = new JTextField(10);
		tfName = new JTextField(10);
		tfAddr = new JTextField(10);
		tfTel = new JTextField(10);
		
		btnA = new JButton("등록");
		btnR = new JButton("읽어오기");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("고객번호");
		colNames.add("고객명");
		colNames.add("주소");
		colNames.add("전화번호");
		
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
		jp.add(tfAddr);
		jp.add(lb4);
		jp.add(tfTel);
		jp.add(btnA);
		jp.add(btnR);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1000, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCusto();
				readCusto();
			}
		});
		
		btnR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readCusto();
			}
		});
		
	}

	protected void readCusto() {
		// TODO Auto-generated method stub
		//String name = tfName.getText();
		rowData.clear();
		String sql = "select * from customer order by cnum";
		//String sql = "select cname from customer where cname = '"+name+"'";
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
				v.add(rs.getString(3));
				v.add(rs.getString(4));
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

	protected void addCusto() {
		// TODO Auto-generated method stub
		try {
			if(tfNum.getText().trim().equals("")||tfName.getText().trim().equals("")||tfAddr.getText().trim().equals("")||
					tfTel.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "제대로 입력했는지 확인하시오");
				tfNum.setText("");
				tfName.setText("");
				tfAddr.setText("");
				tfTel.setText("");
				return;
			}
			int num = Integer.parseInt(tfNum.getText());
			String name = tfName.getText();
			String addr = tfAddr.getText();
			String tel = tfTel.getText();
			
			String sql = "insert into customer values("+num+",'"+name+"','"+addr+"','"+tel+"')";
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
			jt.updateUI();
			
			readCusto();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
