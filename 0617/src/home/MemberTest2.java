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
        
        setTitle("회원등록");
        lb01 = new JLabel("이름:");
        lb02 = new JLabel("나이:");
        tfName = new JTextField(10);
        tfAge = new JTextField(10);
        btnAdd = new JButton("추가");
        newpanel = new JPanel(); 
        
        newpanel.setLayout(new BorderLayout());
        btnRead = new JButton("읽어오기");
        rowData = new Vector<Vector<String>>();
        colNames = new Vector<String>();
         
        colNames.add("이름");
        colNames.add("나이");
        
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
    	if(cmd.equals("추가"))
    	{
    		System.out.println("추가를 하였습니다.");
    	}
    	else
    	{
    		System.out.println("읽어오기를 하였습니다.");
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