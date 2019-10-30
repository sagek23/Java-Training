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
		
		setTitle("�л� ���� ���");
		
		colNames.add("��ȣ");
		colNames.add("�̸�");
		colNames.add("����");
		colNames.add("����");
		colNames.add("����");
		colNames.add("���");
		
		lb00 = new JLabel("��ȣ");
		lb01 = new JLabel("�̸�");
		lb02 = new JLabel("����");
		lb03 = new JLabel("����");
		lb04 = new JLabel("����");
		
		tfNum = new JTextField(10);
		tfName = new JTextField(10);
		tfKor = new JTextField(10);
		tfEng = new JTextField(10);
		tfMath = new JTextField(10);
		
		btnAdd = new JButton("���");
		btnRead = new JButton("���");
		
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