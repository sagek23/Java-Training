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
		lb1= new JLabel("�̸�");
		lb2= new JLabel("����");
		tfName = new JTextField(10);
		tfAge = new JTextField(10);
		
		btnAdd = new JButton("���");
		btnRead = new JButton("���");
		
		
		colNames  = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colNames.add("�̸�");
		colNames.add("����");
		
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
		JPanel up = new JPanel(); //������ �����̳ʷ� �Ʒ��� �Ӽ��� ��� �ϳ��� �����.
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
		});//ActionListener �������̽��� ������ Ŭ������ ��ü
		btnRead.addActionListener(new ActionListener() { //()�ȿ� Ŭ���� ����
			
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
			
			while(rs.next()) //���� �ε����� �ִ� ���� ����
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1)); //�ε����� 1���� ī��Ʈ
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
		{  //���鸸 �Է��ϰų� �Է��� �����ʰ� ����� ������ ��
			
			//System.out.println("�Է°��� Ȯ���ϼ���");
			//System.exit(0); //���α׷� ����
			JOptionPane.showMessageDialog(this, "�̸��� ���̸� �Է��ϼ���.");
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
			System.out.println("�߰�����");
		else
			System.out.println("�߰�����");
		
		stmt.close();
		conn.close();
	
		printMem();
		
		}catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "���ܹ߻�"+e.getMessage());
		}
	}

}
