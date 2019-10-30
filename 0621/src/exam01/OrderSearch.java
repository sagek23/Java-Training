package exam01;
 
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import db.ConnectionProvider;
 
public class OrderSearch extends JPanel {
    JRadioButton rb_cName;
    JRadioButton rb_bName;
    JRadioButton rb_pub;
   
    //�ѹ��� ��ư �ϳ��� ���õǴ� �� �����Ϸ���
    ButtonGroup bg;
     
    JTextField tf_keyword;
     
    Vector<String> colNames;
    Vector<Vector<String>> rowData;
    JTable table;
    
    String fieldName;
        
     
    public OrderSearch() {
        rb_cName = new JRadioButton("����");
        rb_bName = new JRadioButton("������");
        rb_pub = new JRadioButton("���ǻ�");
        
        
        rb_bName.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                fieldName = "bName";
            }
        });
        rb_cName.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                fieldName = "cName";
            }
        });
        rb_pub.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                fieldName = "pub";
            }
        });
                  
        bg = new ButtonGroup();
        
        bg.add(rb_bName);
        bg.add(rb_cName);
        bg.add(rb_pub);
       
                      
         
        tf_keyword = new JTextField(10);
         
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
        colNames.add("������");
         
        table = new JTable(rowData, colNames);
        JScrollPane jsp = new JScrollPane(table);
        
        search();
         
        setLayout(new BorderLayout());
        JPanel up = new JPanel();
        up.setLayout(new FlowLayout());
        up.add(rb_cName);
        up.add(rb_bName);
        up.add(rb_pub);
        up.add(tf_keyword);
         
        JButton btnSearch = new JButton("�˻�");
        up.add(btnSearch);
        
        
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				search();
				
				
//				String keyword = tf_keyword.getText();
//				System.out.println("�˻��׸�:"+fieldName);
//				System.out.println("�˻���:"+keyword);
			}
        });
        
        add(up, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
    }
    



	protected void search() {
		// TODO Auto-generated method stub
		//���ο� �˻��� ����
	rowData.clear();
	String keyword=tf_keyword.getText();
	String sql = "select oNum,b.bNum,bName,cName, cAddr, cTel,bPub, oQuantity, oPrice, oDate from customer c, book b, orders o where c.cNum= o.cNum and b.bNum=o.bNum";
	if(!keyword.trim().equals("")){
		sql ="select oNum,b.bNum,bName,cName, cAddr, cTel,bPub, oQuantity, oPrice, oDate from customer c, book b, orders o where c.cNum =o.cNum and b.bNum=o.bNum and "+fieldName+" =?";
	}
	
	try {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt =conn.prepareStatement(sql);
		
		if(!keyword.trim().equals("")){
		pstmt.setString(1, keyword);
		}
		
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
	} catch (Exception e) {
		// TODO: handle exception
	System.out.println(e.getMessage());
	}
	
	}
}