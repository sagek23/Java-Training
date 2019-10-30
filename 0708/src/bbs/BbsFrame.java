package bbs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BbsFrame extends JFrame {

	int no;
	public String id = "";
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	BbsDao dao = new BbsDao();
	BbsVo vo = new BbsVo();
	ArrayList<BbsVo> list;
	public JTextField tfTitle;
	public JTextField tfWriter;
	public JTextField tfPwd;
	public JTextArea taContent;
	public JTextField tfView;
	
	JButton btnAdd;
	JButton btnUpd;
	JButton btnDel;
	JButton btnSea;
	
	JTable jt;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public BbsFrame()
	{
		list = new ArrayList<BbsVo>();
		lb1 = new JLabel("����");
		lb2 = new JLabel("�ۼ���");
		lb3 = new JLabel("�н�����");
		lb4 = new JLabel("����");
	
		
		tfTitle = new JTextField(15);
		tfWriter = new JTextField(15);
		tfPwd = new JTextField(15);
		taContent = new JTextArea(10,10);
		tfTitle = new JTextField(15);
		tfView = new JTextField(15);
		
		btnAdd = new JButton("���");
		btnUpd = new JButton("����");
		btnDel = new JButton("����");
		btnSea = new JButton("��ΰ˻�");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("��ȣ");
		colNames.add("����");
		colNames.add("�ۼ���");
		colNames.add("��ȸ��");
		colNames.add("�ۼ���");
		
		jt= new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		JPanel jp = new JPanel();
		JPanel jp_con = new JPanel();
		JPanel jp_btn = new JPanel();
		
		setLayout(new BorderLayout());
		jp.setLayout(new GridLayout(4,2));
		jp.add(lb1);
		jp.add(tfTitle);
		jp.add(lb2);
		jp.add(tfWriter);
		jp.add(lb3);
		jp.add(tfPwd);
		jp.add(lb4);
	
		
		
		jp_btn.setLayout(new FlowLayout());
		jp_btn.add(btnAdd);
		jp_btn.add(btnUpd);
		jp_btn.add(btnDel);
		jp_btn.add(btnSea);
		
		jp_con.add(taContent);
		jp_con.setLayout(new BorderLayout());
		jp_con.add(jp, BorderLayout.NORTH);
		jp_con.add(jp_btn, BorderLayout.SOUTH );
		jp_con.add(taContent, BorderLayout.CENTER);
		
		add(jp_con, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);

		setVisible(true);
		setSize(600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jt.addMouseListener(new MouseListener() {
			
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
				int row = jt.getSelectedRow();
				BbsVo v = list.get(row);
				try {
				tfTitle.setText(v.getTitle());
				taContent.setText(v.getContent());
				
				no = v.getNo();
				}catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage()+1);
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BbsDao dao =new BbsDao();
				BbsVo vo = new BbsVo();
			
				vo.setTitle(tfTitle.getText());
				vo.setWriter(tfWriter.getText());
				vo.setPwd(tfPwd.getText());
				vo.setContent(taContent.getText());
			
				
				int re = dao.bbsWrite(vo);
				if(re>0)
					JOptionPane.showMessageDialog(null, "��ϼ���");
				else
					JOptionPane.showMessageDialog(null, "��Ͻ���");
				
			}
		});
		
		btnUpd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BbsDao dao = new BbsDao();
				BbsVo vo = new BbsVo();
				
				vo.setTitle(tfTitle.getText());
				vo.setContent(taContent.getText());
				vo.setNo(no);
				vo.setPwd(tfPwd.getText());
				
				int re = dao.bbsUpd(vo);
				
				if(re==1)
					JOptionPane.showMessageDialog(null, "��������");
				else
					JOptionPane.showMessageDialog(null, "��������");
			}
			
		});
		btnSea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listS();
			}
		});
		
	}
	private void listS()
	{
		rowData.clear();
		list = dao.listSea();
		for(BbsVo vo:list)
		{
			Vector<String> v =new Vector<String>();
			v.add(vo.getNo()+"");
			v.add(vo.getTitle());
			v.add(vo.getWriter());
			//v.add(vo.getPwd());
			//v.add(vo.getContent());
			v.add(vo.getHit()+"");
			v.add(vo.getRegdate()+"");
			rowData.add(v);
		}
		
		jt.updateUI();
			
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BbsFrame();
	}

}
