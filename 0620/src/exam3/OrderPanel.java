package exam3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
		
		JComboBox<String> cbBname;
		JComboBox<String> cbCname;
		JTextField tfQuan;
		
		Vector<String> vBname;
		Vector<String> vCname;
		Vector<Integer> vBnum;
		Vector<Integer> vCnum;
		Vector<Integer> vQuan;
		
		Vector<String> colNames;
		Vector<Vector<String>> rowData;
		JTable jt;
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();//customer�� 
		LinkedHashMap<String, Integer> mapb = new LinkedHashMap<String, Integer>();//book��
		
		
		
	@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			listBookName();
			listCName();
		}

	public OrderPanel() {
		setLayout(new FlowLayout());
		add(new JButton("�ֹ�����"));
		
		lb1 = new JLabel("������");
		lb2 = new JLabel("����");
		lb3 = new JLabel("�ֹ�����");
		
		//vBnum = new Vector<Integer>();
		//vCnum = new Vector<Integer>();
		vBname = new Vector<String>();
		vCname = new Vector<String>();
		
	
		
	
		
		
		cbBname = new JComboBox<String>(vBname);
		cbCname = new JComboBox<String>(vCname);
		tfQuan = new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		JButton btnAdd = new JButton("���");
		JButton btnUpd = new JButton("����");
		JButton btnDel = new JButton("����");
		JButton btnPri = new JButton("���");
		
		colNames.add("�ֹ���ȣ");
		colNames.add("������");
		colNames.add("����");
		colNames.add("�ֹ�����");
		colNames.add("�ֹ��ݾ�");
		colNames.add("��¥");
		
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
		jp_input.add(cbBname);
		jp_input.add(lb2);
		jp_input.add(cbCname);
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
		
		listBookName();
		listCName();
		
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
				onum = Integer.parseInt(v.get(0));
			
				cbBname.setSelectedItem(v.get(1));
				cbCname.setSelectedItem(v.get(2));
				tfQuan.setText(v.get(3));
			
			}
		});
	}
	
	public void listBookName()
	{
		vBname.clear();
		mapb.clear();
		String sql = "select bname, bnum from book";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				vBname.add(rs.getString(1));
				mapb.put(rs.getString(1), rs.getInt(2));
			}
			
			
			ConnectionProvider.close(conn, stmt, rs);
			//cbBname.update(getGraphics());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void listCName()
	{
		
		vCname.clear();
		map.clear();
		String sql = "select cname, cnum from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				vCname.add(rs.getString(1));
				map.put(rs.getString(1), rs.getInt(2));
			}
			
			
			ConnectionProvider.close(conn, stmt, rs);
			//cbCname.update(getGraphics());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}		
	}
	protected void addO() {
		// TODO Auto-generated method stub
		rowData.clear();
	//	int bnum = (Integer)cbBna.getSelectedItem();
		String bname = vBname.get(cbBname.getSelectedIndex());
		String cname = (String)cbCname.getSelectedItem();
		int bnum  = mapb.get(bname);
		int cnum  = map.get(cname);
		
		int oquan = Integer.parseInt(tfQuan.getText());
		//oamo = opri*oquan;
		
		
		int price = getPrice(bnum);
		int oamount = price*oquan;
		
		String sql = "insert into orders values(orderN.nextval, ?,?,?,?,sysdate)";
		
	
		try {
			
			
			if(!isAllInput())
			{
				JOptionPane.showMessageDialog(this, "�Է°��� Ȯ���ϼ���");
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
			System.out.println("�߰�����");
		else
			System.out.println("�߰�����");
		
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
	//	tfBnum.setText("");
	//	tfCnum.setText("");
		tfQuan.setText("");
		
	}
	private boolean isAllInput() {
		// TODO Auto-generated method stub
		
		boolean f=  true;
		if(//tfBnum.getText().trim().equals("")||
		   //tfCnum.getText().trim().equals("")||
		   tfQuan.getText().trim().equals(""))
		{
			f = false;
		}
		return f;
	}
	protected void UpdateO() {
		// TODO Auto-generated method stub
		rowData.clear();
		String bname = vBname.get(cbBname.getSelectedIndex());
		String cname = (String)cbCname.getSelectedItem();	
		int oquan = Integer.parseInt(tfQuan.getText());
		bnum = mapb.get(bname);
		cnum = map.get(cname);
		int price = getPrice(bnum);
		int oamount = price*oquan;
		if(!isAllInput())
		{
			JOptionPane.showMessageDialog(this, "�Է°��� Ȯ���ϼ���");
			clearText();
			return;
		}
		
		try {
			String sql = "update orders set bknum=?, csnum=?, oquantity = ?, oamount = ?  where onum = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			pstmt.setInt(2, cnum);
			pstmt.setInt(3, oquan);
			pstmt.setInt(4, oamount);
			pstmt.setInt(5, onum);
		
			int a = pstmt.executeUpdate();
			
			if (a>0)
				JOptionPane.showMessageDialog(this, "��������");
			else
				JOptionPane.showMessageDialog(this, "��������");
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
		
		int del = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?");
		if (del!=0)
			return;
		String sql = "delete orders where onum = ?";
		try {
	
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, onum);
			

			int a = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			if (a>0)
				JOptionPane.showMessageDialog(this, "��������");
			else
				JOptionPane.showMessageDialog(this, "��������");
			

			jt.updateUI();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	protected void PrintO() {
		// TODO Auto-generated method stub
		rowData.clear();
		String sql = "select onum, bname, cname, oquantity, oamount, odate from book, customer, orders where customer.cnum = orders.csnum and book.bnum = orders.bknum order by onum";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getInt(1)+"");
				//v.add(rs.getInt(2)+"");
				//v.add(rs.getInt(3)+"");
				v.add(rs.getString(2));
				v.add(rs.getString(3));
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
