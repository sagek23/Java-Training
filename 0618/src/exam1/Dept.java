package exam1;

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

public class Dept extends JFrame{

	
	JLabel lb1;		
	
	JTextField tfName;
	
	JTable jt;
	
	JButton btnR;

	
	Vector<String>  colNames;
	Vector<Vector<String>> rowData;
	
	public Dept()
	{
		lb1 = new JLabel("이름");
	
		
		tfName = new JTextField(10);
		btnR = new JButton("검색");
		
		
	
		
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("사원번호");
		colNames.add("이름");
		colNames.add("부서번호");
		colNames.add("부서명");
		colNames.add("부서위치");
		colNames.add("급여");
		colNames.add("직급");
		
		jt = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		jp.add(lb1);
		jp.add(tfName);
		jp.add(btnR);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1000, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchInfo();
			}

	
		});
		
		
	}
	private void searchInfo() {
		// TODO Auto-generated method stub

			rowData.clear();
		try {
			if(tfName.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "제대로 입력했나 확인하시오");
				tfName.setText("");
				return;
			}
			
			String name = tfName.getText();
			String sql = "select eno, ename, dno, name, addr, salary, position from dept, employee where dept.no = employee.dno and ename = '"+name+"'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			boolean flag = false;
		
			while(rs.next())
			{
				flag = true;
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));
				v.add(rs.getInt(3)+"");
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getInt(6)+"");
				v.add(rs.getString(7));
				rowData.add(v);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			jt.updateUI();
			
			if(flag==false)
				JOptionPane.showMessageDialog(this, "사원 "+ name +"은(는) 없습니다");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
