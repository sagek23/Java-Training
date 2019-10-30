package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

public class BE_UserPanel extends JFrame {

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
    JRadioButton rb_sex_f;
    JRadioButton rb_sex_m;
//    JCheckBox ch_pf1;
//    JCheckBox ch_pf2;
//    JCheckBox ch_pf3;
//    JCheckBox ch_pf4;
//    JCheckBox ch_pf5;
//    JCheckBox ch_pf6;
    JCheckBox ch_pf[] = new JCheckBox[6];
    JPanel jp_sex;
    JPanel jp_pf;
    String pf_list[] = {"가전제품", "의류/잡화", "푸드", "건강", "게임/취미생활","반려동물용품"};
     
    public BE_UserPanel() {
    	
        tf_uid = new JTextField(20);
        tf_upw = new JTextField(20);
        tf_upw2 = new JTextField(20);
        tf_uname = new JTextField(30);
        tf_birth = new JTextField(10);
        tf_scnum = new JTextField(10);
        tf_addr1 = new JTextField(100);
        tf_addr2 = new JTextField(100);
        tf_email = new JTextField(50);
        tf_uphone = new JTextField(10);
        rb_sex_f = new JRadioButton("여성");
        rb_sex_m = new JRadioButton("남성");
//        ch_pf1 = new JCheckBox("가전제품");
//        ch_pf2 = new JCheckBox("의류/잡화");
//        ch_pf3 = new JCheckBox("푸드");
//        ch_pf4 = new JCheckBox("건강");
//        ch_pf5 = new JCheckBox("게임/취미생활");
//        ch_pf6 = new JCheckBox("반려동물용품");
        for(int i =0; i<pf_list.length; i++) {
        	ch_pf[i] = new JCheckBox(pf_list[i]);
        }
        jp_sex = new JPanel();
        jp_pf = new JPanel();
        
       
        
        JPanel input_p = new JPanel();
        input_p.setLayout(new GridLayout(12, 2));
        
        //성별 라디오 버튼 패널
        jp_pf.setLayout(new FlowLayout());
        ButtonGroup bg_sex = new ButtonGroup();
        bg_sex.add(rb_sex_f);
        bg_sex.add(rb_sex_m);
        jp_sex.add(rb_sex_f);
        jp_sex.add(rb_sex_m);
        
        //관심사 체크박스 패널
        jp_pf.setLayout(new FlowLayout());
        for(int i = 0; i<pf_list.length; i++) {
        	jp_pf.add(ch_pf[i]);
        }
                
        input_p.add(new JLabel("회원ID"));
        input_p.add(tf_uid);
        input_p.add(new JLabel("비밀번호"));
        input_p.add(tf_upw);
        input_p.add(new JLabel("비밀번호 확인"));
        input_p.add(tf_upw2);
        input_p.add(new JLabel("이름"));
        input_p.add(tf_uname);
        input_p.add(new JLabel("생년월일(ex 19950624"));
        input_p.add(tf_birth);
        input_p.add(new JLabel("성별"));
        input_p.add(jp_sex);
        input_p.add(new JLabel("주민등록번호(ex 123456-123456)"));
        input_p.add(tf_scnum);
        input_p.add(new JLabel("주소1"));
        input_p.add(tf_addr1);
        input_p.add(new JLabel("주소2"));
        input_p.add(tf_addr2);
        input_p.add(new JLabel("연락처"));
        input_p.add(tf_uphone);
        input_p.add(new JLabel("이메일"));
        input_p.add(tf_email);
        input_p.add(new JLabel("관심사"));
        input_p.add(jp_pf);
       
        JLabel user_title = new JLabel("회원가입");
        user_title.setFont(new Font("나눔고딕",Font.BOLD, 30));
        setLayout(new BorderLayout());
        
        add(user_title, BorderLayout.NORTH);
        add(input_p, BorderLayout.CENTER);
        JButton btnAdd =new JButton("등록");
         
        btnAdd.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	String sex = "";

            	List<String> str = new ArrayList<String>() ;
	          	String year=tf_birth.getText().substring(0, 4);
	           	String month=tf_birth.getText().substring(4, 6);
	          	String day = tf_birth.getText().substring(6);

            	if(rb_sex_f.isSelected() == true) {
            		sex = "여성";
            	}
            	else if(rb_sex_m.isSelected() == true) {
            		sex = "남성";
            	}
            	if(ch_pf[0].isSelected() == true) {
            		str.add(pf_list[0]);
            	}
            	if(ch_pf[1].isSelected() == true) {
            		str.add(pf_list[1]);
            	}
            	if(ch_pf[2].isSelected() == true) {
            		str.add(pf_list[2]);
            	}
            	if(ch_pf[3].isSelected() == true) {
            		str.add(pf_list[3]);
            	}
            	if(ch_pf[4].isSelected() == true) {
            		str.add(pf_list[4]);
            	}
            	if(ch_pf[5].isSelected() == true) {
            		str.add(pf_list[5]);
            	}
            	String pf[] = new String[3];
            	String[] strData = str.toArray(new String[str.size()]);
            	for (int i=0; i<strData.length; i++)
                {
                   pf[i] = strData[i];
                }
            	int re;
            	if(tf_upw.getText().equals(tf_upw2.getText())) {
	            	BE_UserVo vo = new BE_UserVo();
	            	vo.setBeUid(tf_uid.getText());
	            	vo.setUpw(tf_upw.getText());
	            	vo.setUname(tf_uname.getText());
	            	vo.setSex(sex);
	            	vo.setBirth(transformDate(year, month, day));
	            	vo.setScNum(tf_scnum.getText());
	            	vo.setAddr1(tf_addr1.getText());
	            	vo.setAddr2(tf_addr2.getText());
	            	vo.setuPhone(tf_uphone.getText());
	            	vo.setEmail(tf_email.getText());
	            	vo.setPf1(pf[0]);
	            	vo.setPf2(pf[1]);
	            	vo.setPf3(pf[2]);
	            	
	            	BE_UserDao dao = new BE_UserDao();
	            	re = dao.InsertUser(vo);
	            	if(re > 0) {
	            		JOptionPane.showMessageDialog(null, "가입 완료!");
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "가입실패");
	            	}
            	}
            }
        });
         
        add(btnAdd, BorderLayout.SOUTH);
        setSize(600, 750);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    } 
    public Date transformDate(String year, String month, String day)
    {
        String date = year+"-"+month+"-"+day;
        Date d = Date.valueOf(date);
        
        return d;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BE_UserPanel();
    }
}