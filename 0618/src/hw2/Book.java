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
//	å(å��ȣ pk,å�̸�,����,����,���ǻ�)
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
		lb1 = new JLabel("å��ȣ");
		lb2 = new JLabel("å�̸�");
		lb3 = new JLabel("����");
		lb4 = new JLabel("����");
		lb5 = new JLabel("���ǻ�");
		
		tfNum = new JTextField(10);
		tfName = new JTextField(10);
		tfPri = new JTextField(10);
		tfAut = new JTextField(10);
		tfPub= new JTextField(10);
		
		btnS = new JButton("���");
		btnR= new JButton("�о����");
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("å��ȣ");
		colNames.add("å�̸�");
		colNames.add("����");
		colNames.add("����");
		colNames.add("���ǻ�");
		
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
				JOptionPane.showMessageDialog(this, "����� �Է��ߴ��� Ȯ���Ͻÿ�");
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
				System.out.println("�߰�����");
			else
				System.out.println("�߰�����");
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
