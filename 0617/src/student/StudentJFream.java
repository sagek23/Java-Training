package student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentJFream extends JFrame {
	JLabel lb00, lb01, lb02, lb03, lb04;
	JTextField tfNum, tfName, tfKor, tfEng, tfMath;
	JButton btnAdd, btnRead;
	JTable table;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	StudentInsert si = new StudentInsert();
	StudentPrint sp = new StudentPrint();
	
	public StudentJFream() {
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		setTitle("학생 정보 등록");
		
		colNames.add("번호");
		colNames.add("이름");
		colNames.add("국어");
		colNames.add("영어");
		colNames.add("수학");
		colNames.add("평균");
		
		lb00 = new JLabel("번호");
		lb01 = new JLabel("이름");
		lb02 = new JLabel("국어");
		lb03 = new JLabel("영어");
		lb04 = new JLabel("수학");
		
		tfNum = new JTextField(10);
		tfName = new JTextField(10);
		tfKor = new JTextField(10);
		tfEng = new JTextField(10);
		tfMath = new JTextField(10);
		
		btnAdd = new JButton("등록");
		btnRead = new JButton("출력");
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		setLayout(new BorderLayout());
		
		JPanel up = new JPanel();
		up.setLayout(new FlowLayout());
		
		up.add(lb00);
		up.add(tfNum);
		
		up.add(lb01);
		up.add(tfName);
		
		up.add(lb02);
		up.add(tfKor);
		
		up.add(lb03);
		up.add(tfEng);
		
		up.add(lb04);
		up.add(tfMath);
		
		up.add(btnAdd);
		up.add(btnRead);
		
		add(up, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);

		btnAdd.addActionListener(si);
		btnRead.addActionListener(sp);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}