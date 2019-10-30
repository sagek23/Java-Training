package hw1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentFrame extends JFrame implements ActionListener {

	JTable jt;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	JButton btnR;
	
	StudentFrame()
	{
		btnR = new JButton();
		rowData = new Vector<Vector<String>>();
		colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("번호");

		jt = new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		add(jsp, BorderLayout.CENTER);
		add(btnR, BorderLayout.SOUTH);
		btnR.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		
		try {
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
