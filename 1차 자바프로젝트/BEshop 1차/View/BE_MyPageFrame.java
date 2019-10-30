package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import BE_ShoppingDao.BE_ReViewDao;
import BE_UserDao.BE_PointDao;

public class BE_MyPageFrame extends JFrame {
	JLabel jl_user_name = new JLabel();
	JLabel jl_user_mail = new JLabel();
	JLabel jl_user_beuid = new JLabel();
	
	public BE_MyPageFrame() {
		
		//마이페이지 오른쪽(회원등급, 기능별 패널)
		JPanel jp_mypage_left = new JPanel();
		JPanel jp_mypage_right = new JPanel();
		jp_mypage_left.setLayout(new BorderLayout());
		
		//외부 패널을 가져올 패널
		JPanel jp_mypage = new JPanel();
		//jp_mypage.setSize(700,500);
		
		//마이페이지를 왼쪽/오른쪽으로 구분
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(jp_mypage_left);
		
		//왼쪽 상단 유저이름과 email 출력
		JPanel jp_user_info = new JPanel();
		jp_mypage_left.add(jp_user_info, BorderLayout.NORTH);
		jp_user_info.setLayout(new BorderLayout());
		//유저 이름
		JPanel jp_user_name = new JPanel();
		jp_user_name.setBackground(Color.WHITE);
		jp_user_info.add(jp_user_name, BorderLayout.NORTH);
		//jl_user_name = new JLabel();
		System.out.println(jl_user_name.getText());
		jl_user_name.setFont(new Font("나눔고딕", Font.BOLD, 30));
		jp_user_name.add(jl_user_name);

		//유저이메일
		JPanel jp_user_email = new JPanel();
		jp_user_email.setBackground(Color.WHITE);
		jp_user_info.add(jp_user_email, BorderLayout.SOUTH);
		//jl_user_mail = new JLabel();
		System.out.println(jl_user_mail.getText());
		jl_user_mail.setBackground(Color.WHITE);
		jl_user_mail.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		jp_user_email.add(jl_user_mail);
		
		//마이페이지버튼
		JPanel jp_mypage_btn = new JPanel();
		jp_mypage_left.add(jp_mypage_btn , BorderLayout.CENTER);
		jp_mypage_btn.setLayout(new GridLayout(7,1));
		JButton btn_order = new JButton("주문,배송 조회");
		jp_mypage_btn.add(btn_order);	
//		JButton btn_cancle = new JButton("취소,교환 조회");
//		jp_mypage_btn.add(btn_cancle);	
		JButton btn_mypoint = new JButton("마이 포인트");
		jp_mypage_btn.add(btn_mypoint);
		JButton btn_myReview = new JButton("마이리뷰");
		jp_mypage_btn.add(btn_myReview);	
//		JButton btn_myQna = new JButton("문의내역");
//		jp_mypage_btn.add(btn_myQna);	
		JButton btn_userUpdate = new JButton("회원정보수정");
		jp_mypage_btn.add(btn_userUpdate);	
		JButton btn_userDelete = new JButton("회원 탈퇴");
		jp_mypage_btn.add(btn_userDelete);
		
	
		btn_order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp_mypage.removeAll();
				jp_mypage.updateUI();
				BE_OrderPanel order = new BE_OrderPanel();
				order.beuid = jl_user_beuid.getText();
				jp_mypage.add(order);
				
			}
		});
		
	
		btn_mypoint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp_mypage.removeAll();
				jp_mypage.updateUI();
				BE_PointPanel point = new BE_PointPanel();

				point.beuid = jl_user_beuid.getText();
				System.out.println(point.beuid); //천석훈
				point.dao = new BE_PointDao();
				point.vo = point.dao.PointBalance(jl_user_beuid.getText());
				point.jl_point.removeAll();
				point.jl_point.setText(point.vo.getPointBalance()+"원");
				jp_mypage.add(point);
				
			}
		});

		btn_myReview.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp_mypage.removeAll();
				jp_mypage.updateUI();
				BE_ReviewPanel review = new BE_ReviewPanel();
				review.beuid = jl_user_beuid.getText();
				review.dao = new BE_ReViewDao();
				review.Review_list = review.dao.ReViewlistAll(jl_user_beuid.getText());
				
				review.btn_myreview.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					review.myreviewList();
				}
				});
				jp_mypage.add(review);
			}
		});
		btn_userUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp_mypage.removeAll();
				jp_mypage.updateUI();
				BE_PwdCheck pwdck = new BE_PwdCheck();
				pwdck.beuid = jl_user_beuid.getText();
				jp_mypage.add(pwdck);
			}
		});
		btn_userDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp_mypage.removeAll();
				jp_mypage.updateUI();
				BE_User_DeletePanel delete = new BE_User_DeletePanel();
				delete.beuid = jl_user_beuid.getText();
				jp_mypage.add(delete);
			}
		});
		splitPane.setRightComponent(jp_mypage_right);
		jp_mypage_right.setLayout(new BorderLayout());
		
		//오른쪽 상단 회원등급
		JPanel jp_user_info2 = new JPanel();
		JPanel user_grade = new JPanel();
		user_grade.setLayout(new BorderLayout());
		user_grade.add(new JLabel("회원등급 > "), BorderLayout.WEST);
		user_grade.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JPanel grade_btn = new JPanel();
		JLabel grade = new JLabel("Green");
		grade.setFont(new Font("나눔스퀘어", Font.BOLD, 30));
		JButton btn_halin = new JButton("할인혜택보기");
		grade_btn.setLayout(new BorderLayout());
		grade_btn.add(grade, BorderLayout.WEST);
		grade_btn.add(btn_halin, BorderLayout.EAST);
		jp_user_info2.setLayout(new BorderLayout());
		jp_user_info2.add(user_grade, BorderLayout.NORTH);
		jp_user_info2.add(grade_btn, BorderLayout.SOUTH);
		jp_user_info2.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
		
		//할인혜택보기 이벤트
		btn_halin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BE_GradeImg();
			}
		});
		jp_mypage_right.add(jp_user_info2, BorderLayout.NORTH);
		jp_mypage_right.add(jp_mypage, BorderLayout.CENTER);
		jp_mypage.setLayout(new BorderLayout(0, 0));
		
		
		getContentPane().add(splitPane);
		setSize(1200,700);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new BE_MyPageFrame();
	}
}