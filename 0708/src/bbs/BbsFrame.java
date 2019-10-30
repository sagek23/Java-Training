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
		lb1 = new JLabel("제목");
		lb2 = new JLabel("작성자");
		lb3 = new JLabel("패스워드");
		lb4 = new JLabel("내용");
	
		
		tfTitle = new JTextField(15);
		tfWriter = new JTextField(15);
		tfPwd = new JTextField(15);
		taContent = new JTextArea(10,10);
		tfTitle = new JTextField(15);
		tfView = new JTextField(15);
		
		btnAdd = new JButton("등록");
		btnUpd = new JButton("수정");
		btnDel = new JButton("삭제");
		btnSea = new JButton("모두검색");
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("번호");
		colNames.add("제목");
		colNames.add("작성자");
		colNames.add("조회수");
		colNames.add("작성일");
		
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
					JOptionPane.showMessageDialog(null, "등록성공");
				else
					JOptionPane.showMessageDialog(null, "등록실패");
				
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
					JOptionPane.showMessageDialog(null, "수정성공");
				else
					JOptionPane.showMessageDialog(null, "수정실패");
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
