package hw1_1;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentFrame extends JFrame implements ActionListener {

	JTable jt;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	JButton btnR;
	JLabel lb1;
	JLabel lb2;
	JTextField tfName, tfNo;
	JButton btn;
	
	
	StudentFrame()
	{
		btnR = new JButton("�о����");
		rowData = new Vector<Vector<String>>();
		colNames = new Vector<String>();
		colNames.add("�̸�");
		colNames.add("��ȣ");

		jt = new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		add(jsp, BorderLayout.CENTER);
		//add(btnR, BorderLayout.SOUTH);
		btnR.addActionListener(this);
		
		
		setLayout(new FlowLayout());
		setTitle("�л� ���");
		lb1 = new JLabel("�̸�");
		lb2 = new JLabel("��ȣ");
		tfName = new JTextField(10);
		tfNo = new JTextField(10);
		btn = new JButton("���");
		
		
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
		String smd = e.getActionCommand(); //��ư�� �ִ� ��Ʈ���� ����
		
		try {
			String sqls = "insert into student values ('"+name+"',"+num+")";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			int a = stmt.executeUpdate(sqls);
			if (a==1)
				System.out.println("�߰� ����");
			else
				System.out.println("�߰� ����");
			
			//stmt.close();
			//conn.close();
			
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());		
		}
		
		
		try {
			String sql = "select * from student";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				v.add(rs.getString(2)+"");
				rowData.add(v);
			}
			rs.close();
			stmt.close();
			conn.close();
			
			jt.updateUI();
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}


	}

}
