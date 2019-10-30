package book;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connection.ConnectionProvider;

public class BookFrame extends JFrame {
	JLabel lb1;
	JTextField tfName;
	
	JButton btn;
	JTable jt;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public BookFrame() 
		// TODO Auto-generated constructor stub
	{
		lb1 = new JLabel("이름");
		tfName = new JTextField(10);
		btn = new JButton("검색");
		
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("도서명");
		colNames.add("가격");
		colNames.add("출판사");
		jt = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		JPanel jp = new JPanel();
		setLayout(new BorderLayout());
		jp.setLayout(new FlowLayout());
		jp.add(lb1);
		jp.add(tfName);
		jp.add(btn);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchByName();
			}
		});
		
		
	}

	protected void searchByName() {
		// TODO Auto-generated method stub
		rowData.clear();                                                                                                     
	String sql = 
					"select bookname, price, publisher from book where bookid in"+
					"((select bookid from " + 
					"orders where custid in (select custid " + 
					"from ( select custid, count(o.bookid) " + 
					"from orders o, (select bookid from " + 
					"customer c, orders o " + 
					"where c.custid = o.custid and " + 
					"name = ? ) list " + 
					"where o.bookid = list.bookid and " + 
					"custid != (select custid from customer where name=?) " + 
					"group by custid " + 
					"order by count(o.bookid) desc ) count_list " + 
					"where rownum <= 2)) " + 
					"minus " + 
					"(select bookid from " + 
					"customer c, orders o " + 
					"where c.custid = o.custid and " + 
					"name = ?))";
			
	String sql2 = 
					"select bookname, price, publisher from book where bookid in"+
					"((select bookid from " + 
					"(select bookid, count(bookid) " + 
					"from orders " + 
					"group by bookid " + 
					"order by count(bookid) desc) " + 
					"where rownum <= 3) " + 
					"minus " + 
					"(select bookid from " + 
					"customer c, orders o " + 
					"where c.custid = o.custid and " + 
					"name = ?))";

			
			try {
				
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, tfName.getText());
				pstmt.setString(2, tfName.getText());
				pstmt.setString(3, tfName.getText());
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					do
					{
						Vector<String> v = new Vector<String>();
						v.add(rs.getString(1));
						v.add(rs.getInt(2)+"");
						v.add(rs.getString(3));
						rowData.add(v);
					}while(rs.next());
				}
				else
				{
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);
					pstmt2.setString(1, tfName.getText());
					
					ResultSet rs2 = pstmt2.executeQuery();
					while(rs2.next())
					{
						Vector<String> v = new Vector<String>();
						v.add(rs2.getString(1));
						v.add(rs2.getInt(2)+"");
						v.add(rs2.getString(3));
						rowData.add(v);
					}
					ConnectionProvider.close(null, pstmt2, rs2);
				}
				ConnectionProvider.close(conn, pstmt, rs);
				jt.updateUI();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}	
		

	}
}
