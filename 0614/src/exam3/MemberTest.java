package exam3;

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
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

public class MemberTest extends JFrame implements ActionListener {

	JLabel lb1,lb2;
	JTextField tfName, tfAge;
	JButton btnAdd;
	
	MemberTest()
	{
		setLayout(new FlowLayout());
		setTitle("ȸ�����");
		lb1 = new JLabel("�̸�: ");
		lb2 = new JLabel("����: ");
		tfName = new JTextField(10);
		tfAge= new JTextField(10);
		btnAdd = new JButton("�߰�");
		
		add(lb1);
		add(tfName);
		add(lb2);
		add(tfAge);
		add(btnAdd);
		btnAdd.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//â�� �ݾ��� �� ���α׷��� ����
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name= tfName.getText();
		String ag = tfAge.getText();
		int age = Integer.parseInt(ag);
		try {
			String sql = "insert into mem values('"+name+"',"+age+")";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			
			int a=stmt.executeUpdate(sql);
			
			if (a==1)
				System.out.println("�߰�����");
			else
				System.out.println("�߰�����");
			
			stmt.close();
			conn.close();
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}
	}
		
		
	public static void main(String []args)
	{
		MemberTest mem = new MemberTest();
		mem.setVisible(true);
		mem.setSize(600, 200);
		
	}
	
}
