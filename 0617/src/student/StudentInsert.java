package student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class StudentInsert extends StudentJFream implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String name = tfName.getText();
			int num = 0;
			int kor = Integer.parseInt(tfKor.getText());
			int eng = Integer.parseInt(tfEng.getText());
			int math = Integer.parseInt(tfMath.getText());
			int avg = (kor + eng + math) / 3;
			
//			rowData.clear();
			
			String r = "insert into member values(" +num + ",'" + name  + "'," + kor + "," + eng + "," + math + "," + avg + ")";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.114:1521:XE", "c##bit1234", "bit1234");
			Statement s = c.createStatement();
			int temp = s.executeUpdate(r);
			
			s.close();
			c.close();
//			StudentPrint si = new StudentPrint();
//			si.actionPerformed(e);
		} catch (Exception error) {
			//System.out.println(e);
			JOptionPane.showMessageDialog(this, "예외발생 : " + error.getMessage());
		}
	}
}