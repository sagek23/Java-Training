package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import BE_UserDao.BE_PointDao;
import BE_UserDao.BE_UserDao;
import BE_UserVo.BE_PointVo;
import BE_UserVo.BE_UserVo;

public class BE_NorthMainPanel extends JPanel{
	
	ImageIcon img;
	JTextField jtf;
	JPanel jpimg,searchP,userInfoP;
	
	JButton btnMain,btnS,pointB, userB,insP;
	JButton logB;
	JButton myPageB;
	JButton logoutB;
	LoginFrame login;
	String beid;
	
	public BE_NorthMainPanel(){
	
		
		login = new LoginFrame();
		pointB = new JButton();
		userB = new JButton("로그인을 해주세요");
		logB = new JButton("로그인");
		logoutB = new JButton("로그아웃");
		myPageB = new JButton("마이페이지");
		insP = new JButton("상품등록");
				
		img = new ImageIcon("image/beShop.png");
		jtf = new JTextField(35);
		btnS = new JButton("Search");
		btnMain = new JButton(img);
		jpimg = new JPanel();
		searchP = new JPanel();
		userInfoP = new JPanel();
		
		userInfoP.setLayout(new FlowLayout());
		//userInfoP.add(pointB);
		userInfoP.add(userB);
		userInfoP.add(logB);
		
		searchP.setLayout(new FlowLayout());
		searchP.add(jtf);
		searchP.add(btnS);
		setLayout(new BorderLayout());
		
		jpimg.add(btnMain);
		add(jpimg,BorderLayout.WEST);
		add(searchP,BorderLayout.CENTER);
		add(userInfoP,BorderLayout.EAST);
		//포인트 버튼 누를시 이벤트처리
		pointB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//username 버튼 누를시 이벤트 처리
		userB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		// 로그인 기능, 로그아웃 기능
		logB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					login.setVisible(true);
		
			}
		
		});
		insP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BE_Productinsert();
				
			}
		});
		
		  login.btn_join.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new BE_UserInsertFrame();
				}
			});
	              
		 login.btn_id.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new TabIdPwd();
				}
			});
		  login.btn_login.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					beid  = login.jtf_id.getText();
					String bepw = login.jtf_pwd.getText();
					
					BE_UserDao dao = new BE_UserDao();
					System.out.println(beid+",,"+bepw);
					int re=dao.UserLogin(beid, bepw);
					
					System.out.println("re="+re);
					if(re==1)
					{
						BE_UserDao udao = new BE_UserDao();
						BE_PointDao pdao = new BE_PointDao();
						BE_UserVo vo = udao.user_info(beid);
						BE_PointVo pvo = new BE_PointVo();
						pvo = pdao.PointBalance(beid);
					
						userB.removeAll();
						
						System.out.println(vo.getUname());
						logB.setVisible(false);
						userB.setText(vo.getUname()+"님");
						pointB.removeAll();
						pointB.setText(pvo.getPointBalance()+"점");
						userInfoP.add(pointB);
						userInfoP.add(myPageB);
						userInfoP.add(logoutB);
						userInfoP.add(insP);
						
//						BE_MainFrame main = new BE_MainFrame();
//						main.remove(main.benm);
//						main.benm = panel;
//						main.add(main.benm, BorderLayout.NORTH);
//						main.setVisible(true);
						login.setVisible(false);
						myPageB.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								BE_MyPageFrame mypage = new BE_MyPageFrame();
								mypage.jl_user_name.removeAll();
								mypage.jl_user_name.setText(vo.getUname()+"님");
								mypage.jl_user_mail.removeAll();
								mypage.jl_user_mail.setText(vo.getEmail());
								mypage.jl_user_beuid.setText(beid);
							}
						});
					}
					else
					{
						JOptionPane.showMessageDialog(null,"하나이상의 정보를 입력해주세요");
					}
				}
			});
	}
	
	
}
