package bbs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import member.memberDao;
import member.memberLogOnFrame;
import member.memberVo;

public class BbsFrame extends JFrame {
	//0,1,2���ٴ� ���� ���������� ���α׷��ϱ� ���� �̿����� ����� �����
	public static final int  LIST_ALL = 0;
	public static final int  LIST_MINE = 1;
	public static final int  LIST_TOP = 2;
	public static final int  LIST_SEARCH = 3;
	String sort="";
	ArrayList<BbsVo> list;
	String arr[] = {"�ۼ���","����","����"};
	HashMap<String, String> search;
	int listMode =0;
	public String id ="";
	int view;
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	
	int num;
	String pwd="";
	
	public JTextField tfTitle;
	public JTextField tfWriter;
	public JTextField tfPwd;
	public JTextArea tfContent;
	public JComboBox<String> cblist;
	public JTextField tfSearch;
	
	BbsDao dao =new BbsDao();
	BbsVo vo = new BbsVo();
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	
	public JTable jt;
	
	Vector<String> colNames;
	public Vector<Vector<String>> rowData;
	
	
	public BbsFrame()
	{
		lb1 = new JLabel("����");
		lb2 = new JLabel("�ۼ���");
		lb3 = new JLabel("�н�����");
		lb4 = new JLabel("����");
	
		
		
		cblist = new JComboBox<String>(arr);
		search = new HashMap<String, String>();
		search.put("�ۼ���", "writer");
		search.put("����", "title");
		search.put("����", "content");
		tfSearch = new JTextField(10);
		
		
		tfTitle = new JTextField(15);
		tfWriter = new JTextField(10);
		tfPwd = new JTextField(10);
		tfContent = new JTextArea(10,5);
		tfWriter.setEditable(false);
		btn8 = new JButton("�˻�");
		
		btn1 = new JButton("���");
		btn2 = new JButton("����");
		btn3 = new JButton("����");
		btn4 = new JButton("����");
		btn5 = new JButton("��κ���");
		btn6 = new JButton("TOP2");
		btn7 = new JButton("����");
	
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		colNames.add("��ȣ");
		colNames.add("����");
		colNames.add("�ۼ���");
		//colNames.add("�н�����");
		//colNames.add("����");
		colNames.add("��ȸ��");
		colNames.add("�ۼ���");
		
		jt= new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		
		JPanel jp = new JPanel();
		JPanel jp_btn = new JPanel();
		JPanel jp_content = new JPanel();
		JPanel jp_search = new JPanel();
		
		setLayout(new BorderLayout());
		jp.setLayout(new GridLayout(4,2));
		jp.add(lb1);
		jp.add(tfTitle);
		
		jp.add(lb2);
		jp.add(tfWriter);
		
		jp.add(lb3);
		jp.add(tfPwd);
		
		jp.add(lb4);
		
		JPanel jpsb = new JPanel();
		jp_btn.setLayout(new FlowLayout());
		jp_btn.add(btn7);
		jp_btn.add(btn1);
		jp_btn.add(btn2);
		jp_btn.add(btn3);
		jp_btn.add(btn4);
		jp_btn.add(btn5);
		jp_btn.add(btn6);
		
		jpsb.add(jp_btn);
		jpsb.add(jp_search);
		
		jpsb.setLayout(new GridLayout(2,2));
		jp_content.setLayout(new BorderLayout());
		
		jp_search.setLayout(new FlowLayout());
		jp_search.add(cblist);
		jp_search.add(tfSearch);
		jp_search.add(btn8);
		
		jp_content.add(tfContent, BorderLayout.CENTER);
		jp_content.add(jp, BorderLayout.NORTH);
	//	jp_content.add(jp_btn, BorderLayout.SOUTH);
		jp_content.add(jpsb, BorderLayout.SOUTH);
		JScrollPane jsp2 = new JScrollPane(jp_content);
		//add(jp_search, BorderLayout.SOUTH);
		
	
		add(jsp2, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
	
		setTitle("BBS");
		setVisible(true);
		setSize(650, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jt.getTableHeader().addMouseListener(new MouseListener() {
			
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
			Point point	= e.getPoint();
			int idx= jt.getTableHeader().columnAtPoint(point);
			System.out.println(idx);
			}
		});
		
		
		btn1.setEnabled(false);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if(tfContent.getText().trim().equals("")
				||tfPwd.getText().trim().equals("")||
				tfTitle.getText().trim().equals(""))
					
				{
					JOptionPane.showMessageDialog(null, "������ �Է��Ͻÿ�");
					clearText();
					return;
				}
				
				
				
				
				vo.setTitle(tfTitle.getText());
				vo.setWriter(tfWriter.getText());
				vo.setPwd(tfPwd.getText());
				vo.setContent(tfContent.getText());
		
				
				int re = dao.bbsWrite(vo);
				
				if(re==1)
					JOptionPane.showMessageDialog(null, "��ϼ���");
				else
					JOptionPane.showMessageDialog(null, "��Ͻ���");
				
				btn1.setEnabled(false);
				listAll();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfContent.getText().trim().equals("")
					||tfPwd.getText().trim().equals("")||
					tfTitle.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "������ �Է��Ͻÿ�");
						clearText();
						return;
					}
				
				
			vo.setNum(num);
			vo.setTitle(tfTitle.getText());
			vo.setContent(tfContent.getText());
			vo.setPwd(tfPwd.getText());
				
				int re = dao.bbsUpdate(vo);
				if(re==1)
				{
					JOptionPane.showMessageDialog(null, "��������");
					listAll();
				}
				else
					JOptionPane.showMessageDialog(null, "��������");
			}
		});
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pwd = tfPwd.getText();
				dao.deleteBbs(num, pwd);
				listAll();
				//listMine();
				clearText();
			
				
			}
		});
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listMine();
				//listMode = 1;
				listMode = LIST_MINE;
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listAll();
				//listMode = 0;
				listMode = LIST_ALL; 
			}
		});
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listTop();
				//listMode = 2;
				listMode = LIST_TOP;
			}
		});
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newUpload();
				btn1.setEnabled(true);
			}
		});
		btn8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listSearch();
				
				listMode = LIST_SEARCH;
			}
		});
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
				
				try {
					int row = jt.getSelectedRow();
					BbsVo v = list.get(row);
					
					tfTitle.setText(v.getTitle());
					//tfWriter.setText(v.getWriter());
					tfContent.setText(v.getContent());
					//tfPwd.setText(v.getPwd());
					num = v.getNum();
				
					dao.updateView(num);//��ȸ�� ����
					//listAll();
					
					switch (listMode) {
					case LIST_ALL:listAll();break;
					case LIST_MINE:listMine();break;
					case LIST_TOP:listTop();break;
					case LIST_SEARCH:listSearch();break;
					}
					
						if(v.getWriter().equals(id))
						{
							btn2.setEnabled(true);
							btn3.setEnabled(true);
						}
						else
						{
							btn2.setEnabled(false);
							btn3.setEnabled(false);
						}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
				
			}
		});
	}
	
	private void listAll() {
		// TODO Auto-generated method stub
		rowData.clear();
		list =	dao.listAll();
		for(BbsVo vo:list)
		{
			Vector<String> v2 = new Vector<String>();
			v2.add(vo.getNum()+"");
			v2.add(vo.getTitle());
			v2.add(vo.getWriter());
		//	v2.add(vo.getPwd());
			//v2.add(vo.getContent());
			v2.add(vo.getViews()+"");
			v2.add(vo.getCreDate()+"");
			rowData.add(v2);
		}
		jt.updateUI();
	
	}
	
	private void listMine() {
		// TODO Auto-generated method stub
		rowData.clear();
		list =	dao.listMine(id);
		for(BbsVo b:list)
		{
			Vector<String> v = new Vector<String>();
			v.add(b.getNum()+"");
			v.add(b.getTitle());
			v.add(b.getWriter());
		//	v.add(b.getPwd());
			//v.add(b.getContent());
			v.add(b.getViews()+"");
			v.add(b.getCreDate()+"");
			rowData.add(v);
		}
		jt.updateUI();
		
	}
	private void listTop() {
		// TODO Auto-generated method stub
		rowData.clear();
		list =	dao.listTop(view);
		for(BbsVo vo:list)
		{
			Vector<String> v2 = new Vector<String>();
			v2.add(vo.getNum()+"");
			v2.add(vo.getTitle());
			v2.add(vo.getWriter());
		//	v2.add(vo.getPwd());
			//v2.add(vo.getContent());
			v2.add(vo.getViews()+"");
			v2.add(vo.getCreDate()+"");
			rowData.add(v2);
		}
		jt.updateUI();
	
	}
	private void listSearch() {
		// TODO Auto-generated method stub
		String key = cblist.getSelectedItem().toString();
		String colName = search.get(key);
		String search = tfSearch.getText();
		list = dao.listSearch(colName, search);
		
		rowData.clear();
		
		for(BbsVo vo:list)
		{
			Vector<String> v2 = new Vector<String>();
			v2.add(vo.getNum()+"");
			v2.add(vo.getTitle());
			v2.add(vo.getWriter());
		//	v2.add(vo.getPwd());
			//v2.add(vo.getContent());
			v2.add(vo.getViews()+"");
			v2.add(vo.getCreDate()+"");
			rowData.add(v2);
		}
		jt.updateUI();
	
	}
	private void listBbs() {
		// TODO Auto-generated method stub
		rowData.clear();
		list =	dao.listOrder(sort);
		for(BbsVo vo:list)
		{
			Vector<String> v2 = new Vector<String>();
			v2.add(vo.getNum()+"");
			v2.add(vo.getTitle());
			v2.add(vo.getWriter());
		//	v2.add(vo.getPwd());
			//v2.add(vo.getContent());
			v2.add(vo.getViews()+"");
			v2.add(vo.getCreDate()+"");
			rowData.add(v2);
		}
		jt.updateUI();
	
	}
	public void newUpload()
	{
		
		tfTitle.setText("");
		tfPwd.setText("");
		tfWriter.setText(id);
		tfContent.setText("");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BbsFrame();
	}
	public void clearText()
	{
		tfTitle.setText("");
		tfPwd.setText("");
		tfWriter.setText("");
		tfContent.setText("");
	
	}
}
