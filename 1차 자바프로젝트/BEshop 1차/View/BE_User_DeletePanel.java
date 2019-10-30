package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import BE_UserDao.BE_UserDao;
import DB.ConnectionProvider;

public class BE_User_DeletePanel extends JPanel implements ActionListener {
 private String password;
 private String password_check;
 
 private JTextField tf;
 private JPasswordField pf;
 private JButton check;
 JLabel lb_check = new JLabel();
 static String beuid="";
 private boolean isCheck = false;

 
	 public BE_User_DeletePanel() {
		 
		  JPanel idPanel = new JPanel();
		  JPanel passPanel = new JPanel();
		  pf = new JPasswordField(10);
		  lb_check.setForeground(Color.RED);
		  JPanel[] jpanel = new JPanel[4];
		  
		  JLabel passLabel = new JLabel("PASSWORD : ");
		  check = new JButton("확인");
		  check.addActionListener(this);
		  
		  passPanel.add(passLabel);
		  passPanel.add(pf);
		
//		  this.add(passPanel);
//		  this.add(check);
//		  this.add(lb_check);
		  
		  
		  JPanel pwd_check = new JPanel();
		  pwd_check.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		  pwd_check.add(passPanel);
		  pwd_check.add(check);
		  pwd_check.add(lb_check);
		  
		  JTabbedPane jt_pwdcheck = new JTabbedPane();
		  jt_pwdcheck.add("회원탈퇴", pwd_check);
		  
		  setLayout(new BorderLayout());

		  add(jt_pwdcheck, BorderLayout.CENTER);
		  setSize(750,500);
		  setVisible(true);
		 }
		
		 public String pwdCheck() {
			
			 String sql = "select upw from be_user where beuid='"+beuid+"'";
			 try {
				Connection conn = ConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {	
					password = rs.getString(1);
				}
				ConnectionProvider.close(conn, stmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			 return password;
		 }
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 String password = "";
			 BE_UserDao dao = new BE_UserDao();
			 
			 password = pwdCheck();
			 
		  if (e.getSource() == check) {
		   try {
		   
			   if (password.equals(pf.getText())) {
			     isCheck = true;
			    }
			    else {
			     isCheck = false;
			    }
			    System.out.println(isCheck);
			    if (isCheck) {
				    
				   
				    	int result = JOptionPane.showConfirmDialog(this, "탈퇴하시겠습니까?");
				    	if(result == JOptionPane.YES_OPTION) {
				    			int re = dao.DeleteUser(beuid);
				    			 if(re>0) {
				    				 JOptionPane.showMessageDialog(this, "탈퇴완료!");
				    			 }
				    			
				    			 else {
				    				 JOptionPane.showMessageDialog(this, "탈퇴실패");
				    			 }
				    	}	
				    }
			     else {
			     lb_check.setText("password를 확인해주세요.");
			    }
			  }
		   		catch (Exception e1) {
			    System.out.println(e1.getMessage());
			 }
		  }	
		 }
	
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
		new BE_User_DeletePanel(); 
	 }
}
