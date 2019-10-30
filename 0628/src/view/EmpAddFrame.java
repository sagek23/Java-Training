package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Connection.ConnectionProvider;
import EmpAdd.AddVo;
import EmpAddD.AddDao;

public class EmpAddFrame extends JFrame {

	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	JLabel lb5;
	JLabel lb6;
	JLabel lb7;
	JLabel lb8;
	JLabel lb9;
	JLabel lb10;
	
	JTextField tfName;
	JTextField tfAddr;
	JTextField tfSal;
	JTextField tfComm;
	JTextField tfJob;
	JTextField tfTel;
	JTextField tfHiredate;
	JTextField tfMgr;
	JTextField tfEmail;
	JComboBox<Integer> cbDno;
	
	JButton btn;
	
	HashMap<Integer, String> mapA;
	Vector<Integer> vdno;
	int dno = 0;

	public EmpAddFrame() {
	
		lb1 = new JLabel("이름");
		lb2 = new JLabel("주소");
		lb3 = new JLabel("월급");
		lb4 = new JLabel("수당");
		lb5 = new JLabel("직위");
		lb6 = new JLabel("전화");
		lb7 = new JLabel("고용일");
		lb8 = new JLabel("관리자");
		lb9 = new JLabel("부서번호");
		lb10 = new JLabel("이메일");

		tfName = new JTextField(10);
		tfAddr = new JTextField(10);
		tfSal = new JTextField(10);
		tfComm = new JTextField(10);
		tfJob = new JTextField(10);
		tfTel = new JTextField(10);
		tfHiredate = new JTextField(10);
		tfMgr = new JTextField(10);
		tfEmail = new JTextField(10);
		
		vdno = new Vector<Integer>();
		
		mapA = new HashMap<Integer, String>();
		
		
		cbDno = new JComboBox<Integer>(vdno);
		
		cbDno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dno =(int)cbDno.getSelectedItem();
				//String dept = mapA.get(dno);
			}
		});
		
		
		
		
		btn = new JButton("등록");
		
		
		
		JPanel jp = new JPanel();
		
		setLayout(new BorderLayout());
		
		jp.setLayout(new GridLayout(10, 2));
		jp.add(lb1);
		jp.add(tfName);
		jp.add(lb2);
		jp.add(tfAddr);
		jp.add(lb3);
		jp.add(tfSal);
		jp.add(lb4);
		jp.add(tfComm);
		jp.add(lb5);
		jp.add(tfJob);
		jp.add(lb6);
		jp.add(tfTel);
		jp.add(lb7);
		jp.add(tfHiredate);
		jp.add(lb8);
		jp.add(tfMgr);
		jp.add(lb9);
		jp.add(cbDno);
		jp.add(lb10);
		jp.add(tfEmail);
		
		add(jp, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddVo vo = new AddVo();
				AddDao dao = new AddDao();
				dno = (int)cbDno.getSelectedItem();
				int sal = Integer.parseInt(tfSal.getText());
				int comm = Integer.parseInt(tfComm.getText());
				int mgr = Integer.parseInt(tfMgr.getText());
				//Date hiredate = 
				
				vo.seteName(tfName.getText());
				vo.setAddr(tfAddr.getText());
				vo.setSal(sal);
				vo.setComm(comm);
				vo.setJob(tfJob.getText());
				vo.setTel(tfTel.getText());
				vo.setStrHiredate(tfHiredate.getText());
				vo.setMgr(mgr);
				vo.setDno(dno);
				vo.setEmail(tfEmail.getText());
		
				
				int re = dao.insertDao(vo);
				if (re>0)
					System.out.println("사원등록성공");
				else
					System.out.println("사원등록실패");
			}
		});
		
		listDno();
		
		
		
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
 	}
	
	private void listDno() {
		// TODO Auto-generated method stub
		String sql = "select dno from dept";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				vdno.add(rs.getInt(1));
				//mapA.put(rs.getInt(1), rs.getString(2));
			}
			
			cbDno.updateUI();
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmpAddFrame();
	}

}
