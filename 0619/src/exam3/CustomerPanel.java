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
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class CustomerPanel extends JPanel {
	int cnum = 0;
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	
	JTextField tfName;
	JTextField tfAddr;
	JTextField tfTel;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	protected Object PriCusto;
	
	public CustomerPanel() {
		setLayout(new FlowLayout());
		add(new JButton("고객관리"));
		
		lb1 = new JLabel("고객명");
		lb2 = new JLabel("주소");
		lb3 = new JLabel("전화번호");
		
		tfName = new JTextField(10);
		tfAddr = new JTextField(10);
		tfTel = new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colNames.add("고객번호");
		colNames.add("고객명");
		colNames.add("주소");
		colNames.add("전화번호");
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_input.setLayout(new GridLayout(3,2));
		jp_btn.setLayout(new FlowLayout());
		jp.setLayout(new BorderLayout());
		
		jp_input.add(lb1);
		jp_input.add(tfName);
		jp_input.add(lb2);
		jp_input.add(tfAddr);
		jp_input.add(lb3);
		jp_input.add(tfTel);
		
		JButton btnAdd = new JButton("추가");
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
				addCusto();
				PriCusto();
			}
		});
		
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			UpdCusto();
			PriCusto();
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			DelCusto();	
			PriCusto();
			}
		});
		
		btnPri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			PriCusto();
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
				tfName.setText(v.get(1));
				tfAddr.setText(v.get(2));
				tfTel.setText(v.get(3));
				cnum = Integer.parseInt(v.get(0));
			}
		});
	}

	protected void addCusto() {
		// TODO Auto-generated method stub
		rowData.clear();
		String cname = tfName.getText();
		String addr = tfAddr.getText();
		String tel = tfTel.getText();
		
		String sql = "insert into customer values(cusnum.nextval, ?,?,?)";
		
	
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
		pstmt.setString(3, tel);
		
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

	private void clearText() {
		// TODO Auto-generated method stub
		tfName.setText("");
		tfAddr.setText("");
		tfTel.setText("");
	}

	private boolean isAllInput() {
		// TODO Auto-generated method stub\
		boolean f=true;
		if(tfName.getText().trim().equals("")||
		 tfAddr.getText().trim().equals("")||
		 tfTel.getText().trim().equals(""))
		{
			f = false;
		}
		return f;
	}

	protected void UpdCusto() {
		// TODO Auto-generated method stub
		//rowData.clear();
		
		
		String cname = tfName.getText();
		String addr = tfAddr.getText();
		String tel = tfTel.getText();
		
		if(!isAllInput())
		{
			JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
			clearText();
			return;
		}
		
		try {
			String sql = "update customer set cname = ?, addr = ?, tel = ? where cnum = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tfName.getText());
			pstmt.setString(2, tfAddr.getText());
			pstmt.setString(3, tfTel.getText());
			pstmt.setInt(4, cnum);
			
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

	protected void DelCusto() {
		// TODO Auto-generated method stub
		rowData.clear();
		
		int del = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
		if (del!=0)
			return;
		String sql = "delete customer where cnum = ?";
		try {
	
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnum);
			

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

	protected void PriCusto() {
		// TODO Auto-generated method stub
		rowData.clear();
		String sql = "select * from customer order by cnum";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
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
