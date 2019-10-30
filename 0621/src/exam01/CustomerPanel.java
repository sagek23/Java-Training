package exam01;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class CustomerPanel extends JPanel {

OrdersPanelMap o;
	
JTextField tf_cName;
JTextField tf_cAddr;
JTextField tf_cTel;
int cNum =0;

Vector<String> colNames;
Vector<Vector<String>> rowData;

JTable table;


public CustomerPanel(OrdersPanelMap o) {
	
	setLayout(new FlowLayout());
	add(new JButton("������"));
	
	tf_cName= new JTextField(10);
	tf_cAddr = new JTextField(10);
	tf_cTel = new JTextField(10);
	
	
	
	colNames = new Vector<String>();
	rowData = new Vector<Vector<String>>();
	
	colNames.add("����ȣ");
	colNames.add("���̸�");
	colNames.add("���ּ�");
	colNames.add("����ȭ");
	
	table = new JTable(rowData,colNames);
	table.addMouseListener(new MouseListener() {
		
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
            int row = table.getSelectedRow();
            Vector<String> v= rowData.get(row);
            //[21, �ų��� �ڹ�, 25000, ���, ���]
            tf_cName.setText(v.get(1));
            tf_cAddr.setText(v.get(2));
            tf_cTel.setText(v.get(3));
            cNum =  Integer.parseInt(v.get(0));
        }
    });
			
	
	JScrollPane jsp = new JScrollPane(table);
	
	
	setLayout(new BorderLayout());
	JPanel up = new JPanel();
	JPanel up_input = new JPanel();
	JPanel up_btn = new JPanel();
	
	up_input.setLayout(new GridLayout(3,2));
	up_btn.setLayout(new FlowLayout());
	up.setLayout(new BorderLayout());
	
	up_input.add(new JLabel("���̸�:"));
	up_input.add(tf_cName);

	up_input.add(new JLabel("���ּ�:"));
	up_input.add(tf_cAddr);
	

	up_input.add(new JLabel("����ȭ:"));
	up_input.add(tf_cTel);
	
	
	
	JButton btnAdd = new JButton("���");
	JButton btnUpdate = new JButton("����");
	JButton btnDelete = new JButton("����");
	JButton btnWrite = new JButton("���");

	btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			  insertBook();
              listBook();
		}
	});
	


	btnUpdate.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			updateBook();
			listBook();
		}
	});

	
	

	btnDelete.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			deleteBook();
			listBook();
		}
	});

	
	

	btnWrite.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			listBook();
		}
	});

			
	up_btn.add(btnAdd);
	up_btn.add(btnUpdate);
	up_btn.add(btnDelete);
	up_btn.add(btnWrite);
	
	up.add(up_input, BorderLayout.CENTER);
	up.add(up_btn, BorderLayout.SOUTH);
	
	add(up, BorderLayout.NORTH);
	add(jsp, BorderLayout.CENTER);
    

    //setSize(400, 300);
    //setVisible(true);
			
	// TODO Auto-generated constructor stub
}


protected void listBook() {
	// TODO Auto-generated method stub
	rowData.clear();
	 String sql = "select * from customer";
        try {           
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                Vector<String> v= new Vector<String>();
                v.add(rs.getInt(1)+"");
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                
                rowData.add(v);
            }
             
            table.updateUI();
             
            ConnectionProvider.close(conn, stmt, rs);
             
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }       
         
    }




protected void updateBook() {
	// TODO Auto-generated method stub
	

	String sql = "update customer set cName = ?, cAddr = ?, cTel = ? where cNum= ?";

	 if(!isAllInput())
        {
            JOptionPane.showMessageDialog(this, "�Է°��� Ȯ���ϼ���");
            clearText();
            return;
        }
			
	String cName = tf_cName.getText();
	String cAddr = tf_cAddr.getText();
	String cTel = tf_cTel.getText();
		
			
			
			
	try {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cName);
		pstmt.setString(2, cAddr);
		pstmt.setString(3, cTel);
		pstmt.setInt(4, cNum);
		
		int re = pstmt.executeUpdate();
		if(re>=1) {
			JOptionPane.showMessageDialog(this, "�������� �����Ͽ����ϴ�");
		}
		else {
			JOptionPane.showMessageDialog(this, "������������ �����Ͽ����ϴ�");
		}
		
		conn.close();
		pstmt.close();
		
		
		}catch (Exception e) {
		// TODO: handle exception
		System.out.println("���ܹ߻�: "+e.getMessage());
		}		
}


protected void deleteBook() {
	// TODO Auto-generated method stub
	
int r = JOptionPane.showConfirmDialog(this, "������ �����Ͻðڽ��ϱ�?");	
if(r !=0)
	return;

String sql = "delete customer where cNum = ?";
System.out.println("����");
System.out.println("å��ȣ:"+cNum);
try {
	Connection conn = ConnectionProvider.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, cNum);
	int re = pstmt.executeUpdate();
	
	if(re >=1) {
		JOptionPane.showMessageDialog(this, "������ �����Ͽ����ϴ�");
	}
	else {
		JOptionPane.showMessageDialog(this, "���������� �����Ͽ����ϴ�");
	}
	
	ConnectionProvider.close(conn, pstmt);
} catch (Exception e) {
	// TODO: handle exception
System.out.println(e.getMessage());
}


}


protected void insertBook() {
	// TODO Auto-generated method stub
	
	if(!isAllInput()) {
		JOptionPane.showMessageDialog(this, "�Է°��� Ȯ���ϼ���");
		clearText();
		return;
	}
	
	String cName = tf_cName.getText();
	String cAddr = tf_cAddr.getText();
	String cTel = tf_cTel.getText();
			
	String sql ="insert into customer values(seq_customer.nextval,?,?,?)";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cName);
				//int�� ��ȯ�Ȱ� �־��ִ� ����
				pstmt.setString(2, cAddr);
				pstmt.setString(3, cTel);
				
				int re = pstmt.executeUpdate();
				if(re>=1) {
					JOptionPane.showMessageDialog(this, "���� ����Ͽ����ϴ�");
				}
				else {
					JOptionPane.showMessageDialog(this, "����Ͽ� �����Ͽ����ϴ�");
				}
				
				ConnectionProvider.close(conn, pstmt);
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("���ܹ߻�: "+e.getMessage());
			}
			
			clearText();
			o.listCustomerno();
}


private boolean isAllInput() {
	// TODO Auto-generated method stub
	
	boolean f = true;
	if(tf_cName.getText().trim().equals("")||
	   tf_cAddr.getText().trim().equals("")||
	   tf_cTel.getText().trim().equals("")
	   ) {
		f =false;
	}
	return f;
}


private void clearText() {
	// TODO Auto-generated method stub
	tf_cName.setText("");
	tf_cAddr.setText("");
	tf_cTel.setText("");
	}





}


