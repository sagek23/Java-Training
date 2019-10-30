package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BE_UserDao.BE_UserDao;

public class FindPwd extends JFrame{
	
	JTextField tf_id;
	JTextField tf_name;
	JTextField tf_tel;
	JTextField tf_email;
	String Uid="";
	String Uname="";
	String Utel="";
	String Upwd="";
	String Uemail="";
	
	public int FindPwdtel() 
	{	JLabel title ;
		JPanel tf=new JPanel();
		JLabel lb_id=new JLabel("아이디");
		tf_id=new JTextField(15);
		
		JLabel lb_name=new JLabel("이름");
		tf_name=new JTextField(15);
		
		JLabel lb_tel=new JLabel("전화번호");
		tf_tel=new JTextField(15);
		
		JPanel total=new JPanel();
		total.setLayout(new FlowLayout());
		JButton b=new JButton("다음");
		total.add(b);
		                                
		tf.add(lb_id);
		tf.add(tf_id);
		tf.add(lb_name);
		tf.add(tf_name);
		tf.add(lb_tel);
		tf.add(tf_tel);
		
		tf.add(total);

		
		tf.setLayout(new GridLayout(5,2));
		add(tf);
		
		
		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//��й�ȣ��Ÿ���� ������
				
				String BUid=tf_id.getText();
				String uname=tf_name.getText();
				String uPhone=tf_tel.getText();
				BE_UserDao dao=new BE_UserDao();
				try {
					String upw=dao.PwSearchPhone(uname, uPhone, BUid);
					if(true)
					{
						JOptionPane.showMessageDialog(null, BUid+"님의 비밀번호는"+upw+"입니다");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
			}
					
		});
		return 0;
	}
	
	
	public int Findpwdemail()
	{
		JLabel title ;
		JPanel tf=new JPanel();
		JLabel lb_id=new JLabel("아이디");
		tf_id=new JTextField(15);
		
		JLabel lb_name=new JLabel("이름");
		tf_name=new JTextField(15);
		
		JLabel lb_email=new JLabel("이메일");
		tf_email=new JTextField(15);
		
		JPanel total=new JPanel();
		total.setLayout(new FlowLayout());
		JButton b=new JButton("다음");
		total.add(b);
		                                
		tf.add(lb_id);
		tf.add(tf_id);
		tf.add(lb_name);
		tf.add(tf_name);
		tf.add(lb_email);
		tf.add(tf_email);
		
		tf.add(total);
		
		tf.setLayout(new GridLayout(4,2));
		add(tf);
		
		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//��й�ȣ��Ÿ���� ������
				
				String BUid=tf_id.getText();
				String uname=tf_name.getText();
				String email=tf_email.getText();
				BE_UserDao dao=new BE_UserDao();
				try {
					String pwd=dao.PwSearchEmail(uname, email, BUid);
				
					if(true)
					{
						JOptionPane.showMessageDialog(null, Uid+"님의 비밀번호는"+Upwd+"입니다");
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
		
			}
		});
		return 0;
		
}

	public static void main(String[] args) {
		new FindPwd();
		
	}
}
	

		

