package BookOrderHW1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connection.ConnectionProvider;

public class OrderPanel extends JPanel {

	String bname = "";
	int bnum = 0;
	int price = 0;
	int cnum = 0;
	int onum = 0;
	int quantity = 0;
	int dprice = 0;
	int total = 0;
	
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	
	JComboBox<String> cbBname;
	JComboBox<String> cbCname;
	
	Vector<String> vBname;
	Vector<String> vCname;
	
	JButton btnCart;
	JButton btnOrder;
	
	JTextField tfQuantity;
	JTextField tfAmount;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	
	HashMap<String, Vector<Integer>> mapB;
	HashMap<String, Integer> mapC;
	
	public OrderPanel()
	{
		mapB  = new HashMap<String, Vector<Integer>>();
		mapC = new HashMap<String, Integer>();
		lb1 = new JLabel("도서명");
		lb2 = new JLabel("고객명");
		lb3 = new JLabel("수량");
		lb4 = new JLabel("총 구매가격");
		
		vBname = new Vector<String>();
		vCname = new Vector<String>();
		
		cbBname = new JComboBox<String>(vBname);
		cbCname = new JComboBox<String>(vCname);
		
		btnCart = new JButton("장바구니");
		btnOrder = new JButton("구매하기");
		
		tfQuantity = new JTextField(10);
		tfAmount = new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("수량");
		colNames.add("금액");
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		JPanel jp_total = new JPanel();
	
		jp_input.setLayout(new GridLayout(3, 2));
		jp_input.add(lb1);
		jp_input.add(cbBname);
		jp_input.add(lb2);
		jp_input.add(cbCname);
		jp_input.add(lb3);
		jp_input.add(tfQuantity);
		
		jp_btn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_btn.add(btnCart);
		jp_btn.add(btnOrder);
		
		jp_total.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_total.add(lb4);
		jp_total.add(tfAmount);
		
		jp.setLayout(new BorderLayout());
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_btn, BorderLayout.SOUTH);
		
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(jp_total, BorderLayout.SOUTH);
		
		cbBname.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key =  (String)cbBname.getSelectedItem();
				bname = key;
				Vector<Integer> v = mapB.get(key);
				bnum = v.get(0);
				price = v.get(1);
			}/*listBook()메소드에서 mapB를 가져오는데 그때 map에 들어가는 값이 순서대로
			bnum, bname, price이다. 그 중 int는 bnum과 price이므로 순서대로 bnum의 인덱스가 0, price의
			인덱스가 1이다.*/
		});
		cbCname.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = (String)cbCname.getSelectedItem();
				cnum = mapC.get(key);
			}
		});
		listBook();
		listCustomer();
		btnCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quantity = Integer.parseInt(tfQuantity.getText());
				dprice = quantity*price;
				
				Vector<String> v = new Vector<String>();
				v.add(bnum+"");
				v.add(bname);
				v.add(quantity+"");
				v.add(dprice+"");
				
				rowData.add(v);
				
				total = getTotal();
				tfAmount.setText(total+"");
				jt.updateUI();
				
			}
		});
		
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order();
			}
		});
	}

	private void listCustomer() {
		// TODO Auto-generated method stub
		String sql = "select cnum, cname from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				vCname.add(rs.getString(2));
				mapC.put(rs.getString(2), rs.getInt(1));
			}
			cbCname.updateUI();
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+3);
		}
	}

	private void listBook() {
		// TODO Auto-generated method stub
		String sql = "select bnum, bname, price from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<Integer> v = new Vector<Integer>();
				v.add(rs.getInt(1));
				vBname.add(rs.getString(2));
				v.add(rs.getInt(3));
				mapB.put(rs.getString(2), v);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+4);
		}
	}

	protected void order() {
		// TODO Auto-generated method stub
		onum = getNextNum();
		total = getTotal();
		
		String sql="insert into orders values(?, ?, ?)";
		String sql2 = "insert into orders_d values(order_d.nextval, ?,?,?,?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt.setInt(1, onum);
			pstmt.setInt(2, cnum);
			pstmt.setInt(3, total);
			
			int re = pstmt.executeUpdate();
			
			int re2 = 0;
			for(Vector<String> v:rowData)
			{
				pstmt2.setInt(1, Integer.parseInt(v.get(0)));
				pstmt2.setInt(2, Integer.parseInt(v.get(2)));
				pstmt2.setInt(3, Integer.parseInt(v.get(3)));
				pstmt2.setInt(4, onum);
				re2 = re2+pstmt2.executeUpdate();
			}
			
			if(re == 1 && re2 == rowData.size())
			{
				conn.commit();
				System.out.println("주문성공");
			}
			else
			{
				System.out.println(re2);
				System.out.println(rowData.size());
				conn.rollback();
				System.out.println("주문실패");
			}
			ConnectionProvider.close(conn, pstmt);
			ConnectionProvider.close(null, pstmt2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	private int getNextNum() {
		// TODO Auto-generated method stub
		int max = 0;
		String sql = "select nvl(max(onum),0)+1 from orders";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
				max = rs.getInt(1);
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+2);
		}
		return max;
	}

	protected int getTotal() {
		// TODO Auto-generated method stub
		total = 0;
		for(Vector<String> v:rowData)
			total = total+Integer.parseInt(v.get(3));
		return total;
	}
	
}
