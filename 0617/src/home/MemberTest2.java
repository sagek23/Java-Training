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

 
public class MemberTest2 extends JFrame implements ActionListener {
 
    JLabel lb01,lb02;
    JTextField tfName, tfAge;
    JButton btnAdd; 
    JTable table;
    
    Vector<Vector<String>> rowData;
    Vector<String> colNames;
    JButton btnRead;
    JPanel newpanel; 
    
    boolean flag; 
     
    MemberTest2()
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
       // newpanel.setPreferredSize(new Dimension(500,400));
            
        add(lb01);      
        add(tfName);
        add(lb02);
        add(tfAge);
        add(btnAdd);
        add(btnRead);
        
        
        add(newpanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        btnAdd.addActionListener(this);
        btnRead.addActionListener(this);
         
    }
     
    public void actionPerformed(ActionEvent e) {
    	String cmd  = e.getActionCommand();
    	System.out.println(cmd);
    	if(cmd.equals("�߰�"))
    	{
    		System.out.println("�߰��� �Ͽ����ϴ�.");
    	}
    	else
    	{
    		System.out.println("�о���⸦ �Ͽ����ϴ�.");
    	}
    }
     
    public static void main(String []arg)
    {	
    	MemberTest2 m = new MemberTest2();
        m.setSize(550, 600);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
 
}