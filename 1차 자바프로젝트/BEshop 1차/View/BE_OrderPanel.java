package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DB.ConnectionProvider;

public class BE_OrderPanel extends JPanel {	
		JTextField jtf_name;
		Vector<String> order_colName;
		Vector<Vector<String>> order_rowData;
		JTable table;
		static String beuid;
		public BE_OrderPanel() 
		{
//			JPanel user_info = new JPanel();
//			JPanel user_grade = new JPanel();
//			user_grade.setLayout(new BorderLayout());
//			user_grade.add(new JLabel("회원등급 > "), BorderLayout.WEST);
//			user_grade.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
//			JPanel grade_btn = new JPanel();
//			JLabel grade = new JLabel("Green");
//			grade.setFont(new Font("나눔스퀘어", Font.BOLD, 30));
//			JButton btn_halin = new JButton("할인혜택보기");
//			grade_btn.setLayout(new BorderLayout());
//			grade_btn.add(grade, BorderLayout.WEST);
//			grade_btn.add(btn_halin, BorderLayout.EAST);
//			user_info.setLayout(new BorderLayout());
//			user_info.add(user_grade, BorderLayout.NORTH);
//			user_info.add(grade_btn, BorderLayout.SOUTH);
//			user_info.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 15));
//			
//			btn_halin.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					new BE_GradeImg();
//				}
//			});
			
			//최근 주문내역
			order_colName = new Vector<String>();
			order_rowData = new Vector<Vector<String>>();
			order_colName.add("주문번호");
			order_colName.add("상품명");
			order_colName.add("주문일자");
			order_colName.add("수량");
			order_colName.add("금액");
			JPanel label = new JPanel();
			
			JButton btn = new JButton("조회");
			table = new JTable(order_rowData, order_colName);
			
//			JLabel user_title = new JLabel("최근 주문 내역");
//	        user_title.setFont(new Font("나눔고딕",Font.BOLD, 15));
	        setLayout(new BorderLayout());
	        
	        JScrollPane jsp = new JScrollPane(table);
	        JPanel jp_order = new JPanel();
	        jp_order.setLayout(new BorderLayout());
	        //jp_order.add(user_title, BorderLayout.NORTH);
	        jp_order.add(jsp, BorderLayout.CENTER);
	        jp_order.add(btn, BorderLayout.SOUTH);
	        
	        //탭 생성
			JTabbedPane jt_order = new JTabbedPane();
			jt_order.add("최근주문내역", jp_order);
			
			//프레임에 탭, 회원 등급 패널 추가
		//	add(user_info, BorderLayout.NORTH);
			//add(user_title, BorderLayout.NORTH);
			add(jt_order, BorderLayout.CENTER);
			//add(btn, BorderLayout.SOUTH);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					listOrder();
				}
			});
			setVisible(true);
			
		}
		
		
		protected void listOrder() {
			// TODO Auto-generated method stub
			order_rowData.clear();				
			String sql = "select onum, p.pname, odate,ocount,oprice from orderdelivery o, product p where p.pnum = o.pnum and o.beuid='"+beuid+"'";
		
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
						v.add(rs.getString(2));
						v.add(rs.getDate(3)+"");
						v.add(rs.getInt(4)+"");
						v.add(rs.getInt(5)+"");
						order_rowData.add(v);
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
			new BE_OrderPanel();
		}

	}
	
	