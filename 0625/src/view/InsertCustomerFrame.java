package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;import javax.swing.plaf.basic.BasicOptionPaneUI;

import Connection.ConnectionProvider;
import Dao.CustomerDao;
import vo.CustomerVo;

public class InsertCustomerFrame extends JFrame {

	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	
	JTextField tfName;
	JTextField tfAddr;
	JTextField tfPhone;
	
	JButton btn;
	//JTable jt;
	
	public InsertCustomerFrame()
	{
		lb1 = new JLabel("이름");
		lb2 = new JLabel("주소");
		lb3 = new JLabel("전화");
		
		tfName = new JTextField(10);
		tfAddr = new JTextField(10);
		tfPhone = new JTextField(10);
		
		btn = new JButton("등록");
		
		JPanel jp  = new JPanel();
		
		jp.setLayout(new GridLayout(3, 2));
		jp.add(lb1);
		jp.add(tfName);
		jp.add(lb2);
		jp.add(tfAddr);
		jp.add(lb3);
		jp.add(tfPhone);
		
		setLayout(new BorderLayout());
		add(jp, BorderLayout.CENTER);
		
		add(btn, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CustomerVo vo = new CustomerVo();
				CustomerDao dao = new CustomerDao();
				
				vo.setName(tfName.getText());
				vo.setAddress(tfAddr.getText());
				vo.setPhone(tfPhone.getText());
				
				
				int re = dao.insertCustomer(vo);
				if (re>0)
					JOptionPane.showMessageDialog(null, "회원등록성공");
				else
					JOptionPane.showMessageDialog(null, "회원등록실패");
				
				
			}
		});
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String []args)
	{
		new InsertCustomerFrame();
	}
}
