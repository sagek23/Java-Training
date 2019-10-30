package View;

import javax.swing.JFrame;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DB.ConnectionProvider;


public class BE_CanclePanel extends JPanel {	
		JTextField jtf_name;
		Vector<String> colName;
		Vector<Vector<String>> rowData;
		JTable table;
		
		public BE_CanclePanel() 
		{
			//상단 회원 등급 고정
			JPanel user_info = new JPanel();
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
			user_info.setLayout(new BorderLayout());
			user_info.add(user_grade, BorderLayout.NORTH);
			user_info.add(grade_btn, BorderLayout.SOUTH);
			user_info.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 15));
			
			//취소/반품 패널
			colName = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			colName.add("주문번호");
			colName.add("접수일자");
			colName.add("상품명");
			colName.add("수량");
			colName.add("금액");
			JPanel label = new JPanel();
			
			JButton btn = new JButton("조회");
			table = new JTable(rowData, colName);
			
//			JLabel user_title = new JLabel("취소/교환/반품 내역");
//	        user_title.setFont(new Font("나눔고딕",Font.BOLD, 15));
	        setLayout(new BorderLayout());
	        
	        JScrollPane jsp = new JScrollPane(table);
	        JPanel jp_order = new JPanel();
	        jp_order.setLayout(new BorderLayout());
	        //jp_order.add(user_title, BorderLayout.NORTH);
	        jp_order.add(jsp, BorderLayout.CENTER);
	        
	        JTabbedPane jt_cancle_order = new JTabbedPane();
	        jt_cancle_order.add("취소/교환/반품 내역", jp_order);
	        
			
			add(user_info, BorderLayout.NORTH);
			//add(user_title, BorderLayout.NORTH);
			add(jt_cancle_order, BorderLayout.CENTER);
			add(btn, BorderLayout.SOUTH);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					listOrder();
				}
			});
			
			
			setSize(800,700);
			setVisible(true);
			
		}
		
		
		protected void listOrder() {
			// TODO Auto-generated method stub
			rowData.clear();				
			String sql = "select onum,odate,ocount,oprice from Orderdilivery";
		
			try {
				Connection conn = ConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				
				//PreparedStatement pstmt= conn.prepareStatement(sql);
				//pstmt.setString(1, uid);
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
						Vector<String> v = new Vector<String>();
						v.add(rs.getInt(1)+"");
						v.add(rs.getDate(2)+"");
						v.add(rs.getInt(3)+"");
						v.add(rs.getInt(4)+"");
						rowData.add(v);
						ConnectionProvider.close(conn, stmt, rs);
				}
				}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			table.updateUI();	
		}


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new BE_CanclePanel();
		}

	}
	
	