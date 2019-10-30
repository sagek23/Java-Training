package bookOrder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connection.ConnectionProvider;

public class OrderPanel extends JPanel {
	
	HashMap<String, Vector<Integer>> map_book;
	HashMap<String, Integer> map_customer;
	
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	
	JComboBox<String> cb_bname;
	JComboBox<String> cb_cname;
	JTextField tfAmount;
	JTextField tfPrice;
	JTextField tfSum;
	
	JButton btnAdd;
	JButton btnOrder;
	
	Vector<String> vbname;
	Vector<String> vcname;	
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	int cnum = 0;
	int bnum = 0;
	int onum =0;
	int amount = 0;
	int dprice = 0;
	int price = 0;
	String bname="";
	int sum = 0;
	
	public OrderPanel()
	{
		map_book = new HashMap<String, Vector<Integer>>();
		map_customer = new HashMap<String, Integer>();
		lb1 = new JLabel("도서명");
		lb2 = new JLabel("고객명");
		lb3 = new JLabel("수량");
		lb4 = new JLabel("총 주문금액");
		
		vbname  = new Vector<String>();
		vcname = new Vector<String>();
		
		cb_bname = new JComboBox<String>(vbname);
		cb_cname = new JComboBox<String>(vcname);
		cb_bname.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = (String)cb_bname.getSelectedItem();
				bname = key;
				Vector<Integer> v= map_book.get(key);
				bnum = v.get(0);
				price = v.get(1);
			}
		});
		cb_cname.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = (String)cb_cname.getSelectedItem();
				cnum = map_customer.get(key);
			}
		});
		tfAmount = new JTextField(10);
		tfPrice = new JTextField(10);
		tfSum = new JTextField(10);
		
		btnAdd = new JButton("장바구니에 담기");
		btnOrder = new JButton("주문");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("수량");
		colNames.add("구매가격");
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		JPanel jp_total = new JPanel();
		
		jp_input.setLayout(new GridLayout(3,2));
		jp_input.add(lb1);
		jp_input.add(cb_bname);
		jp_input.add(lb2);
		jp_input.add(cb_cname);
		jp_input.add(lb3);
		jp_input.add(tfAmount);
		
		jp_btn.setLayout(new FlowLayout());
		jp_btn.add(btnAdd);
		jp_btn.add(btnOrder);
		
		jp_total.add(lb4);
		jp_total.add(tfPrice);

		jp_total.setLayout(new FlowLayout());
		
		jp.setLayout(new BorderLayout());
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_btn, BorderLayout.SOUTH);
		
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(jp_total, BorderLayout.SOUTH);
		
		listBook();
		listCustomer();
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				amount = Integer.parseInt( tfAmount.getText());
				dprice = amount * price;
				
				Vector<String> v = new Vector<String>();
				v.add(bnum+"");
				v.add(bname);
				v.add(amount+"");
				v.add(dprice+"");
				
				rowData.add(v);
				
				
				sum = getSum();
				
				tfPrice.setText(sum+"");
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
		
		jt.addMouseListener(new MouseListener() {
			
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
			
			}
		});
	}



	



	protected void order() {
		// TODO Auto-generated method stub
		onum = getNextNum();
		
		sum = getSum();
		
		String sql = "insert into orders values(?,?,?)";
		String sql2 = "insert into orders_d values(order_d.nextval,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, onum);
			pstmt.setInt(2, cnum);
			pstmt.setInt(3, sum);
			int re = pstmt.executeUpdate();
			
			int re2 = 0;
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			for(Vector<String> v:rowData) //rowData만큼 주문상세(orders_d)에 insert
			{
			pstmt2.setInt(1, Integer.parseInt(v.get(0)));
			pstmt2.setInt(2, Integer.parseInt(v.get(2)));
			pstmt2.setInt(3, Integer.parseInt(v.get(3)));
			pstmt2.setInt(4, onum);
			re2 = re2 + pstmt2.executeUpdate();
			}
			
			if(re == 1 && re2 == rowData.size())
			{
				conn.commit();
				JOptionPane.showMessageDialog(this, "주문하였습니다.");
			}
			else
			{
				conn.rollback();
				JOptionPane.showMessageDialog(this, "주문에 실패하였습니다.");
			}
				
			ConnectionProvider.close(conn, pstmt);
			ConnectionProvider.close(null, pstmt2);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}



	protected int getSum() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(Vector<String> v:rowData)
			sum = sum + Integer.parseInt(v.get(3));
		return sum;
		
	}
	
	public int getNextNum()
	{
		int max = 0;
		String sql = "Select nvl(max(onum),0)+1 from orders";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				max = rs.getInt(1);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return max;
	}

	protected void listBook() {
		// TODO Auto-generated method stub
		  
        String sql = "select bnum,bname,price from book";
        try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
            	Vector<Integer> v = new Vector<Integer>();            					
            	v.add(rs.getInt(1));
            	v.add(rs.getInt(3));
				vbname.add(rs.getString(2));
				map_book.put(rs.getString(2),v);;
            }
        
            ConnectionProvider.close(conn, stmt, rs);           
             
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
	}
    public void listCustomer()
	{
		String sql = "select cnum,cname from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next())
			{
				vcname.add(rs.getString(2));
				map_customer.put(rs.getString(2), rs.getInt(1));
			}
			cb_cname.updateUI();
			ConnectionProvider.close(conn, stmt, rs);
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
