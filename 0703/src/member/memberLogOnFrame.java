package member;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class memberLogOnFrame extends JFrame {
	
	JLabel lb1;
	JLabel lb2;
	
	JTextField tfId;
	JTextField tfPwd;
	
	JButton logOn;
	
	public memberLogOnFrame()
	{
		lb1 = new JLabel("아이디");
		lb2 = new JLabel("패스워드");
		
		tfId = new JTextField(10);
		tfPwd = new JTextField(10);
		
		logOn = new JButton("로그인");
		
		JPanel jp = new JPanel();
		
		setLayout(new BorderLayout());
		
		jp.add(lb1);
		jp.add(tfId);
		jp.add(lb2);
		jp.add(tfPwd);
		
		jp.setLayout(new GridLayout(2,2));
		add(jp, BorderLayout.CENTER);
		
		logOn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memberVo vo = new memberVo();
				memberDao dao = new memberDao();
				
				vo.setId(tfId.getText());
				vo.setPwd(tfPwd.getText());
				
				
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new memberLogOnFrame();
		
	}
}
