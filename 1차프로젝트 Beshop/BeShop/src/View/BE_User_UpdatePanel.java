package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import BE_UserDao.BE_UserDao;
import BE_UserVo.BE_UserVo;

public class BE_User_UpdatePanel extends JFrame {

    JTextField tf_uid;
    JTextField tf_upw;
    JTextField tf_upw2;
    JTextField tf_uname;
    JTextField tf_birth;
    JTextField tf_sex;
    JTextField tf_scnum;
    JTextField tf_addr1;
    JTextField tf_addr2;
    JTextField tf_email;
    JTextField tf_uphone;
    JTextField tf_pf1;
    JTextField tf_pf2;
    JTextField tf_pf3;
    JRadioButton rb_sex_f;
    JRadioButton rb_sex_m;
    JCheckBox ch_pf1;
    JCheckBox ch_pf2;
    JCheckBox ch_pf3;
    JCheckBox ch_pf4;
    JCheckBox ch_pf5;
    JCheckBox ch_pf6;
    JPanel jp_sex;
    JPanel jp_pf;
    JLabel jl_beuid;
    JLabel jl_uname;
    JLabel jl_scnum;
    public BE_User_UpdatePanel() {

        tf_uid = new JTextField(20);
        tf_upw = new JTextField(20);
        tf_upw2 = new JTextField(20);
        tf_uname = new JTextField(30);
        tf_birth = new JTextField(10);
        tf_scnum = new JTextField(10);
        tf_addr1 = new JTextField(100);
        tf_addr2 = new JTextField(100);
        tf_email = new JTextField(10);
        tf_uphone = new JTextField(10);
//        rb_sex_f = new JRadioButton("여성");
//        rb_sex_m = new JRadioButton("남성");
//        ch_pf1 = new JCheckBox("가전제품");
//        ch_pf2 = new JCheckBox("의류/잡화");
//        ch_pf3 = new JCheckBox("푸드");
//        ch_pf4 = new JCheckBox("건강");
//        ch_pf5 = new JCheckBox("게임/취미생활");
//        ch_pf6 = new JCheckBox("반려동물용품");
      //  jp_sex = new JPanel();
        jp_pf = new JPanel();
        jl_beuid = new JLabel();
        jl_uname = new JLabel();
        jl_scnum = new JLabel();
        
        JPanel input_p = new JPanel();
        input_p.setLayout(new GridLayout(10, 2));
        
        //성별 라디오 버튼 패널
//        jp_pf.setLayout(new FlowLayout());
//        ButtonGroup bg_sex = new ButtonGroup();
//        bg_sex.add(rb_sex_f);
//        bg_sex.add(rb_sex_m);
//        jp_sex.add(rb_sex_f);
//        jp_sex.add(rb_sex_m);
        
        //관심사 체크박스 패널
//        jp_pf.setLayout(new FlowLayout());
//        jp_pf.add(ch_pf1);
//        jp_pf.add(ch_pf2);
//        jp_pf.add(ch_pf3);
//        jp_pf.add(ch_pf4);
//        jp_pf.add(ch_pf5);
//        jp_pf.add(ch_pf6);
//        

        
        input_p.add(new JLabel("회원ID"));
        input_p.add(jl_beuid);
        input_p.add(new JLabel("이름"));
        input_p.add(jl_uname);
        input_p.add(new JLabel("비밀번호"));
        input_p.add(tf_upw);
        input_p.add(new JLabel("비밀번호 확인"));
        input_p.add(tf_upw2);
//      input_p.add(new JLabel("이름"));
//      input_p.add(tf_uname);
        input_p.add(new JLabel("생년월일"));
        input_p.add(tf_birth);
//        input_p.add(new JLabel("성별"));
//        input_p.add(jp_sex);
        input_p.add(new JLabel("주민등록번호(ex 123456-123456)"));
        input_p.add(jl_scnum);
        input_p.add(new JLabel("주소1"));
        input_p.add(tf_addr1);
        input_p.add(new JLabel("주소2"));
        input_p.add(tf_addr2);
        input_p.add(new JLabel("연락처"));
        input_p.add(tf_uphone);
        input_p.add(new JLabel("이메일"));
        input_p.add(tf_email);
//        input_p.add(new JLabel("관심사"));
//        input_p.add(jp_pf);
       
        JLabel user_title = new JLabel("회원정보수정");
        user_title.setFont(new Font("나눔고딕",Font.BOLD, 30));
        setLayout(new BorderLayout());
        
        add(user_title, BorderLayout.NORTH);
        add(input_p, BorderLayout.CENTER);
        JButton btnAdd =new JButton("수정");
        
        //회원정보 수정 버튼 클릭시 be_user update
        btnAdd.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	updateUser();
            	
            }
        });
         
        add(btnAdd, BorderLayout.SOUTH);
        setSize(600, 850);
        setVisible(true);
         
    }
     

    protected void updateUser() {
		// TODO Auto-generated method stub
    	if(tf_upw.getText().equals(tf_upw2.getText())) {
    		//vo에 새로운 정보를 담기
    		String beuid = jl_beuid.getText();
    		BE_UserVo vo = new BE_UserVo();
			vo.setUpw(tf_upw.getText());
			vo.setAddr1(tf_addr1.getText());
			vo.setAddr2(tf_addr2.getText());
			vo.setuPhone(tf_uphone.getText());
			
			BE_UserDao dao = new BE_UserDao();
			try {
				int re = dao.UpdateUser(vo, beuid);
				if(re > 0 ) {
					JOptionPane.showMessageDialog(this, "수정성공");
				}
				else {
					JOptionPane.showMessageDialog(this, "수정실패");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
    	}
	}


	public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BE_User_UpdatePanel();
    }
}