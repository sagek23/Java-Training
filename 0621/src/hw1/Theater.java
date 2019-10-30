package hw1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
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

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connection.ConnectionProvider;

public class Theater extends JPanel {

	int tnum =0;
	int price = 0;
	int scap =0;
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;

	JTextField tfMtitle;
	JTextField tfPrice;
	JTextField tfScap;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	
	public Theater()
	{
	
		setLayout(new FlowLayout());
		add(new JButton("상영관"));
		
		lb1 = new JLabel("영화제목");
		lb2 = new JLabel("가격");
		lb3 = new JLabel("좌석수");
		
		tfMtitle = new JTextField(10);
		tfPrice = new JTextField(10);
		tfScap = new JTextField(10);
		
		JButton btnAdd = new JButton("등록");
		JButton btnUpd = new JButton("수정");
		JButton btnDel = new JButton("삭제");
		JButton btnPri = new JButton("검색");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("상영관 번호");
		colNames.add("영화제목");
		colNames.add("가격");
		colNames.add("좌석수");
		
		jt = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_input.setLayout(new GridLayout(3, 2));
		jp_btn.setLayout(new FlowLayout());
		jp.setLayout(new BorderLayout());
		
		jp_input.add(lb1);
		jp_input.add(tfMtitle);
		jp_input.add(lb2);
		jp_input.add(tfPrice);
		jp_input.add(lb3);
		jp_input.add(tfScap);
		
		jp_btn.add(btnAdd);
		jp_btn.add(btnUpd);
		jp_btn.add(btnDel);
		jp_btn.add(btnPri);
		
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_btn, BorderLayout.SOUTH);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
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
				tnum = Integer.parseInt(v.get(0));
				tfMtitle.setText(v.get(1));
				tfPrice.setText(v.get(2));
				tfScap.setText(v.get(3));
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addT();
				PrintT();
			}
		});
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateT();
				PrintT();
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DelT();
				PrintT();
			}
		});
		btnPri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrintT();
			}
		});
		
	}

	protected void PrintT() {
		// TODO Auto-generated method stub
		rowData.clear();
		
		
		try {
			
			String sql = "select * from theater order by tnum";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));
				v.add(rs.getInt(3)+"");
				v.add(rs.getInt(4)+"");
				rowData.add(v);		
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			jt.updateUI();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	protected void addT() {
		// TODO Auto-generated method stub
		rowData.clear();
		String mtitle = tfMtitle.getText();
		int price = Integer.parseInt(tfPrice.getText());
		int scap = Integer.parseInt(tfScap.getText());
		
		String sql = "insert into theater values(seq_thea.nextval, ?, ?, ?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mtitle);
			pstmt.setInt(2, price);
			pstmt.setInt(3, scap);
			
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

	protected void DelT() {
		// TODO Auto-generated method stub
		
		int del = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
		//예(0), 아니오(1), 취소(2)를 눌렀을 때의 값을 확인한 후 기능을 처리.
		if (del!=0)
			return;
		String sql = "delete theater where tnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tnum);
			
			int a = pstmt.executeUpdate();
			
			if(a>0)
				System.out.println("삭제성공");
			else
				JOptionPane.showMessageDialog(this, "삭제실패");
			
			
			
			jt.updateUI();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	protected void UpdateT() {
		// TODO Auto-generated method stub
		rowData.clear();
		String title = tfMtitle.getText();
		int price = Integer.parseInt(tfPrice.getText());
		int scap = Integer.parseInt(tfScap.getText());
		String sql= "update theater set  mtitle = ?, price =?, scapacity = ? where tnum = ?";
		try {
			
			if(!isAllInput())
			{
				JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
				clearText();
				return;
			}
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, price);
			pstmt.setInt(3, scap);
			pstmt.setInt(4, tnum);
			
			int a = pstmt.executeUpdate();
			if(a>0)
				System.out.println("수정성공");
			else
				System.out.println("수정실패");
			ConnectionProvider.close(conn, pstmt);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	
	private void clearText() {
		// TODO Auto-generated method stub

		tfMtitle.setText("");
		tfPrice.setText("");
		tfScap.setText("");
		
	}
	private boolean isAllInput() {
		// TODO Auto-generated method stub
		
		boolean f=  true;
		if(tfMtitle.getText().trim().equals("")||
		   tfPrice.getText().trim().equals("")||
		   tfScap.getText().trim().equals(""))
		{
			f = false;
		}
		return f;
	}
	
}
