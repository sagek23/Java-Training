package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import BE_UserDao.BE_PointDao;

public class BE_PointChargeFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JTextField jtf_charge = new JTextField(10);
	JButton btn_charge_card;
	JButton btn_charge_account;
	JButton btn_charge;
	JLabel jl_card_num;
	JLabel jl_account_num;
	BE_PointPanel main;
	String beuid;
	public BE_PointChargeFrame() {
		main = this.main;
		JPanel jp_cardCharge = new JPanel();
		JPanel jp_accountCharge = new JPanel();
		
		JPanel jp_pointcharge_up = new JPanel();
		getContentPane().add(jp_pointcharge_up, BorderLayout.NORTH);
		jp_pointcharge_up.setLayout(new BorderLayout());
		
		JPanel jp_charge_btn = new JPanel();
		jp_charge_btn.setBorder(new EmptyBorder(10, 0, 10, 0));
		jp_pointcharge_up.add(jp_charge_btn, BorderLayout.SOUTH);
		jp_charge_btn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_charge_card = new JButton("카드");
		jp_charge_btn.add(btn_charge_card);
		
		btn_charge_account = new JButton("계좌이체");
		jp_charge_btn.add(btn_charge_account);
		
		JPanel jp_point_label = new JPanel();
		jp_pointcharge_up.add(jp_point_label, BorderLayout.NORTH);
		jp_point_label.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("포인트 충전");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("나눔스퀘어", Font.PLAIN, 27));
		jp_point_label.add(label,BorderLayout.NORTH);
		
		JLabel jl_chargeMethod = new JLabel("충전방식을 선택하세요");
		jl_chargeMethod.setForeground(Color.BLACK);
		jl_chargeMethod.setFont(new Font("나눔스퀘어", Font.PLAIN, 16));
		jl_chargeMethod.setHorizontalAlignment(SwingConstants.CENTER);
		jp_point_label.add(jl_chargeMethod);
		
		JPanel jp_chargeMethod = new JPanel();
		jp_chargeMethod.setLayout(new BorderLayout());
		getContentPane().add(jp_chargeMethod, BorderLayout.CENTER);
			
		jp_chargeMethod.add(jp_cardCharge, BorderLayout.NORTH);
		//카드로 충전
		jl_card_num = new JLabel("카드번호 : ");
		jp_cardCharge.add(jl_card_num);
		
		textField = new JTextField(4);
		jp_cardCharge.add(textField);

		textField_1 = new JTextField(4);
		jp_cardCharge.add(textField_1);
		
		textField_2 = new JTextField(4);
		jp_cardCharge.add(textField_2);
		
		textField_3 = new JTextField(4);
		jp_cardCharge.add(textField_3);
		
		//계좌로 충전
		jl_account_num = new JLabel("계좌번호 : ");
		jp_accountCharge.add(jl_account_num);
		
		textField = new JTextField(4);
		jp_accountCharge.add(textField);

		textField_1 = new JTextField(4);
		jp_accountCharge.add(textField_1);
		
		textField_2 = new JTextField(4);
		jp_accountCharge.add(textField_2);
		
		textField_3 = new JTextField(4);
		jp_accountCharge.add(textField_3);
		
		JPanel jp_charge_Bal = new JPanel();
		jp_charge_Bal.setBorder(new EmptyBorder(10, 0, 0, 0));
		jp_chargeMethod.add(jp_charge_Bal, BorderLayout.CENTER);
		
		JLabel jl_charge_bal = new JLabel("충전금액 : ");
		jp_charge_Bal.add(jl_charge_bal);
		
		jp_charge_Bal.add(jtf_charge);
		
		btn_charge = new JButton("충전하기");
		jp_chargeMethod.add(btn_charge, BorderLayout.SOUTH);
		
		btn_charge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BE_PointDao dao = new BE_PointDao();
				int re = dao.UpdatePoint(beuid, Integer.parseInt(jtf_charge.getText()));
				if(re > 0) {
					JOptionPane.showMessageDialog(null, "충전이 완료되었습니다.");
					setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "충전 실패");
				}
			}
		});
		btn_charge_card.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//jp_cardCharge
				jl_card_num.removeAll();
				jl_card_num.setText("카드번호 : ");
				
			}
		});
		btn_charge_account.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//jp_cardCharge
				jl_card_num.removeAll();
				jl_card_num.setText("계좌번호 : ");
				
			}
		});
	
		setSize(400,300);
		//setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BE_PointChargeFrame();
	}

}
