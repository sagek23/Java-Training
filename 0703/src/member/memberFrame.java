package member;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class memberFrame extends JFrame {

	JLabel lb1;
	JLabel lb2;
	JLabel lb3;

	JTextField tfId;
	JTextField tfPwd;
	JTextField tfName;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable jt;
	JButton btnAdd;
	public memberFrame() {
		// TODO Auto-generated constructor stub
		
		lb1 = new JLabel("아이디");
		lb2 = new JLabel("패스워드");
		lb3 = new JLabel("이름");
		
		tfId = new JTextField(10);
		tfPwd = new JTextField(10);
		tfName = new JTextField(10);
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("아이디");
		colNames.add("패스워드");
		colNames.add("이름");
		
		btnAdd = new JButton("등록");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rowData.clear();
				
				memberVo vo = new memberVo();
				memberDao dao = new memberDao();
				
				vo.setId(tfId.getText());
				vo.setPwd(tfPwd.getText());
				vo.setName(tfName.getText());
				
				int re = dao.insertMember(vo);
				if(re>0)
					JOptionPane.showMessageDialog(null, "등록성공");
				else
					JOptionPane.showMessageDialog(null, "등록실패");
				jt.updateUI();
			}
		});
		
		jt = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(jt);
		setLayout(new BorderLayout());
		
		JPanel jp = new JPanel();
		JPanel jp_btn = new JPanel();
		
		jp.add(lb1);
		jp.add(tfId);
		jp.add(lb2);
		jp.add(tfPwd);
		jp.add(lb3);
		jp.add(tfName);
		
		jp.setLayout(new GridLayout(3,2));
		
		try {
			jp_btn.add(btnAdd);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		jp_btn.setLayout(new FlowLayout());
		
		
		add(jp, BorderLayout.NORTH);
		add(jp_btn, BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new memberFrame();
	}

}
