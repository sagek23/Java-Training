package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
	
	public class LoginFrame extends JFrame{
		
	 
	    JTextField jtf_id;  
	    JTextField jtf_pwd;
		BE_NorthMainPanel main;
		JButton btn_login;
		JButton btn_id;
		JButton btn_join;
	   
		public LoginFrame()
	    {	
	    	main = this.main;
	    	//north = this.north;
	        jtf_id = new JTextField(15);
	        jtf_pwd = new JTextField(15);       
	         
	        JPanel id=new JPanel();
	        JPanel pwd=new JPanel();
	        id.add(new JLabel(  "아이디 "));
	        id.add(jtf_id);
	        pwd.add(new JLabel(  "비밀번호"));
	        pwd.add(jtf_pwd);
	 
	        JPanel loginbtn=new JPanel();
	        btn_login = new JButton("로그인");
	        loginbtn.add(btn_login);
	        btn_login.setPreferredSize(new Dimension(275,30));
	        
	       btn_id = new JButton("아이디 찾기/비밀번호 찾기");
	       btn_join = new JButton("회원가입");
	        
	        JLabel showpwd=new JLabel();
	        
	        JPanel btn=new JPanel(); 
	        btn.setLayout(new FlowLayout());
	        
	        
	        btn.add(btn_id);
	       // btn.add(btn_pwd);
	        btn.add(btn_join);
	       
	        
	        JPanel login=new JPanel();
	        
	        login.add(id);
	        login.add(pwd);
	        login.add(loginbtn);
	        login.add(btn);
	        
	        login.setLayout(new GridLayout(5,2));
	        add(login);
	        setSize(600,300);
	      
	        
//	        btn_id.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					new TabIdPwd();
//				}
//			});
//	        btn_login.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					String beid = jtf_id.getText();
//					String bepw = jtf_pwd.getText();
//					
//					BE_UserDao dao = new BE_UserDao();
//					System.out.println(beid+",,"+bepw);
//					int re=dao.UserLogin(beid, bepw);
//					
//					System.out.println("re="+re);
//					if(re==1)
//					{
//						BE_UserDao udao = new BE_UserDao();
//						BE_PointDao pdao = new BE_PointDao();
//						BE_UserVo vo = udao.user_info(beid);
//						System.out.println(vo.getUname());
//						BE_PointVo pvo = new BE_PointVo();
//						pvo = pdao.PointBalance(beid);
//					
//						main.userB.removeAll();
//						
//						System.out.println(vo.getUname());
//						main.userB.setText(vo.getUname()+"님");
//						main.pointB.removeAll();
//						main.pointB.setText(pvo.getPointBalance()+"점");
//						
//						
////						BE_MainFrame main = new BE_MainFrame();
////						main.remove(main.benm);
////						main.benm = panel;
////						main.add(main.benm, BorderLayout.NORTH);
////						main.setVisible(true);
//	
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null,"하나이상의 정보를 입력해주세요");
//					}
//				}
//			});
//	        
//	        btn_join.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					new BE_UserInsertFrame();
//				}
//			});
	                
}

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        new LoginFrame();
	    }
	 
	}


