package member;

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

public class MemberFrame extends JFrame {

	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	
	JTextField tfId;
	JTextField tfPwd;
	JTextField tfName;
	
	JButton btn;
	
	public MemberFrame()
	{
		lb1 = new JLabel("아이디");
		lb2 = new JLabel("패스워드");
		lb3 = new JLabel("이름");
		
		tfId = new JTextField(10);
		tfPwd = new JTextField(10);
		tfName = new JTextField(10);
		
		btn = new JButton("등록");
		
		setLayout(new BorderLayout());
		
		JPanel jp = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_btn.add(btn);
		
		jp_btn.setLayout(new FlowLayout());
		jp.add(lb1);
		jp.add(tfId);
		jp.add(lb2);
		jp.add(tfPwd);
		jp.add(lb3);
		jp.add(tfName);
		
		jp.setLayout(new GridLayout(3,2));
		
		add(jp, BorderLayout.CENTER);
		add(jp_btn, BorderLayout.SOUTH);
		
		setTitle("회원가입");
		setVisible(true);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				MemberDao dao = new MemberDao();
				MemberVo vo = new MemberVo();
				vo.setId(tfId.getText());
				vo.setPwd(tfPwd.getText());
				vo.setName(tfName.getText());
				int re = dao.joinMember(vo);
				if(re >0)
				{
					JOptionPane.showMessageDialog(null, "등록성공");
				}
					
				else
					JOptionPane.showMessageDialog(null, "등록실패");
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemberFrame();
	}

}
