package hw1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import Connection.ConnectionProvider;
import java.util.*;
public class Booking extends JPanel {
	
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	
	JComboBox<String> cbTitle;
	JComboBox<String> cbCname;
	JComboBox<Integer> cbSnum;
	JComboBox<Date> cbDate;
	
	Vector<String> vTitle;
	Vector<String> vCname;
	Vector<Integer> vSnum;
	Vector<Date> vDate;
	
	JButton btnAdd;
	JButton btnUpd;
	JButton btnDel;
	JButton btnPri;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	
	LinkedHashMap<String, Integer> mapt= new LinkedHashMap<String, Integer>();
	LinkedHashMap<String, Integer> mapc= new LinkedHashMap<String, Integer>();
	LinkedHashMap<String, Integer> maps= new LinkedHashMap<String, Integer>();
	//LinkedHashMap<String, Integer> mapb = new LinkedHashMap<String, Integer>();
	
	public Booking()
	{
		lb1 = new JLabel("상영관번호");
		lb2 = new JLabel("고객번호");
		lb3 = new JLabel("좌석번호");
		lb4 = new JLabel("날짜");
		
		btnAdd = new JButton("등록");
		btnUpd = new JButton("수정");
		btnDel = new JButton("삭제");
		btnPri = new JButton("검색");
		
		vTitle = new Vector<String>();
		vCname = new Vector<String>();
		vSnum = new Vector<Integer>();
		vDate = new Vector<Date>();
		
		listTitle();
		listName();
		listbDate();
		
		cbTitle = new JComboBox<String>(vTitle);
		cbCname = new JComboBox<String>(vCname);
		cbSnum = new JComboBox<Integer>(vSnum);
		cbDate = new JComboBox<Date>(vDate);
		
		cbTitle.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vSnum.clear();
				String title = (String)cbTitle.getSelectedItem();
				//System.out.println(title);
				int tnum = mapt.get(title);
				int seat = getSeatCount(tnum);
				//System.out.println(seat);
				for(int i =1; i<=seat;i++)
					vSnum.add(i);
				cbSnum.updateUI();
			}
		});
		cbCname.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cname = (String)cbCname.getSelectedItem();
				int cnum = mapc.get(cname);
				//System.out.println(cnum);
			}
		});

		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("예약번호");
		colNames.add("상영관번호");
		colNames.add("고객번호");
		colNames.add("좌석번호");
		colNames.add("날짜");
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JPanel jp_input = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp_input.setLayout(new GridLayout(4, 2));
		jp_btn.setLayout(new FlowLayout());
		jp.setLayout(new BorderLayout());
		
		jp_input.add(lb1);
		jp_input.add(cbTitle);
		jp_input.add(lb2);
		jp_input.add(cbCname);
		jp_input.add(lb3);
		jp_input.add(cbSnum);
		jp_input.add(lb4);
		jp_input.add(cbDate);
		
		
		jp_btn.add(btnAdd);
		jp_btn.add(btnUpd);
		jp_btn.add(btnDel);
		jp_btn.add(btnPri);
		
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_btn, BorderLayout.SOUTH);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
	
		
		
	}
	private void listbDate() {
		// TODO Auto-generated method stub
	//	Date today = new Date();
	//	int year = today.getYear()+1900;
	//	int month = today.getMonth()+1;
	//	int date = today.getDate();
		
		for(int i=0;i<7;i++)
		{
	//		vDate.add(new Date(year, month, date));
	//		date++;
		}
		
	}
	private void listName() {
		// TODO Auto-generated method stub
		String sql = "select cnum, cname from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				vCname.add(rs.getString(2));
				mapc.put(rs.getString(2), rs.getInt(1));
			}
			cbCname.updateUI();
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	private void listTitle() {
		// TODO Auto-generated method stub
		String sql = "select tnum, mtitle from theater";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next())
			{
				vTitle.add(rs.getString(2));
				mapt.put(rs.getNString(2), rs.getInt(1));
			}	
			cbTitle.updateUI();
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public int getSeatCount(int tnum)
	{
		int b = 0;
		String sql = "select scapacity from theater where tnum = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tnum);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				b = rs.getInt(1);
				
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
		return b;
	}

}
