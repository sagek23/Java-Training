package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BE_UserDao.BE_PointDao;
import BE_UserVo.BE_PointVo;

public class BE_PointPanel extends JPanel{	
		JTextField jtf_name;
		Vector<String> colName;
		Vector<Vector<String>> rowData;
		JTable table;
		JLabel p_balance = new JLabel("포인트 잔액");
		JTextField p_plus_b = new JTextField(10);
		JLabel p_minus_b = new JLabel("     0원");
		BE_PointChargeFrame point_charge;
		String beuid;
		BE_PointDao dao = new BE_PointDao();
		BE_PointVo vo;
		JLabel jl_point = new JLabel();
		public BE_PointPanel() 
		{
			vo = new BE_PointVo();
			point_charge = new BE_PointChargeFrame();
			//포인트 잔액 패널
			JPanel pointBalance = new JPanel();
			pointBalance.setBorder(new EmptyBorder(0, 20, 0, 0));
			pointBalance.setLayout(new BorderLayout());
			
			
			//System.out.println(beuid);
			// dao.PointBalance(beuid);
			//System.out.println(vo.getPointBalance());
			//jl_point.setText(vo.getPointBalance()+"원");
			jl_point.setFont(new Font("나눔고딕", Font.BOLD, 25));
			p_balance.setFont(new Font("나눔고딕", Font.PLAIN, 20));
			pointBalance.add(p_balance, BorderLayout.NORTH);
			pointBalance.add(jl_point,BorderLayout.CENTER);
			
			//포인트 충전 패널
			JPanel pointCharge = new JPanel(); 
			pointCharge.setLayout(new FlowLayout());
			
			// 포인트 충전 왼쪽(적립예정)
			JPanel p_Charge_left = new JPanel(); 
			p_Charge_left.setLayout(new BorderLayout());
			p_Charge_left.add(new JLabel("   충전금액"), BorderLayout.NORTH);
			p_plus_b.setFont(new Font("나눔고딕",Font.BOLD, 20));
			p_Charge_left.add(p_plus_b, BorderLayout.CENTER);
			JButton btn_ch = new JButton("충전하기");
			p_Charge_left.add(btn_ch,BorderLayout.SOUTH);
			
			// 포인트 충전 오른쪽(소멸예정)
			JPanel p_Charge_right = new JPanel(); 
			p_Charge_right.setLayout(new BorderLayout());
//			p_Charge_right.add(new JLabel("   소멸예정"), BorderLayout.NORTH);
//			p_minus_b.setFont(new Font("나눔고딕",Font.BOLD, 20));
//			p_Charge_right.add(p_minus_b, BorderLayout.CENTER);
//			JButton btn_withdraw = new JButton("출금하기");
//			p_Charge_right.add(btn_withdraw, BorderLayout.SOUTH);
			
			pointCharge.add(p_Charge_left);
			//pointCharge.add(p_Charge_right);
			
			
			//상단 패널 2개를 포함하는 point_up패널
			JPanel point_up = new JPanel();
			point_up.setBorder(new LineBorder(new Color(0, 0, 0)));
			point_up.setLayout(new GridLayout(1,2));
			point_up.add(pointBalance);
			point_up.add(pointCharge);

			
			colName = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			colName.add("포인트구매번호");
			colName.add("충전금액");
			colName.add("충전방법");
			colName.add("충전날짜");
			
			JButton btn = new JButton("조회");
			table = new JTable(rowData, colName);
			
			JScrollPane jsp = new JScrollPane(table);
			
			JPanel point = new JPanel();
			point.setLayout(new BorderLayout());
			point.add(point_up, BorderLayout.NORTH);
			point.add(jsp,BorderLayout.CENTER);
			
//			JLabel user_title = new JLabel("포인트 충전/조회");
//	        user_title.setFont(new Font("나눔고딕",Font.BOLD, 25));
	        
//			add(user_title, BorderLayout.NORTH);
			setLayout(new BorderLayout());
			add(point, BorderLayout.CENTER);
			add(btn, BorderLayout.SOUTH);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					listPoint();
					
				}
			});
			
			btn_ch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BE_PointChargeFrame charge = new BE_PointChargeFrame();
					charge.jtf_charge.setText(p_plus_b.getText());
					charge.beuid = beuid;
					System.out.println(charge.beuid);
					charge.setVisible(true);
					
					
				}
			});
			setVisible(true);	
			
			
//			point_charge.btn_charge.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("조회눌렸따");
//					System.out.println(beuid);
//					int re = dao.UpdatePoint(beuid, Integer.parseInt(point_charge.jtf_charge.getText()));
//					if(re > 0) {
//						JOptionPane.showMessageDialog(null, "충전이 완료되었습니다.");
//						setVisible(false);
//						BE_PointDao dao1 = new BE_PointDao();
//						BE_PointVo vo = dao1.PointBalance(beuid);
//						jl_point.removeAll();
//						jl_point.setText(vo.getPointBalance()+"원");
//						System.out.println("조회눌려따");
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "충전 실패");
//					}
//				}
//			});
//			point_charge.btn_charge_card.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					//jp_cardCharge
//					point_charge.jl_card_num.removeAll();
//					point_charge.jl_card_num.setText("카드번호 : ");
//					
//				}
//			});
//			point_charge.btn_charge_account.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					//jp_cardCharge
//					point_charge.jl_card_num.removeAll();
//					point_charge.jl_card_num.setText("계좌번호 : ");
//					
//				}
//			});
		}
//		
//		colName.add("포인트구매번호");
//		colName.add("충전금액");
//		colName.add("충전방법");
//		colName.add("충전날짜");
		
		protected void listPoint() {
			// TODO Auto-generated method stub
			rowData.clear();	
			ArrayList<BE_PointVo> pointlist = new ArrayList<BE_PointVo>();
			BE_PointDao dao = new BE_PointDao();
			pointlist = dao.PointSearch(beuid);
			for(BE_PointVo vo : pointlist) {
				Vector<String> list = new Vector<String>();
				list.add(vo.getPointPurNum()+"");
				list.add(vo.getPointDetails()+"");
				list.add(vo.getChangeMethod());
				list.add(vo.getChangeDate()+"");
				
				rowData.add(list);
			}
			table.updateUI();
			
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new BE_PointPanel();
		}

	}
