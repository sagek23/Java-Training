package hw1;

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

import jdk.nashorn.internal.scripts.JS;

public class Order extends JFrame {

	JLabel lb1;
	JButton btnS;
	
	JTable jt;
	JTextField tfName;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	public Order()
	{
		lb1 = new JLabel("�̸�");
		btnS = new JButton("�˻�");
		
		tfName = new JTextField(10);
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		/*
		 * ����ȣ, �����̸�, �ּ�, ��ȭ 
		�ֹ��� ������, ����, ���ǻ�, ����, �ֹ�����, 
		�ֹ��ݾ�, �ֹ���*/
		
		colNames.add("����ȣ");
		colNames.add("����");
		colNames.add("�ּ�");
		colNames.add("��ȭ��ȣ");
		colNames.add("������");
		colNames.add("��������");
		colNames.add("���ǻ�");
		colNames.add("����");
		colNames.add("�ֹ�����");
		colNames.add("�ֹ��ݾ�");
		colNames.add("�ֹ���");
		
		jt = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(lb1);
		jp.add(tfName);
		jp.add(btnS);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1000, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchbook();
			}
		});
	}
	protected void searchbook() {
		// TODO Auto-generated method stub
		rowData.clear();
		try {
			if(tfName.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "����� �Է��Ͽ��� Ȯ���ϼ���");
				return;
			}
			
			String name = tfName.getText();
			String sql =  "select cnum, cname, addr, tel, bname, price, publisher, author, oquantity, oamount, odate from book, customer, orders where customer.cnum = orders.csnum and book.bnum = orders.bknum and cname = '"+name+"'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1235", "bit1235");
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			boolean  flag = false;
			while(rs.next())
			{
				flag = true;
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));	
				v.add(rs.getString(3));	
				v.add(rs.getString(4));	
				v.add(rs.getString(5));	
				v.add(rs.getInt(6)+"");
				v.add(rs.getString(7));
				v.add(rs.getString(8));	
				v.add(rs.getInt(9)+"");
				v.add(rs.getInt(10)+"");
				v.add(rs.getString(11));
				rowData.add(v);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			jt.updateUI();
			
			if(flag==false)
				JOptionPane.showMessageDialog(this, "�˻��Ͻ� �̸� "+ name +"��(��) �����ϴ�");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
