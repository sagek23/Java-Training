package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import BE_Sellerdao.BE_VideoDao;
import BE_ShoppingDao.BE_ProductDao;

import javax.media.*;


public class BE_MainPanel extends JPanel{
	
	JTabbedPane jtab;
	String url;
    JPanel jp;
    JLabel la,nla,sla;
    JPanel mainPanel,eventPanel,mainP;
    String []file;
    JScrollPane jsp;
    JButton btnL,btnR;
    BE_ProductDao bpao;
    int Vnum=1;
    VideoPlayer vp;
    //int videoNum[] = {20001,20002,20003,28291,28321,89593};
    
    JButton btnS_event1,btnS_event2;
    BE_VideoDao bvao;
    
	public BE_MainPanel(){
		bvao = new BE_VideoDao();
		btnL = new JButton(new ImageIcon("image/btnL.png"));
		btnR = new JButton(new ImageIcon("image/btnR.png"));
		btnL.setContentAreaFilled(false);	//버튼 배경 ?��?��
		btnR.setContentAreaFilled(false);	
		btnL.setFocusPainted(false);		//버튼 ?��?��?��?��?��?�� ?��기는 ?��?���? ?��?��?��?��
		btnR.setFocusPainted(false);
		btnL.setOpaque(false);
		btnR.setOpaque(false);
		bpao = new BE_ProductDao();
		btnS_event1 = new JButton(new ImageIcon("image/event3.png"));
		btnS_event2 = new JButton(new ImageIcon("image/videoimg.jpg"));
		btnS_event1.setContentAreaFilled(false);	//버튼 배경 ?��?��
		btnS_event2.setContentAreaFilled(false);	
		btnS_event1.setFocusPainted(false);		//버튼 ?��?��?��?��?��?�� ?��기는 ?��?���? ?��?��?��?��
		btnS_event2.setFocusPainted(false);
		btnS_event1.setOpaque(false);
		btnS_event2.setOpaque(false);
		btnS_event2.setPreferredSize(new Dimension(800,600));
		
		vp = new VideoPlayer(Vnum);
		
		jsp = new JScrollPane();
		file = new String[100];
		jtab = new JTabbedPane();
		
		mainP = new JPanel();
		mainPanel = new JPanel();
		eventPanel = new JPanel();
		la = new JLabel();
		nla = new JLabel();
		sla = new JLabel();
		jp = new JPanel();
		
		
		eventPanel.setLayout(new BorderLayout());
		eventPanel.setPreferredSize(new Dimension(400,300));
		eventPanel.add(btnS_event1,BorderLayout.WEST);
		eventPanel.add(btnS_event2,BorderLayout.CENTER);
		
		la.setLayout(new GridLayout());
		la.add(nla);
		la.add(sla);
		
		setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(2,1));
		jp.setLayout(new BorderLayout());
		
		jp.add(vp,BorderLayout.CENTER);
		jp.add(btnL,BorderLayout.WEST);
		jp.add(btnR,BorderLayout.EAST);
		mainPanel.add(jp);
		mainPanel.add(eventPanel);
		
		mainP.setLayout(new BorderLayout());
		mainP.add(mainPanel,BorderLayout.CENTER);
		
		JPanel mainJP = new JPanel();
		
		mainP.setPreferredSize(new Dimension(1000,700));
		mainJP.add(mainP);
		//?�� ?��?��
		jtab.addTab("",new JScrollPane(mainJP));
		jtab.addTab("Shopping",new JScrollPane(new ShoppingApp()));
		jtab.addTab("Gbuy",new BE_GBuy());
		jtab.addTab("Sub",new JScrollPane(new BE_SubPanel()));
		jtab.addTab("Rank",new JScrollPane(new BE_RankingPanel()));
		jtab.addTab("Event",new JScrollPane(new BE_EventPanel()));
		jtab.addTab("CustCenter",new BE_CustCenter());
		//?�� ?��진설?��
		ImageIcon icon1 = new ImageIcon("image/Shopping.png");
		ImageIcon icon2 = new ImageIcon("image/Gbuy.png");
		ImageIcon icon3 = new ImageIcon("image/Sub.png");
		ImageIcon icon4 = new ImageIcon("image/Rank.png");
		ImageIcon icon5 = new ImageIcon("image/Event.png");
		ImageIcon icon6 = new ImageIcon("image/CustCenter.png");
		//?��버튼 ?�� ?��미�??��?��.
		jtab.setTabComponentAt(1, new JLabel(icon1));
		jtab.setTabComponentAt(2, new JLabel(icon2));
		jtab.setTabComponentAt(3, new JLabel(icon3));
		jtab.setTabComponentAt(4, new JLabel(icon4));
		jtab.setTabComponentAt(5, new JLabel(icon5));
		jtab.setTabComponentAt(6, new JLabel(icon6));
		
		add(jtab,BorderLayout.CENTER);
		
		btnL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
				Vnum--;
				System.out.println(Vnum);
				if(Vnum < 1) {
					Vnum = bvao.getnum();
					System.out.println(bvao.getnum());
				}
				jp.removeAll();
				jp.add(btnL,BorderLayout.WEST);
				jp.add(btnR,BorderLayout.EAST);
				vp = new VideoPlayer(Vnum);
				Thread.sleep(1000);
				jp.add(vp,BorderLayout.CENTER);
				
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}			
			}
		});
		btnR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
				Vnum++;
				System.out.println(Vnum);
				if(Vnum> bvao.getnum()) {
					Vnum = 1;
				}
				jp.removeAll();
				jp.add(btnL,BorderLayout.WEST);
				jp.add(btnR,BorderLayout.EAST);
				vp = new VideoPlayer(Vnum);
				Thread.sleep(500);
				jp.add(vp,BorderLayout.CENTER);
				
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		btnS_event1.addActionListener(new ActionListener() {
			//이벤트 클릭시 이벤트 링크처리;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnS_event2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
