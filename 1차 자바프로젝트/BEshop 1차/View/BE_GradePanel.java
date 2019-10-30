package View;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BE_GradePanel extends JFrame {
	Vector<Vector<String>> rowData;
	Vector<String> colName;
	JTable table;
	public BE_GradePanel(){
		setLayout(new BorderLayout());
		
		rowData = new Vector<Vector<String>>();
		colName = new Vector<String>();
		
		colName.add("등급번호");
		colName.add("등급");
		colName.add("등급혜택");
		colName.add("구매횟수");
		
		table = new JTable(rowData, colName);
		
		JButton btn = new JButton("조회");
		JScrollPane jsp = new JScrollPane(table);
		add(new JLabel("회원등급"), BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600,500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BE_GradePanel();
	}
}

