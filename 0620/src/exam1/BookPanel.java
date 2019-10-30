package exam1;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class BookPanel extends JPanel {
	
	int bnum = 0;
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;

	JTextField tfBname;
	JTextField tfPri;
	JTextField tfAut;
	JTextField tfPub;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	
	public BookPanel() 
	{
		setLayout(new FlowLayout());
		add(new JButton("도서관리"));
		
		tfBname = new JTextField(10);
		tfPri = new JTextField(10);
		tfAut = new JTextField(10);
		tfPub = new JTextField(10);
		
		lb1 = new JLabel("도서명:");
		lb2 = new JLabel("가격:");
		lb3 = new JLabel("저자:");
		lb4 = new JLabel("출판사:");
	
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("가격");
		colNames.add("저자");
		colNames.add("출판사");
		
		jt = new JTable(rowData,colNames);
		
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
				tfBname.setText(v.get(1));
				tfPri.setText(v.get(2));
				tfAut.setText(v.get(3));
				tfPub.setText(v.get(4));
				bnum = Integer.parseInt(v.get(0));
			}
		});
		
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_input.setLayout(new GridLayout(4, 2)); //4행 2열
		jp_btn.setLayout(new FlowLayout());
		jp.setLayout(new BorderLayout());
		jp_input.add(lb1);
		jp_input.add(tfBname);
		jp_input.add(lb2);
		jp_input.add(tfPri);
		jp_input.add(lb3);
		jp_input.add(tfAut);
		jp_input.add(lb4);
		jp_input.add(tfPub);
		
		JButton btnAdd = new JButton("등록");
		JButton btnUpd = new JButton("수정");
		JButton btnDel = new JButton("삭제");
		JButton btnPri = new JButton("출력");
		
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
				insertBook();
				printBook();
			}
		});
		
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateBook();
				printBook();
			}
		});
		btnDel.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteBook();
				printBook();
			}
		});
		btnPri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printBook();
			}
		});
	}

	protected void printBook() {
		// TODO Auto-generated method stub
	
			rowData.clear();
			String sql = "select * from book order by bnum";
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));
				v.add(rs.getInt(3)+"");
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				rowData.add(v);
			}
			//System.out.println(rowData.size());
			ConnectionProvider.close(conn, stmt, rs);
		
			
			jt.updateUI();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	protected void deleteBook() {
		// TODO Auto-generated method stub
		
			int del = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
			//예(0), 아니오(1), 취소(2)를 눌렀을 때의 값을 확인한 후 기능을 처리.
			System.out.println(del);
			if (del!=0)
				return;
				
		try {
			//String bname = tfBname.getText();
			String sql = "delete book where bnum = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(0, bnum);
			//pstmt.setInt(2, price);
			//pstmt.setString(3, author);
			//pstmt.setString(4, pub);
			//pstmt.setInt(5, bnum);
			
			int a = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if (a>0)
				JOptionPane.showMessageDialog(this, "삭제성공");
			else
				JOptionPane.showMessageDialog(this, "삭제실패");
			
			
			
			jt.updateUI();
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	protected void updateBook() {
		// TODO Auto-generated method stub
			
			if(!isAllInput())
			{
				JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
				clearText();
				return;
			}
			String bname = tfBname.getText();
			int price = Integer.parseInt(tfPri.getText());
			String author = tfAut.getText();
			String pub = tfPub.getText();
		try {
			String sql = "update book set bname = ?, price =?, author = ?, "
					+ "publisher = ? where bnum = ?";
		
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setInt(2, price);
			pstmt.setString(3, author);
			pstmt.setString(4, pub);
			pstmt.setInt(5, bnum);
			
			int a = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if (a>0)
				JOptionPane.showMessageDialog(this, "수정성공");
			else
				JOptionPane.showMessageDialog(this, "수정실패");
			
			
			
			jt.updateUI();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	protected void insertBook() {
		// TODO Auto-generated method stub
		if(!isAllInput())
		{
			JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
			clearText();
			return;
		}
		String bname = tfBname.getText();
		int price = Integer.parseInt(tfPri.getText());
		String author = tfAut.getText();
		String pub = tfPub.getText();
		//String sql = "insert into book values(seq_book.nextval,'"+bname+"',"+price+",'"+author+"','"+pub+"')";
		String sql = "insert into book values(seq_book.nextval,?,?,?,?)";
		
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, bname);
			stmt.setInt(2, price);
			stmt.setString(3, author);
			stmt.setString(4, pub);
			
			int a = stmt.executeUpdate();
			if (a>0)
				JOptionPane.showMessageDialog(this, "추가성공");
			else
				JOptionPane.showMessageDialog(this, "추가실패");
			ConnectionProvider.close(conn, stmt);
			
			
			jt.updateUI();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		clearText();
	}

	private boolean isAllInput() {
		// TODO Auto-generated method stub
		boolean f=  true;
		if(tfBname.getText().trim().equals("")||
		   tfPri.getText().trim().equals("")||
		   tfAut.getText().trim().equals("")||
		   tfPub.getText().trim().equals(""))
		{
			f = false;
		}
		return f;
	}

	private void clearText() {
		// TODO Auto-generated method stub
		tfBname.setText("");
		tfPri.setText("");
		tfAut.setText("");
		tfPub.setText("");
		
		
	}
		
}
