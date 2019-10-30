package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BE_SellerVo.BE_VideoVo;
import BE_Sellerdao.BE_SubDao;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class BE_SubPanel extends JPanel{
	int n = 1;
	
	JPanel jp_user_img[] = new JPanel[8];
	ImageIcon uimage[] = new ImageIcon[8];
	JLabel jl_uimage[] = new JLabel[8];
	
	JPanel jp_channel[] = new JPanel[8];
	JLabel jl_channel[]= new JLabel[8];
	JLabel jl_tag[]= new JLabel[8];
	
	JPanel jp_sub_under[]= new JPanel[8];
	
	JPanel jp_sub_top[]= new JPanel[8];
	
	JPanel jp_sub_img;
	ImageIcon sub_img[]= new ImageIcon[8];
	JLabel jl_sub_img[]= new JLabel[8];
	
	JPanel jp_sub[]= new JPanel[8];
	JPanel p;
	JPanel mainP,eventP;
	BE_SubDao dao = new BE_SubDao();
	static JLabel eventJL;
	public BE_SubPanel() {
		mainP = new JPanel();
		eventP = new JPanel();
		try {
			
			for (int i = 0; i < 8; i++) {
				jp_user_img[i] = new JPanel();
				
				
				uimage[i] = new ImageIcon("image/sub_image06(user).png");
				jl_uimage[i]= new JLabel(uimage[i]);
				jp_user_img[i].add(jl_uimage[i]);
				
				BE_VideoVo vo = dao.searchTitle(1); 
				BE_VideoVo vo01 = dao.searchTag(1);
				
				//-------채널이름, 해쉬태그-----------
				jp_channel[i] = new JPanel();
				jl_channel[i] = new JLabel(vo.getVname());   // 채널이름 = 판매자이름 인데 판매자 이름이 회원id로 되어있어 판매자 등록시 닉네임 등을 받을 컬럼을 추가하는 것이 좋을 듯
				jl_tag[i] = new JLabel(vo01.getVtag());
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
						new VideoPlayer(1);
					}
				});
				for(int j = 0; j < 8; j++) {
					
				sub_img[i] = new ImageIcon("image/sub_image0"+i+".png");
				}
				
				jl_sub_img[i] = new JLabel(sub_img[i]);
				jp_sub_img.add(jl_sub_img[i]);
				jp_sub_top[i].setLayout(new BorderLayout());
				jp_sub_top[i].add(jp_sub_img, BorderLayout.CENTER);
				jp_sub_top[i].add(jp_sub_under[i], BorderLayout.SOUTH);
				
				//구독한 채널 판넬
				jp_sub[i] = new JPanel();
				jp_sub[i].add(jp_sub_top[i]);
				
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		//-----------구독 라벨--------------
		
		JLabel sub = new JLabel("구독한 채널 > ");
		sub.setFont(new Font("나눔고딕", Font.BOLD, 20));
		
		JLabel sub01 = new JLabel("최근찜한 영상> ");
		sub01.setFont(new Font("나눔고딕", Font.BOLD, 20));
		
		JPanel jp = new JPanel();
		
		JPanel jpp = new JPanel();
		
		jp.setLayout(new FlowLayout());
		jp.add(sub);
		
		for (int j = 0; j < 4; j++) {
			
			jp.add(jp_sub[j]);
		}
	
		//getContentPane().
		jpp.setLayout(new FlowLayout());
		jpp.add(sub01);
		
		for (int j = 4; j < 8; j++) {
			//getContentPane().
			jpp.add(jp_sub[j]);
		}
		setLayout(new BorderLayout());
		mainP.setLayout(new BorderLayout());
		mainP.add(jp,BorderLayout.NORTH);
		mainP.add(jpp,BorderLayout.SOUTH);
		eventJL = new JLabel(new ImageIcon("image/eventSub.png"));
		eventJL.setPreferredSize(new Dimension(1000,180));
		
		eventP.add(eventJL);
		add(eventP,BorderLayout.NORTH);
		add(mainP,BorderLayout.CENTER);
		setSize(1100,900);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void SearchVideo() {
		StackPane root;
		Media media = null;
		
		try {
			File video = new File("video/video.mp4");
			String url = video.toURI().toURL().toString();
			System.out.println("url" + url);
			media = new Media(url);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		MediaPlayer player = new MediaPlayer(media);
        player.play();
        MediaView mediaView = new MediaView(player);
        
        root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color : white;");
        root.getChildren().add(mediaView);
	
	}
	
	/*
	 * public static void main(String[] args) { new BE_SubPanel(); }
	 */
	
}
