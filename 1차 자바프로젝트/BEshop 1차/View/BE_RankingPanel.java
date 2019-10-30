package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BE_SellerVo.BE_VideoVo;
import BE_Sellerdao.BE_RankDao;
import BE_ShoppingVo.BE_ProductVo;

public class BE_RankingPanel extends JPanel {
	String vname ="";
	String vdate = "";
	
	JPanel jp_rank_img = new JPanel();
	ImageIcon rank_img[] = new ImageIcon[6];
	JLabel jl_rank_img[] = new JLabel[6];
	
	JPanel jp_video[] = new JPanel[6];
	JLabel jl_vname[] = new JLabel[6];
	JLabel jl_vdate[] = new JLabel[6];
	
	JPanel jp_seller[] = new JPanel[6];
	ImageIcon s_icon[] = new ImageIcon[6];
	JLabel jl_seller[] = new JLabel[6];
	JPanel jp_rank_con[] = new JPanel[6];
	
	JPanel jp_rank_num[] = new JPanel[6];
	JLabel jl_rank_num[] = new JLabel[6];
	
	JPanel jp_hw[] = new JPanel[6];
	JLabel jl_hit[] = new JLabel[6];
	JLabel jl_wish[] = new JLabel[6];
	
	JPanel jp_rank_bottom[] = new JPanel[6];
	JPanel jp_rank[] = new JPanel[6];
	JPanel jp_rank_all = new JPanel();
	JPanel jp_rank_top3 = new JPanel();
	JPanel jp_rank_nam = new JPanel();
	JLabel jLabel[] = new JLabel[6];
	
	
	BE_RankDao dao = new BE_RankDao();
	
	ArrayList<BE_VideoVo> list;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	
	public BE_RankingPanel() {
		
		//랭킹 메인 이미지 패널
		for(int i = 1; i < 6; i++) {
		jp_rank_img = new JPanel();
		jp_rank_img.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				JPanel p = jp_rank_img;
				p = (JPanel)e.getSource();
				p.setBackground(new Color(238, 238, 238));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				JPanel p = jp_rank_img;
				p = (JPanel)e.getSource();
				p.setBackground(new Color(44, 117, 255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new VideoPlayerFrame(1);
				dao.videoHit(1);
			}
		});
		rank_img[i] = new ImageIcon("image/sub_image0"+ i +".png");
		Image rank_achange = rank_img[i].getImage();
		Image rank_bchange = rank_achange.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(rank_bchange);
		
		jl_rank_img[i] = new JLabel(rank_img[i]);
		jLabel[i] = new JLabel(icon);
		
		if(i<3) {
			jp_rank_img.add(jLabel[i]);
		}else {
			jp_rank_img.add(jl_rank_img[i]);
		}
		
		//jp_rank_img.add(jl_rank_img[i]);
		
		int arr[] = {28291, 28291, 28321, 89593, 89593, 89593};	
		
		BE_VideoVo vo = dao.searchTitle(i);
		BE_VideoVo vo01 = dao.searchVupdate(i);
		BE_VideoVo vo02 = dao.searchBuid(i);
		
//		ArrayList<BE_VideoVo> vo03 = dao.VideolistAll();
		//영상제목, 영상 날짜
		jp_video[i] = new JPanel();
		vname = vo.getVname();
		vdate =  vo01.getVupdate() + "                                                " + vo02.getBeUid();
		jl_vname[i] = new JLabel(vname);
		jl_vname[i].setFont(new Font("오늘의 원피스 사러와요~", Font.BOLD, 20 ));
		jl_vdate[i] = new JLabel(vdate);
		jp_video[i].setLayout(new BorderLayout());
		jp_video[i].add(jl_vname[i], BorderLayout.NORTH);
		jp_video[i].add(jl_vdate[i], BorderLayout.CENTER);
		
		
		
		//판매자 이미지
		jp_seller[i] = new JPanel();
		s_icon[i] = new ImageIcon("image/sub_image06(user).png");
		jl_seller[i] = new JLabel(s_icon[i]);
		jp_seller[i].add(jl_seller[i]);
		
		
		//jp_video + jp_seller
		jp_rank_con[i] = new JPanel();
		jp_rank_con[i].setLayout(new BorderLayout());
		jp_rank_con[i].add(jp_video[i], BorderLayout.WEST);
		jp_rank_con[i].add(jp_seller[i], BorderLayout.EAST);
		
		
		//랭킹 순위
		jp_rank_num[i] = new JPanel();
		jl_rank_num[i] = new JLabel(i + "");
		jl_rank_num[i].setFont(new Font("나눔스퀘어", Font.BOLD, 40));
		jp_rank_num[i].add(jl_rank_num[i]);
		
		//BE_ProductVo vo04 = dao.videoHit(1);
		
		//조회수와 찜한 수
		jp_hw[i] = new JPanel();
		int hit = 0;//vo04.getHits();
		int wish = 5786486;
		jl_hit[i] = new JLabel("▶   "+hit );
		jl_wish[i] = new JLabel("♥ "+wish);
		jp_hw[i].add(jl_hit[i]);
		jp_hw[i].add(jl_wish[i]);
		
		jp_rank_bottom[i] = new JPanel();
		jp_rank_bottom[i].setLayout(new BorderLayout());
		jp_rank_bottom[i].add(jp_rank_num[i], BorderLayout.WEST);
		jp_rank_bottom[i].add(jp_rank_con[i],BorderLayout.CENTER);
		jp_rank_bottom[i].add(jp_hw[i], BorderLayout.SOUTH);
		
		
		jp_rank[i] = new JPanel();
		jp_rank[i].setLayout(new BorderLayout());
		jp_rank[i].add(jp_rank_img, BorderLayout.CENTER);
		jp_rank[i].add(jp_rank_bottom[i], BorderLayout.SOUTH);
		
		
		//jp_rank[i].setLayout(new GridLayout());
		
		//jp_rank_all.add(jp_rank[i]);
		
		//jp_rank_all.setLayout(new GridLayout(2,3));
		jp_rank_top3.setLayout(new GridLayout(1,3));
		jp_rank_nam.setLayout(new GridLayout(1,2));
		if(i<3) {
			jp_rank_top3.add(jp_rank[i]);
		}
		else if(i>2) {
			jp_rank_nam.add(jp_rank[i]);
		}
		jp_rank_all.setLayout(new BorderLayout());
		jp_rank_all.add(jp_rank_top3, BorderLayout.CENTER);
		jp_rank_all.add(jp_rank_nam, BorderLayout.SOUTH);
		//getContentPane().
		add(jp_rank_all);
		
		}
		
		setSize(1000,600);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		
		
	}
	protected void listVideo() {
		list = dao.VideolistAll(); 
		
		for(BE_VideoVo vo : list) {
			Vector<String> v = new Vector<String>();
			v.add(vo.getVnum() + "");
			v.add(vo.getVname());
			v.add(vo.getVfile());
			v.add(vo.getVupdate() + "");
			v.add(vo.getPnum() + "");
			v.add(vo.getBeUid());
			v.add(vo.getSnum() + "");
			v.add(vo.getFormnum() + "");
			v.add(vo.getFormdate() + "");
			v.add(vo.getVtime() + "");
			v.add(vo.getVtag());
			
			rowData.add(v);
			
		}
		
	}
	
	

}
