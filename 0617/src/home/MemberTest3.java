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

 
public class MemberTest3 extends JFrame implements ActionListener {
 
    JLabel lb01,lb02;
    JTextField tfName, tfAge;
    JButton btnAdd; 
    JTable table;
    
    Vector<Vector<String>> rowData;
    Vector<String> colNames;
    JButton btnRead;
    JPanel newpanel; 
    
    boolean flag; 
     
    MemberTest3()
    {
    	
        setLayout(new BorderLayout());
        
        setTitle("회원등록");
        lb01 = new JLabel("이름:");
        lb02 = new JLabel("나이:");
        tfName = new JTextField(10);
        tfAge = new JTextField(10);
        btnAdd = new JButton("추가");
        newpanel = new JPanel(); 
        
        //newpanel.setLayout(new FlowLayout());
        btnRead = new JButton("읽어오기");
        rowData = new Vector<Vector<String>>();
        colNames = new Vector<String>();
         
        colNames.add("이름");
        colNames.add("나이");
        
        table = new JTable(rowData, colNames);
        JScrollPane jsp = new JScrollPane(table);
        
        
        
        newpanel.add(lb01);      
        newpanel.add(tfName);
        newpanel.add(lb02);
        newpanel.add(tfAge);
        newpanel.add(btnAdd);
        
        add(newpanel, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         
    }
     
    public void actionPerformed(ActionEvent e) {
        
    }
     
    public static void main(String []arg)
    {	
    	MemberTest3 m = new MemberTest3();
        m.setSize(550, 600);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
 
}