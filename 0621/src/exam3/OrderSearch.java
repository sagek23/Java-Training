package exam3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

import db.ConnectionProvider;

public class OrderSearch extends JPanel {

	JRadioButton custoN;
	JRadioButton bookN;
	JRadioButton pubN;
	ButtonGroup bg;		
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	
	JTextField tfSearch;
	JButton btn;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	
	String fieldN;
	
	public OrderSearch() 
	{
		setLayout(new FlowLayout());
		custoN = new JRadioButton("고객명");
		bookN = new JRadioButton("도서명");
		pubN = new JRadioButton("출판사명");
		bg = new ButtonGroup();
		custoN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldN = "cname";
			}
		});
		bookN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldN = "bname";
			}
		});
		pubN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldN = "publisher";
			}
		});
		
		bg.add(custoN);
		bg.add(bookN);
		bg.add(pubN);
		//lb1 = new JLabel("고객명");
		//lb2 = new JLabel("도서명");
		//lb3 = new JLabel("출판사명");
		
		
		btn = new JButton("검색");
		tfSearch = new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("주문번호");
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("고객명");
		colNames.add("주소");
		colNames.add("전화");
		colNames.add("출판사");
		colNames.add("수량");
		colNames.add("금액");
		colNames.add("구매일자");
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		
		search();
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		
		jp.setLayout(new FlowLayout());
		jp.add(custoN);
		jp.add(bookN);
		jp.add(pubN);		
		jp.add(tfSearch);
		jp.add(btn);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				search();
				
			}
		});
	}
	protected void search() {
		// TODO Auto-generated method stub
		String keyword = tfSearch.getText();
		rowData.clear();
		//전체출력
		String sql = "select onum, bnum, bname, cname, addr, tel, publisher, oquantity, oamount, odate  from customer c, book b, orders o where c.cnum = o.csnum and b.bnum = o.bknum";
		if(!keyword.trim().equals(""))
		{	//만약 검색어가 있다면 아래의 sql문을 명령
			sql = "select onum, bnum, bname, cname, addr, tel, publisher, oquantity, oamount, odate  from customer c, book b, orders o where c.cnum = o.csnum and b.bnum = o.bknum and "+fieldN+" = ?";
			
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if(!keyword.trim().equals(""))
				pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getInt(2)+"");
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				v.add(rs.getInt(8)+"");
				v.add(rs.getInt(9)+"");
				v.add(rs.getString(10));
				rowData.add(v);
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			jt.updateUI();
					
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
