package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DB.ConnectionProvider;

public class BE_PwdCheck extends JPanel implements ActionListener {
 private String password;
 private String password_check;
 
 private JTextField tf;
 private JPasswordField pf;
 private JButton check;
 JLabel lb_check = new JLabel();
 private boolean isCheck = false;
 String beuid="";
 String uname="";
 String birth = "";
 String sex = "";
 String scnum="";
 String addr1="";
 String addr2 = "";
 String uphone = "";
 String email="";
 
	 public BE_PwdCheck() {
			
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
		  jt_pwdcheck.add("회원정보수정", pwd_check);
		  
		  setLayout(new BorderLayout());
		  add(jt_pwdcheck, BorderLayout.CENTER);
		
		  //setTitle("회원정보수정");
		  setSize(700,500);
		  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  setVisible(true);
		 }
		
		 public String pwdCheck() {
			
			 String sql = "select upw from be_user where beuid='godkkoo'";
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
			 String sql = "select beuid,birth,uname,scnum,addr1,addr2,uphone,email from be_user where beuid='godkkoo'";
			 try {
				Connection conn = ConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					beuid = rs.getString(1);
					//sex = rs.getString(1);
					birth = rs.getDate(2)+"";
					uname = rs.getString(3);
					scnum = rs.getString(4);
					addr1 = rs.getString(5);
					addr2 = rs.getString(6);
					uphone = rs.getString(7);
					email = rs.getString(8);	
				}
				ConnectionProvider.close(conn, stmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
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
				    System.out.println(isCheck);
				     BE_User_UpdatePanel user_update = new BE_User_UpdatePanel();
				     user_update.jl_beuid.setText(beuid);
				     user_update.jl_uname.setText(uname);
				     user_update.tf_upw.setText(password);
				     user_update.tf_addr1.setText(addr1);
				     user_update.tf_addr2.setText(addr2);
				     user_update.tf_birth.setText(birth);
				     user_update.jl_scnum.setText(scnum);
				     user_update.tf_uphone.setText(uphone);
				     user_update.tf_email.setText(email);
				     user_update.setVisible(true);
			     
			    } else {
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
		new BE_PwdCheck(); 
	 }
}
