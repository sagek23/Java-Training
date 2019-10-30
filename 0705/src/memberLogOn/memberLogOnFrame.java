package memberLogOn;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bbs.BbsDao;
import bbs.BbsFrame;
import bbs.BbsVo;
import view.BoardFrame;

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
		JPanel jp_btn = new JPanel();
		
		setLayout(new BorderLayout());
		
		jp.add(lb1);
		jp.add(tfId);
		jp.add(lb2);
		jp.add(tfPwd);
		
		jp.setLayout(new GridLayout(2,2));
		jp_btn.add(logOn);
		jp_btn.setLayout(new FlowLayout());
		
		add(jp, BorderLayout.CENTER);
		add(jp_btn, BorderLayout.SOUTH);
		setVisible(true);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logOn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logOnVo vo = new logOnVo();
				logOnDao dao = new logOnDao();
				
				
				vo.setId(tfId.getText());
				vo.setPwd(tfPwd.getText());
				int re = dao.login(vo);
				System.out.println(re);
				if(re==-1)
				{
					JOptionPane.showMessageDialog(null, "아이디와 암호를 확인하세요");
					
					
				}
				else if(re ==1)
				{
					JOptionPane.showMessageDialog(null, "로그인 되었습니다");
					BbsFrame bbs = new BbsFrame();
					bbs.tfWriter.setText(tfId.getText());
					
					bbs.id = tfId.getText();
					bbs.setVisible(true);
					bbs.setSize(650, 700);
					bbs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			
				/*
				String msg="";
				switch(re)
				{
				case -1: msg = "아이디를 확인하세요";break;
				case 1: msg = "로그인 되었습니다";break;
				case 0: msg = "암호를 확인하세요";break;
				}
				
				JOptionPane.showMessageDialog(null, msg);
			*/
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new memberLogOnFrame();
		
	}
}
