package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BE_UserDao.BE_UserDao;

public class Findid extends JFrame{
	protected static final Object Uid = null;
	protected static final Object Utel = null;
	protected static final Object Uname = null;
	protected static final Object Uemail = null;
	JTextField tf_id;
	JTextField tf_name;
	JTextField tf_tel;
	JTextField tf_email;
	
	
	public int Findidtel() 
	{	
		JLabel title ;
		JPanel tf=new JPanel();
		
		
		JLabel lb_name=new JLabel("이름");
		tf_name=new JTextField(15);
		
		JLabel lb_tel=new JLabel("전화번호");
		tf_tel=new JTextField(15);
		
		
		
		JPanel total=new JPanel();
		total.setLayout(new FlowLayout());
		JButton b=new JButton("다음");
		total.add(b);
		                                
		
		tf.add(lb_name);
		tf.add(tf_name);
		tf.add(lb_tel);
		tf.add(tf_tel);
		
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
				
				
				String uname=tf_name.getText();
				String uPhone=tf_tel.getText();
				BE_UserDao dao=new BE_UserDao();
				
				try {
					String bUid = dao.IdSearchPhone(uname, uPhone);
					if(true)
					{
						JOptionPane.showMessageDialog(null, uname+"님의 아이디는"+bUid+"입니다");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
		
			}
					
		});
		return 0;
	}
	
	
	public int Findidemail()
	{
		JLabel title ;
		JPanel tf=new JPanel();
	
		
		JLabel lb_name=new JLabel("이름");
		tf_name=new JTextField(15);
		
		JLabel lb_email=new JLabel("이메일");
		tf_email=new JTextField(15);
		
		JPanel total=new JPanel();
		total.setLayout(new FlowLayout());
		JButton b=new JButton("다음");
		total.add(b);
		                                
	
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
				
				String id=tf_id.getText();
				String uname=tf_name.getText();
				String email=tf_email.getText();
				BE_UserDao dao=new BE_UserDao();
				try {
					String BUid=dao.IdSearchEmail(uname, email);
					if(true)
					{
						JOptionPane.showMessageDialog(null, uname+"님의 아이디는"+BUid+"입니다");
					}
				} catch (Exception e)
				{
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
		
			}
		});
		return 0;
		
}

	public static void main(String[] args) {
		new Findid();
		
	}
}
	

		

