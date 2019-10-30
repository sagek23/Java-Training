package LogOn;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.ConnectionProvider;
import bbs.BbsFrame;
import bbs.BbsVo;

public class LogOnFrame extends JFrame {

	JLabel lb1;
	JLabel lb2;
	
	JTextField tfId;
	JTextField tfPwd;
	
	JButton btn;
	
	public LogOnFrame()
	{
		lb1 = new JLabel("아이디");
		lb2 = new JLabel("패스워드");
		
		tfId = new JTextField(10);
		tfPwd = new JTextField(10);
		btn = new JButton("로그인");
		
		JPanel jp_in = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_in.add(lb1);
		jp_in.add(tfId);
		jp_in.add(lb2);
		jp_in.add(tfPwd);
		
		jp_btn.add(btn);
		
		jp_in.setLayout(new GridLayout(2,2));
		
		jp_btn.setLayout(new FlowLayout());
		
		add(jp_in, BorderLayout.CENTER);
		add(jp_btn, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(300, 200);
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LogOnVO vo = new LogOnVO();
				LogOnDao dao = new LogOnDao();
				vo.setId(tfId.getText());
				vo.setPwd(tfPwd.getText());
				int re = dao.isMember(vo);
				if(re == 1)
				{	
					JOptionPane.showMessageDialog(null, "로그인 성공");
					BbsFrame bbs= new BbsFrame();
					bbs.tfWriter.setText(vo.getId());
					bbs.id = tfId.getText();
					
					bbs.setSize(600, 700);
					bbs.setVisible(true);
					bbs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				}
				else
					JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LogOnFrame();
	}

}
