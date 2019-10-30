package exam3;

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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class OrderPanel extends JPanel {
		int onum = 0;
		int bnum = 0;
		int cnum = 0;
		//int opri  = 0;
		//int oamo = 0;
		String dday="";
		JLabel  lb1;
		JLabel  lb2;
		JLabel  lb3;
		
		JTextField tfBnum;
		JTextField tfCnum;
		JTextField tfQuan;
		
		Vector<String> colNames;
		Vector<Vector<String>> rowData;
		JTable jt;
	public OrderPanel() {
		setLayout(new FlowLayout());
		add(new JButton("주문관리"));
		
		lb1 = new JLabel("도서번호");
		lb2 = new JLabel("고객번호");
		lb3 = new JLabel("주문수량");
		
		tfBnum = new JTextField(10);
		tfCnum = new JTextField(10);
		tfQuan = new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		JButton btnAdd = new JButton("등록");
		JButton btnUpd = new JButton("수정");
		JButton btnDel = new JButton("삭제");
		JButton btnPri = new JButton("출력");
		
		colNames.add("주문번호");
		colNames.add("도서번호");
		colNames.add("고객번호");
		colNames.add("주문수량");
		colNames.add("주문금액");
		colNames.add("날짜");
		
		jt = new JTable(rowData,colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_input.setLayout(new GridLayout(3,2));
		jp_btn.setLayout(new FlowLayout());
		jp.setLayout(new BorderLayout());
		
		jp_input.add(lb1);
		jp_input.add(tfBnum);
		jp_input.add(lb2);
		jp_input.add(tfCnum);
		jp_input.add(lb3);
		jp_input.add(tfQuan);
		
		jp_btn.add(btnAdd);
		jp_btn.add(btnUpd);
		jp_btn.add(btnDel);
		jp_btn.add(btnPri);
		
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_btn, BorderLayout.SOUTH);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addO();
				PrintO();
			}
		});
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateO();
				PrintO();
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteO();
				PrintO();
			}
		});
		btnPri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrintO();
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
				int row = jt.getSelectedRow();
				Vector<String> v = rowData.get(row);
				//onum = Integer.parseInt(v.get(0));
				tfBnum.setText(v.get(1));
				tfCnum.setText(v.get(2));				
				tfQuan.setText(v.get(3));
				//onum = Integer.parseInt(v.get(0));
				//.setText(v.get(3));
				//tfCnum.setText(v.get(4));
			}
		});
		
	}
	protected void addO() {
		// TODO Auto-generated method stub
		rowData.clear();
		int bnum = Integer.parseInt(tfBnum.getText());
		int cnum = Integer.parseInt(tfCnum.getText());
		int oquan = Integer.parseInt(tfQuan.getText());
		//oamo = opri*oquan;
		
		
		int price = getPrice(bnum);
		int oamount = price*oquan;
		
		String sql = "insert into orders values(orderN.nextval, ?,?,?,?,sysdate)";
		
	
		try {
			
			
			if(!isAllInput())
			{
				JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
				clearText();
				return;
			}
			
		
		Connection conn = ConnectionProvider.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bnum);
		pstmt.setInt(2, cnum);
		pstmt.setInt(3, oquan);
		pstmt.setInt(4, oamount);
		
		
		int a = pstmt.executeUpdate();
		
		if(a>0)
			System.out.println("추가성공");
		else
			System.out.println("추가실패");
		
		ConnectionProvider.close(conn, pstmt);
		
		jt.updateUI();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	private int getPrice(int bnum) {
		// TODO Auto-generated method stub
		String sql = "select price from book where bnum = ?";
		int price = 0;
		
	try {
			
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bnum);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			price = rs.getInt(1);
		}	
		ConnectionProvider.close(conn, pstmt, rs);
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return price;
	
	}
	private void clearText() {
		// TODO Auto-generated method stub
		tfBnum.setText("");
		tfCnum.setText("");
		tfQuan.setText("");
		
	}
	private boolean isAllInput() {
		// TODO Auto-generated method stub
		
		boolean f=  true;
		if(tfBnum.getText().trim().equals("")||
		   tfCnum.getText().trim().equals("")||
		   tfQuan.getText().trim().equals(""))
		{
			f = false;
		}
		return f;
	}
	protected void UpdateO() {
		// TODO Auto-generated method stub
		rowData.clear();
		int bnum = Integer.parseInt(tfBnum.getText());
		int cnum = Integer.parseInt(tfCnum.getText());
		int oquan = Integer.parseInt(tfQuan.getText());
	
		int price = getPrice(bnum);
		int oamount = price*oquan;
		if(!isAllInput())
		{
			JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
			clearText();
			return;
		}
		
		try {
			String sql = "update orders set oquantity = ?, oamount = ?  where bknum = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oquan);
			pstmt.setInt(2, oamount);
			pstmt.setInt(3, bnum);
		
			int a = pstmt.executeUpdate();
			
			if (a>0)
				JOptionPane.showMessageDialog(this, "수정성공");
			else
				JOptionPane.showMessageDialog(this, "수정실패");
			ConnectionProvider.close(conn, pstmt);
			
			jt.updateUI();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	protected void DeleteO() {
		// TODO Auto-generated method stub
		rowData.clear();
		int bnum = Integer.parseInt(tfBnum.getText());
		int del = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
		if (del!=0)
			return;
		String sql = "delete orders where bknum = ?";
		try {
	
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			

			int a = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if (a>0)
				JOptionPane.showMessageDialog(this, "삭제성공");
			else
				JOptionPane.showMessageDialog(this, "삭제실패");
			

			jt.updateUI();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	protected void PrintO() {
		// TODO Auto-generated method stub
		rowData.clear();
		String sql = "select onum, bnum, cnum, oquantity, oamount, odate from book, customer, orders where customer.cnum = orders.csnum and book.bnum = orders.bknum order by onum";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getInt(2)+"");
				v.add(rs.getInt(3)+"");
				v.add(rs.getInt(4)+"");
				v.add(rs.getInt(5)+"");
				v.add(rs.getString(6));
				rowData.add(v);
						
			}
			
			ConnectionProvider.close(conn, stmt);
			jt.updateUI();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
}
