package student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class StudentPrint extends StudentJFream implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		rowData.clear();
		
		try {
			String r = "select * from student";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.114:1521:XE", "c##bit1234", "bit1234");
			Statement s = c.createStatement();
			ResultSet  temp = s.executeQuery(r);
			
			while(temp.next()) {
                Vector<String> v= new Vector<String>();
                v.add(temp.getString(1));
                v.add(temp.getInt(2)+"");
                rowData.add(v);
            }
			
			temp.close();
			s.close();
			c.close();
			table.updateUI();
		} catch (Exception error) {
			System.out.println(error);
		}
	}
}