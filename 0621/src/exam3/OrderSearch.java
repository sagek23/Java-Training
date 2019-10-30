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
		custoN = new JRadioButton("����");
		bookN = new JRadioButton("������");
		pubN = new JRadioButton("���ǻ��");
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
		//lb1 = new JLabel("����");
		//lb2 = new JLabel("������");
		//lb3 = new JLabel("���ǻ��");
		
		
		btn = new JButton("�˻�");
		tfSearch = new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("�ֹ���ȣ");
		colNames.add("������ȣ");
		colNames.add("������");
		colNames.add("����");
		colNames.add("�ּ�");
		colNames.add("��ȭ");
		colNames.add("���ǻ�");
		colNames.add("����");
		colNames.add("�ݾ�");
		colNames.add("��������");
		
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
		//��ü���
		String sql = "select onum, bnum, bname, cname, addr, tel, publisher, oquantity, oamount, odate  from customer c, book b, orders o where c.cnum = o.csnum and b.bnum = o.bknum";
		if(!keyword.trim().equals(""))
		{	//���� �˻�� �ִٸ� �Ʒ��� sql���� ���
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
