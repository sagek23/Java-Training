package home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 
public class MemberTest extends JFrame implements ActionListener {
 
    JLabel lb01,lb02;
    JTextField tfName, tfAge;
    JButton btnAdd; 
    JTable table;
    
    Vector<Vector<String>> rowData;
    Vector<String> colNames;
    JButton btnRead;
    JPanel newpanel; 
    
    boolean flag; 
     
    MemberTest()
    {
    	
        setLayout(new FlowLayout());
        setTitle("ȸ�����");
        lb01 = new JLabel("�̸�:");
        lb02 = new JLabel("����:");
        tfName = new JTextField(10);
        tfAge = new JTextField(10);
        btnAdd = new JButton("�߰�");
        newpanel = new JPanel(); 
        
        newpanel.setLayout(new BorderLayout());
        btnRead = new JButton("�о����");
        rowData = new Vector<Vector<String>>();
        colNames = new Vector<String>();
         
        colNames.add("�̸�");
        colNames.add("����");
        
        table = new JTable(rowData, colNames);
        JScrollPane jsp = new JScrollPane(table);
        
        newpanel.add(jsp, BorderLayout.CENTER);     
        newpanel.setPreferredSize(new Dimension(500,400));
            
        add(lb01);      
        add(tfName);
        add(lb02);
        add(tfAge);
        add(btnAdd);
        add(newpanel);
         
        //�߰� ��ư 
        btnAdd.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok");
			
				
				String name = tfName.getText();
		        int age = Integer.parseInt(tfAge.getText());
		        String sql  = "insert into member values('"+name+"',"+age+")";
		         
		        try {
		             
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.91:1521:XE", "c##bit1234", "bit1234");
		            Statement stmt = conn.createStatement();
		            int re = stmt.executeUpdate(sql);                       
		            if(re >= 1)
		            {
		                System.out.println("ȸ���� ����Ͽ����ϴ�.");
		            }
		            else
		            {
		                System.out.println("��Ͽ� �����Ͽ����ϴ�.");
		            }
		            stmt.close();
		            conn.close();
		                     
		             
		        }catch (Exception ex) {
		            System.out.println(ex.getMessage());
		        }
		        
		        if(flag == false) { 
		        	flag = true; 
		        	newpanel.add(btnRead, BorderLayout.SOUTH); 
		        }				
		        
		        newpanel.validate();
		       
		        
			}
		});
        
       
        
        
        
        // �о���� ��ư
        btnRead.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from member";        
		        try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection conn = 
		                    DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.91:1521:XE", "c##bit1234", "bit1234");
		            Statement stmt = conn.createStatement();
		             
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            rowData.clear();
		            
		            while(rs.next())
		            {
		                Vector<String> v= new Vector<String>();
		                v.add(rs.getString(1));
		                v.add(rs.getInt(2)+"");
		                rowData.add(v);
		            }
		             
		            rs.close();
		            stmt.close();
		            conn.close();
		             
		            table.updateUI();
		             
		        }catch (Exception ex) {
		            System.out.println(ex.getMessage());
		        }
				
			}
		} );
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
         
    }
     
    public void actionPerformed(ActionEvent e) {
        
    }
     
    public static void main(String []arg)
    {
    	//System.out.println("ok");    	
    	
    	MemberTest m = new MemberTest();
        m.setSize(550, 600);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
 
}