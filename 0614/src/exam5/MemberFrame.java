package exam5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberFrame extends JFrame implements ActionListener {

	JTable jt;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	
	MemberFrame()
	{
		rowData = new Vector<Vector<String>>();
		colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("나이");
		Vector<String> v1= new Vector<String>();
		v1.add("이재우");
		v1.add("31");
		rowData.add(v1);
		Vector<String> v2= new Vector<String>();
		v2.add("김슬지");
		v2.add("29");
		rowData.add(v2);
		jt = new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(jt);
		add(jsp);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
