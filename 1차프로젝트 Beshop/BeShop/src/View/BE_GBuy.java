package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB.ConnectionProvider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class BE_GBuy extends JPanel{
	int n = 1;
	
	JPanel jp_user_img[] = new JPanel[8];
	ImageIcon uimage[] = new ImageIcon[4];
	JLabel jl_uimage[] = new JLabel[4];
	
	JPanel jp_channel[] = new JPanel[4];
	JLabel jl_channel[]= new JLabel[4];
	JLabel jl_tag[]= new JLabel[4];
	
	JPanel jp_sub_under[]= new JPanel[4];
	
	JPanel jp_sub_top[]= new JPanel[4];
	
	JPanel jp_sub_img;
	ImageIcon sub_img[]= new ImageIcon[4];
	JLabel jl_sub_img[]= new JLabel[4];
	
	JPanel jp_sub[]= new JPanel[4];
	JPanel p;
	
	JLabel lanknum[]=new JLabel[5];
	JLabel lankname[]=new JLabel[5];
	JLabel lankper[]=new JLabel[5];
	JPanel lankp[]=new JPanel[5];
	JPanel lankd[]=new JPanel[5];
	
	String bvname="";
	String bpname="";
	int bp_Price=0;
	int bstock=0;
	String bp_image="";
	Date bP_cdate=null;
	Date bfdate=null;
	
	public BE_GBuy() {
		
		String sql="select vname,pname,p_Price,stock,p_Image,p_cdate,Formdate from Product,Video where Product.pnum=Video.pnum and product.pnum=1";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement stmt =conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				bvname=rs.getString(1);
				bpname=rs.getString(2);
				bp_Price=rs.getInt(3);
				bstock=rs.getInt(4); 
				bp_image=rs.getString(5);
				bP_cdate=rs.getDate(6);
				bfdate=rs.getDate(7);
			
			}
			ConnectionProvider.close(conn, stmt,rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		ImageIcon videoimg=new ImageIcon("image/videoimg.jpg");
		JPanel video=new JPanel();
		//JPanel vp=new VideoPlayer(4);
		JPanel detail=new JPanel();
		JLabel v=new JLabel(videoimg);
		JLabel vfdate=new JLabel(bfdate+" 펀딩마감");
		JLabel pname=new JLabel(bpname);
		JLabel per=new JLabel("600% 달성");
		JLabel price=new JLabel(bp_Price+"원");
		JButton funding=new JButton("펀딩하기");
		
		funding.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GbuyDetailPage();
			}
		});
		v.addMouseListener(new MouseListener() {
			
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
				new GbuyDetailPage();
			}
		});
		
		
		//vp.add(v);
		
		detail.setLayout(new GridLayout(5,1));
		detail.add(vfdate);
		detail.add(pname);
		detail.add(per);
		detail.add(price);
		detail.add(funding);
		
		video.setLayout(new BorderLayout());
		//vp.setPreferredSize(new Dimension(300,500));
		video.add(v,BorderLayout.CENTER);
		video.add(detail,BorderLayout.EAST);
		
		
		
		JPanel lank=new JPanel();
		lank.setLayout(new GridLayout(5,1));
		
		
		
		try {
			for (int i = 0; i < 5; i++) {
			lanknum[i]=new JLabel((i+1)+"");
			lanknum[i].setFont(new Font("나눔고딕",Font.BOLD, 15));
			lankname[i]=new JLabel(bpname);
			lankper[i]=new JLabel("250% 달성");
			lankp[i]=new JPanel();
			lankd[i]=new JPanel();
			lankd[i].setLayout(new GridLayout(2,1));
			lankp[i].setLayout(new FlowLayout());
			lankd[i].add(lankname[i]);
			lankd[i].add(lankper[i]);
			
			lankp[i].add(lanknum[i]);
			lankp[i].add(lankd[i]);
			lank.add(lankp[i]);
			
			lankd[i].addMouseListener(new MouseListener() {
				
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
					new GbuyDetailPage();
				}
			});
		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		video.add(lank);
		
		try {
			
			for (int i = 0; i < 4; i++) {
				jp_user_img[i] = new JPanel();
				uimage[i] = new ImageIcon("image/sub_image06(user).png");
				jl_uimage[i]= new JLabel(uimage[i]);
				jp_user_img[i].add(jl_uimage[i]);
				
				//-------채널이름, 해쉬태그-----------
				jp_channel[i] = new JPanel();
				jl_channel[i] = new JLabel("정소민의 영스트리트");   // 채널이름 = 판매자이름 인데 판매자 이름이 회원id로 되어있어 판매자 등록시 닉네임 등을 받을 컬럼을 추가하는 것이 좋을 듯
				jl_tag[i] = new JLabel("여성패션 # 원피스 # 중고");
				jp_channel[i].setLayout(new BorderLayout());
				jp_channel[i].add(jl_channel[i], BorderLayout.NORTH);
				jp_channel[i].add(jl_tag[i],BorderLayout.SOUTH);
				
				//--------회원이미지와 채널이름, 해시태그---------
				jp_sub_under[i] = new JPanel();
				jp_sub_under[i].setLayout(new FlowLayout());
				jp_sub_under[i].add(jp_user_img[i]);
				jp_sub_under[i].add(jp_channel[i]);
				//-------구독 채널 이미지와 jp_sub_under--------
				jp_sub_top[i] = new JPanel();
				
				jp_sub_img = new JPanel();
				jp_sub_img.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						p = jp_sub_img; 
						p = (JPanel)e.getSource();
						p.setBackground(new Color(238, 238, 238));
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						 p = jp_sub_img; 
						 p = (JPanel)e.getSource(); 
						 p.setBackground(new Color(44, 117, 255));
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						new GbuyDetailPage();
					
					}
				});
				
				sub_img[i] = new ImageIcon("image/sub_img.png");
				jl_sub_img[i] = new JLabel(sub_img[i]);
				jp_sub_img.add(jl_sub_img[i]);
				jp_sub_top[i].setLayout(new BorderLayout());
				jp_sub_top[i].add(jp_sub_img, BorderLayout.CENTER);
				jp_sub_top[i].add(jp_sub_under[i], BorderLayout.SOUTH);
				
				//구독한 채널 판넬
				jp_sub[i] = new JPanel();
				jp_sub[i].add(jp_sub_top[i]);
				jp_sub[i].setLayout(new FlowLayout());
				
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//-----------구독 라벨--------------
		
		JLabel sub = new JLabel("이런펀딩은 어떠신가요? ");
		sub.setFont(new Font("나눔고딕", Font.BOLD, 20));
//		JPanel jp = new JPanel();
//		jp.add(sub);
		
		
		JPanel total=new JPanel();
		total.setLayout(new GridLayout(2,1));
		JPanel Gbuy=new JPanel();
		Gbuy.setLayout(new GridLayout(1,4));
		JPanel jpp = new JPanel();
		jpp.setLayout(new FlowLayout());
		JPanel jjp = new JPanel();
		//video.setPreferredSize(new Dimension(300,500));
		jpp.add(v);
		jpp.add(detail);
		jjp.setLayout(new BorderLayout());
		
		
		for (int j = 0; j < 4; j++) {
			
			Gbuy.add(jp_sub[j]);
		}
		jjp.add(sub,BorderLayout.NORTH);
		jjp.add(Gbuy,BorderLayout.CENTER);
		
		total.add(jpp);
		total.add(jjp);
		//setLayoutnew BorderLayout());
		
		add(total);
		
		setSize(1100,800);
		setVisible(true);
		
	}
	
	
}
