package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.plaf.TableUI;

import BE_ShoppingDao.BE_ReViewDao;
import BE_ShoppingVo.BE_ReviewVo;

public class BE_ReviewPanel extends JPanel {
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	JTable table;
	JTable table2;
	JTabbedPane review_tab;
	JButton btn_myreview;
	Vector<String> myreview_col;
	Vector<Vector<String>> myreview_row;
	BE_MyPageFrame main;
	String beuid;
	BE_ReViewDao dao = new BE_ReViewDao();
	BE_ReviewVo vo;
	ArrayList<BE_ReviewVo> Review_list = new ArrayList<BE_ReviewVo>();
	
	public BE_ReviewPanel() {
		main = this.main;

		// TODO Auto-generated constructor stub
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		myreview_col = new Vector<String>();
		myreview_row = new Vector<Vector<String>>();
		
		
		//리뷰가능 탭
		colName.add("주문번호");
		colName.add("주문일자");
		colName.add("상품명"); // 상품등록번호로 받아와야함
		colName.add("작성하기");
		
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		
		JButton btn_result = new JButton("조회");
		
		JPanel review1 = new JPanel();
		review1.setLayout(new BorderLayout());
	//	review1.add(user_info, BorderLayout.NORTH);
		review1.add(jsp, BorderLayout.CENTER);
		review1.add(btn_result, BorderLayout.SOUTH);
		
		//마이 리뷰
		myreview_col.add("후기번호");
		myreview_col.add("제목");
		myreview_col.add("등록일");
		
		table2 = new JTable(myreview_row, myreview_col);
		JScrollPane jsp2 = new JScrollPane(table2);
		
		btn_myreview = new JButton("조회");
		//내 리뷰 조회 이벤트
//	btn_myreview.addActionListener(new ActionListener() {
//						@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				myreviewList(beuid);
//			}
//		});
		
		JPanel review2 = new JPanel();
		review2.setLayout(new BorderLayout());
	//	review2.add(user_info, BorderLayout.NORTH);
		review2.add(jsp2, BorderLayout.CENTER);
		review2.add(btn_myreview, BorderLayout.SOUTH);
		
		review_tab = new JTabbedPane();
		
		//리뷰가능, 내 리뷰 버튼
	//	review_tab.add("작성가능한 리뷰", review1);
		review_tab.add("내 리뷰", review2);
	
		table2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table2.getSelectedRow();
				int col = table2.getSelectedColumn();
				BE_ReviewDetailPanel rd = new BE_ReviewDetailPanel();
				String a = (String)table2.getValueAt(row, col);
				System.out.println(a);
				rd.jl_renum2.setText(a);
				rd.setVisible(true);
			}
		});
		
		//setLayout(new BorderLayout());
		add(review_tab);
		setVisible(true);
	}
	
	//리뷰 작성 가능한 목록 출력
	public void review_Ok() {
		
	}
	//마이 리뷰
	//			myreview_col.add("후기번호");
	//			myreview_col.add("제목");
	//			myreview_col.add("등록일");
	public void myreviewList(){
		myreview_row.clear();
		//ArrayList<BE_ReviewVo> Review_list = new ArrayList<BE_ReviewVo>();
		//BE_ReViewDao dao = new BE_ReViewDao();
		//Review_list = dao.ReViewlistAll(uid);

		for(BE_ReviewVo vo : Review_list) {
			//System.out.println(Review_list);
			Vector<String> list = new Vector<String>();
			list.add(vo.getReNum()+"");
			list.add(vo.getReTitle());
			list.add(vo.getReDate()+"");
			
			myreview_row.add(list);
		}
		table2.updateUI();
	}
	
	public static void main(String[] args) {
		new BE_ReviewPanel();
	}
}
