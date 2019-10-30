package hw1;

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

import Connection.ConnectionProvider;

public class Customer extends JPanel {
	
	int cnum = 0;
	JTextField tfName;
	JTextField tfAddr;
	
	JLabel lb1;
	JLabel lb2;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTable jt;
	JButton btnAdd;
	JButton btnUpd;
	JButton btnDel;
	JButton btnPri;
	
	public Customer()
	{
		setLayout(new FlowLayout());
		add(new JButton("고객"));
		lb1 = new JLabel("이름");
		lb2 = new JLabel("주소");
		tfName = new JTextField(10);
		tfAddr = new JTextField(10);
		
		btnAdd = new JButton("추가");
		btnUpd = new JButton("수정");
		btnDel = new JButton("삭제");
		btnPri = new JButton("검색");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("번호");
		colNames.add("이름");
		colNames.add("주소");

		jt = new JTable(rowData, colNames);
		
		
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_input.add(lb1);
		jp_input.add(tfName);
		jp_input.add(lb2);
		jp_input.add(tfAddr);
		
		jp_btn.add(btnAdd);
		jp_btn.add(btnUpd);
		jp_btn.add(btnDel);
		jp_btn.add(btnPri);
		
		jp_input.setLayout(new GridLayout(2,3));
		jp_btn.setLayout(new FlowLayout());
		jp.setLayout(new BorderLayout());
		
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_btn, BorderLayout.SOUTH);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addC();
				PrintC();
			}
		});
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateC();
				PrintC();
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DelC();
				PrintC();
			}
		});
		btnPri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrintC();
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
				cnum = Integer.parseInt(v.get(0));
				
				tfName.setText(v.get(1));
				tfAddr.setText(v.get(2));
			}
		});
		
		
	}

	protected void PrintC() {
		// TODO Auto-generated method stub
		
		rowData.clear();
		String sql = "select * from customer order by cnum";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				rowData.add(v);
			}
			ConnectionProvider.close(conn, stmt, rs);
			jt.updateUI();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	protected void addC() {
		// TODO Auto-generated method stub
		
		String cname = tfName.getText();
		String addr = tfAddr.getText();
		
		String sql ="insert into customer values(seq_cus.nextval, ?, ?)";
		try {
			if(!isAllInput())
			{
				JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
				clearText();
				return;
			}
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, addr);
			
			int a = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if(a>0)
				System.out.println("추가 성공");
			else
				System.out.println("추가 실패");
			
			
			
			jt.updateUI();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	protected void updateC() {
		// TODO Auto-generated method stub
		String cname = tfName.getText();
		String addr = tfAddr.getText();
		if(!isAllInput())
		{
			JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
			clearText();
			return;
		}
		String sql = "update customer set cname = ?, addr = ? where cnum = ?";
		try {
				
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, addr);
			pstmt.setInt(3, cnum);
			
			int a = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if(a>0)
				System.out.println("수정성공");
			else
				System.out.println("수정실패");
			
			jt.updateUI();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

	protected void DelC() {
		// TODO Auto-generated method stub
		int del = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
		if(del!=0)
			return;
		String sql = "delete customer where cnum =?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnum);
			
			int a = pstmt.executeUpdate();
			
			if (a>0)
				System.out.println("삭제성공");
			else
				System.out.println("삭제실패");
			ConnectionProvider.close(conn, pstmt);
			jt.updateUI();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	private void clearText() {
		// TODO Auto-generated method stub

		tfName.setText("");
		tfAddr.setText("");

	}
	private boolean isAllInput() {
		// TODO Auto-generated method stub
		
		boolean f=  true;
		if(tfName.getText().trim().equals("")||
		   tfAddr.getText().trim().equals(""))
		{
			f = false;
		}
		return f;
	}
	
}
