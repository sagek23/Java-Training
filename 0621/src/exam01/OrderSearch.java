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
   
    //한번에 버튼 하나만 선택되는 것 구현하려고
    ButtonGroup bg;
     
    JTextField tf_keyword;
     
    Vector<String> colNames;
    Vector<Vector<String>> rowData;
    JTable table;
    
    String fieldName;
        
     
    public OrderSearch() {
        rb_cName = new JRadioButton("고객명");
        rb_bName = new JRadioButton("도서명");
        rb_pub = new JRadioButton("출판사");
        
        
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
         
        colNames.add("주문번호");
        colNames.add("도서번호");
        colNames.add("도서명");
        colNames.add("고객명");
        colNames.add("주소");
        colNames.add("전화");
        colNames.add("출판사");
        colNames.add("수량");
        colNames.add("금액");
        colNames.add("구매일");
         
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
         
        JButton btnSearch = new JButton("검색");
        up.add(btnSearch);
        
        
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				search();
				
				
//				String keyword = tf_keyword.getText();
//				System.out.println("검색항목:"+fieldName);
//				System.out.println("검색어:"+keyword);
			}
        });
        
        add(up, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
    }
    



	protected void search() {
		// TODO Auto-generated method stub
		//새로운 검색이 적용
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