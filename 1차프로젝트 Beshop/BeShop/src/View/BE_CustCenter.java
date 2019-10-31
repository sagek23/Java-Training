package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BE_AdminDao.BE_CqnaDao;
import BE_AdminVo.BE_CqnaVo;
import BE_ShoppingDao.BE_CategoryDao;

public class BE_CustCenter extends JPanel{
	JPanel westP,CenterP;							//?��?��?�� ?��?�� ?��?�� 
	JPanel WPG,WPP,WPGLP,WPGRP,WPPLP,WPPRP;			//구매�??��?��,?��매�??��?��
	JPanel CPNorth,CPSouth,CPNPN,CPNPS,CPSP;		//�??��?��?��?��?��?��
	JLabel custL;
	JTabbedPane WPTab;
	JComboBox cb;
	JTextField jtf;
	JButton btnS,btnNext,btnPrev;
	
	JButton btnCG[];
	JButton btnCG_btn[];
	
	// 게시?�� view
	JTable jt;
	Vector<String> mainData;
	Vector<Vector<String>> rowData;
	BE_CategoryDao BCgao;
	BE_CqnaDao BCao;
	int srt=0,end=10 ,page=1;						//개시판 번호 초기화 0~9 까지 게시물
	JTextField pageTF;
	public BE_CustCenter(){
		BCgao = new BE_CategoryDao();
		BCao = new BE_CqnaDao();
		westP = new JPanel();
		CenterP = new JPanel();
		custL = new JLabel("고객센터");
		CPNorth = new JPanel();
		CPSouth = new JPanel();
		CPSP = new JPanel();
		btnCG = new JButton[BCgao.getBigName().size()];
		
		// ?���? view
		// 구매�??��,?��매�??�� ??.?�� 카테고리 
		
		WPTab = new JTabbedPane();
		WPG = new JPanel();
		WPG.setLayout(new BorderLayout());
		WPP = new JPanel();
		WPGLP = new JPanel();
		WPGLP.setLayout(new BoxLayout(WPGLP, BoxLayout.Y_AXIS));
		WPGRP = new JPanel();
		WPGRP.setLayout(new BoxLayout(WPGRP, BoxLayout.Y_AXIS));
		WPPLP = new JPanel();
		WPPLP.setLayout(new BoxLayout(WPPLP, BoxLayout.Y_AXIS));
		WPPRP = new JPanel();
		WPPRP.setLayout(new BoxLayout(WPPRP, BoxLayout.Y_AXIS));
		WPG.add(WPGLP,BorderLayout.WEST);
		WPG.add(WPGRP,BorderLayout.EAST);
		WPP.add(WPPLP,BorderLayout.WEST);
		WPP.add(WPPRP,BorderLayout.EAST);
		
		ArrayList<String> list = BCgao.getBigName();
		for (int i=0; i<list.size(); i++) {
			btnCG[i] = new JButton(list.get(i));
			btnCG[i].setContentAreaFilled(false);	//버튼 배경 ?��?��
			btnCG[i].setFocusPainted(false);		//버튼 ?��?��?��?��?��?�� ?��기는 ?��?���? ?��?��?��?��
			btnCG[i].setOpaque(false);
			WPGLP.add(btnCG[i]);
			
			btnCG[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					WPGRP.removeAll();
					ArrayList<String> al = BCgao.getSMName(e.getActionCommand());
					for (int j = 0; j < al.size(); j++) {
						btnCG_btn = new JButton[BCgao.getSMName(e.getActionCommand()).size()];
						btnCG_btn[j] = new JButton(al.get(j));
						btnCG_btn[j].setContentAreaFilled(false);	
						btnCG_btn[j].setFocusPainted(false);
						btnCG_btn[j].setOpaque(false);
						WPGRP.add(btnCG_btn[j]);
						WPG.updateUI();
					}
				}
			});
		}
		
		WPTab.addTab("구매관련",WPG);
		WPTab.addTab("판매관련",WPP);
		westP.setLayout(new BorderLayout());
		westP.add(new JLabel(new ImageIcon("image/CCFAQ.PNG")),BorderLayout.NORTH);
		westP.add(WPTab,BorderLayout.CENTER);
		
		// �??�� 게시?�� -----------------------------.
		String str[] = {"구매자용","판매자용"};
		
		cb = new JComboBox(str);
		jtf = new JTextField(40);
		btnS = new JButton("검색");
		CPNPN = new JPanel();
		CPNPS = new JPanel();
		
		CPNPN.setLayout(new FlowLayout());
		CPNPN.add(cb);
		CPNPN.add(jtf);
		CPNPN.add(btnS);
		CPNPS.setLayout(new BorderLayout());
		CPNPS.add(new JLabel(new ImageIcon("image/CCDetail.PNG")),BorderLayout.CENTER);
		
		CPNorth.setLayout(new BorderLayout());
		CPNorth.add(CPNPN,BorderLayout.NORTH);
		CPNorth.add(CPNPS,BorderLayout.CENTER);
		
		mainData = new Vector<String>();
		mainData.add("NO");
		mainData.add("구분번호");
		mainData.add("제목");
		mainData.add("내용");
		mainData.add("작성자");
		rowData = new Vector<Vector<String>>();
		btnPrev = new JButton("PREVIOUS");
		btnNext = new JButton("NEXT");
		pageTF = new JTextField(12);
		//게시판 previous버튼 
		btnPrev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNext.setEnabled(true);
				if(srt>=10) {
					if(end%list.size()!=0) {
						srt -= 10;
						end  = srt+10;
					}else {
						srt -= 10;
						end = end-(list.size()+10);
					}
					System.out.println("srt="+srt+", end="+end+", max="+list.size());
					page = printAll(srt,end);
					jt.updateUI();
				}else {
					btnPrev.setEnabled(false);
					JOptionPane.showMessageDialog(null, "첫페이지 입니다..");
				}
				
			}
		});
		//게시판 next버튼
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnPrev.setEnabled(true);
				ArrayList<BE_CqnaVo> list = BCao.CqnalistAll();
				if(end<=list.size()) {
					if((list.size()-end)>10) { 
						srt += 10;
						end = srt+10;
						
					}else {
						srt += 10;
						end = list.size();
						btnNext.setEnabled(false);
					}
					System.out.println("srt="+srt+", end="+end+", max="+list.size());
						page = printAll(srt,end);
					jt.updateUI();
				}else {
					btnNext.setEnabled(false);
					JOptionPane.showMessageDialog(null, "마지막페이지 입니다..");
				}
			}
		});
		
		page = printAll(srt,end);
		JLabel pageLb = new JLabel(page+"");
		jt = new JTable(rowData,mainData);
		JScrollPane jsp = new JScrollPane(jt);
		JPanel btnP = new JPanel();
		CPSouth.setLayout(new BorderLayout());
		btnP.setLayout(new BorderLayout());
		btnP.add(btnPrev,BorderLayout.WEST);
		btnP.add(pageLb,BorderLayout.CENTER);
		btnP.add(btnNext,BorderLayout.EAST);
		CPSouth.add(jsp,BorderLayout.CENTER);
		CPSouth.add(btnP,BorderLayout.SOUTH);
		
		CenterP.setLayout(new GridLayout(2,1));
		CenterP.add(CPNorth);
		CenterP.add(CPSouth);
		
		setLayout(new BorderLayout());
		add(custL,BorderLayout.NORTH);
		add(westP,BorderLayout.WEST);
		add(CenterP,BorderLayout.CENTER);
		
		btnS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<BE_CqnaVo> list = BCao.CqnalistAll(jtf.getText());
				page=searchPrintAll(1,list.size());
				pageLb.setText(page+"");
				jt = new JTable(rowData,mainData);
				btnNext.setEnabled(false);
				btnPrev.setEnabled(false);
				pageTF.updateUI();
				CPSouth.updateUI();
				
			}
		});
	}
	
	public int  printAll(int s,int e) {
		int r=0;
		rowData.clear();
		ArrayList<BE_CqnaVo> list = BCao.CqnalistAll();
		//System.out.println("list사이즈는"+list.size());
		for (int i=s; i<e;i++) {
			Vector<String> v = new Vector<String>();
			v.add(list.get(i).getCqNum()+"");
			v.add(list.get(i).getCqnaS()+""); 
			v.add(list.get(i).getCqnaName());
			v.add(list.get(i).getCqna_Con()); 
			v.add(list.get(i).getCq_Answer()); 
			rowData.add(v);
			if(i%1!=0)	r = (i/10)+1;
			else 		r = i/10;
		}
		System.out.println(r+",r??");
		return r;
	}
	
	public int  searchPrintAll(int s,int e) {
		int r=0;
		rowData.clear();
		ArrayList<BE_CqnaVo> list = BCao.CqnalistAll(jtf.getText());
		//System.out.println("list사이즈는"+list.size());
		for (int i=s; i<e;i++) {
			Vector<String> v = new Vector<String>();
			v.add(list.get(i).getCqNum()+"");
			v.add(list.get(i).getCqnaS()+""); 
			v.add(list.get(i).getCqnaName());
			v.add(list.get(i).getCqna_Con()); 
			v.add(list.get(i).getCq_Answer()); 
			rowData.add(v);
			if(i%1!=0)	r = (i/10)+1;
			else 		r = i/10;
		}
		return r;
	}
}
