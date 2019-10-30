package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class TabIdPwd extends JFrame{
	//id찾기
		JRadioButton idtel;
		JRadioButton idemail;
		ButtonGroup  idg;
		JPanel idbtn_next;
		JPanel idtype;
		JButton idbtnn;
		//pwd찾기
		JRadioButton pwdtel;
		JRadioButton pwdemail;
		ButtonGroup  pwdg;
		JPanel pwdbtn_next;
		JPanel pwdtype;
		JButton pwdbtnn;
		//tab
		JTabbedPane tab;
		
		public TabIdPwd() {
			// TODO Auto-generated constructor stub
			//idŸ��
			idtype=new JPanel();
			
			idtel=new JRadioButton("회원정보에 등록한 휴대전화로 인증");
			idemail=new JRadioButton("본인확인 이메일로 인증");
			idg=new ButtonGroup();
			idg.add(idtel);
			idg.add(idemail);
			
			idbtnn=new JButton("다음");
			idbtnn.setPreferredSize(new Dimension(300, 30));
			//idbtn_next.add(idbtnn);
			
			idtype=new JPanel();
			idtype.setLayout(new GridLayout(3,1));
			idtype.add(idtel);
			idtype.add(idemail);
			idtype.add(idbtnn);
			
			idbtnn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Findid f=new Findid();
					try {
						
						if(idtel.isSelected())
						{
							
							f.Findidtel();
						}
						else if(idemail.isSelected())
						{
							
							f.Findidemail();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println(e2.getMessage());
					}
					
					
					
				}
			});
			
			
			
			
			//pwdŸ��
			pwdtype=new JPanel();
			
			pwdtel=new JRadioButton("회원정보에 등록한 휴대전화로 인증");
			pwdemail=new JRadioButton("본인확인 이메일로 인증");
			pwdg=new ButtonGroup();
			pwdg.add(pwdtel);
			pwdg.add(pwdemail);
			
			pwdbtnn=new JButton("다음");
			pwdbtnn.setPreferredSize(new Dimension(300, 30));
			//pwdbtn_next.add(pwdbtnn);
			
			pwdtype=new JPanel();
			pwdtype.setLayout(new GridLayout(3,1));
			pwdtype.add(pwdtel);
			pwdtype.add(pwdemail);
			pwdtype.add(pwdbtnn);
			
			pwdbtnn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					FindPwd p=new FindPwd();
					try {
						
						if(pwdtel.isSelected())
						{
							
							p.FindPwdtel();
						}
						else if(pwdemail.isSelected())
						{
							
							p.Findpwdemail();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println(e2.getMessage());
					}
					
				}
			});
			
			
			
			
			
			//tab
			tab=new JTabbedPane();
			tab.addTab("아이디 찾기",idtype);
			tab.addTab("비밀번호 찾기",pwdtype);
			add(tab);
			 setSize(600, 200);
		     setVisible(true);
		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		} 
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabIdPwd();
	}

}
