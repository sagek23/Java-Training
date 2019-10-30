package empFrame;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Dao.EmpDao;
import Vo.EmpVo;

public class EmpFrame extends JFrame {
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTable jt;
	
	public EmpFrame()
	{
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colNames.add("�����ȣ");
		colNames.add("�����");
		colNames.add("�ּ�");
		colNames.add("�޿�");
		colNames.add("����");
		colNames.add("��å");
		colNames.add("��ȭ");
		colNames.add("�Ի���");
		colNames.add("�����ڹ�ȣ");
		colNames.add("�μ���ȣ");
		colNames.add("�̸���");
		
		jt = new JTable(rowData, colNames);
		
		listEmp();
		
		JScrollPane jsp = new JScrollPane(jt);
		add(jsp);
		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void listEmp() {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		ArrayList<EmpVo> list = dao.listEmp();
		for(EmpVo v:list)
		{
			Vector<String> ve = new Vector<String>();
			ve.add(v.getEno()+"");
			ve.add(v.getEname());
			ve.add(v.getAddr());
			ve.add(v.getSal()+"");
			ve.add(v.getComm()+"");
			ve.add(v.getJob());
			ve.add(v.getTel());
			ve.add(v.getHiredate()+"");
			ve.add(v.getMgr()+"");
			ve.add(v.getDno()+"");
			ve.add(v.getEmail());
			rowData.add(ve);
		}
		jt.updateUI();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 new EmpFrame();
	
	}

}
