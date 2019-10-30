package exam4;

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

public class MemberFrame extends JFrame implements ActionListener {

	JTable jt;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	JButton btnRead;
	
	MemberFrame()
	{
		btnRead = new JButton("읽어오기");
		rowData = new Vector<Vector<String>>();
		colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("나이");
		
		jt = new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		add(jsp, BorderLayout.CENTER);
		add(btnRead,BorderLayout.SOUTH);
		btnRead.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql  = "select * from mem";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.97:1521:XE", "c##bit1234", "bit1234");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				v.add(rs.getInt(2)+"");
				rowData.add(v);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			jt.updateUI(); //테이블을 보관하고 있는 벡터의 내용이 바뀌어서 
						   //업데이트를 해줘야 내용이 보인다.
			
		}catch(Exception ex)
		{System.out.println(ex.getMessage());}
	}

}
