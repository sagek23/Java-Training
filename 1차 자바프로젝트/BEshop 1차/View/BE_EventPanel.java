package View;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BE_AdminDao.BE_EventDao;
import BE_AdminVo.BE_EventVo;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BE_EventPanel extends JPanel {
	JLabel[] jl_event_img = new JLabel[6];
	JPanel[] jp_event_img = new JPanel[6];
	ImageIcon[] event_img = new ImageIcon[6];
	JPanel[] jp_event_text = new JPanel[6];
	JLabel[] jl_event_name = new JLabel[6];
	JLabel[] jl_event_date = new JLabel[6];
	JPanel[] jp_event = new JPanel[6];
	
	public BE_EventPanel() {
		setLayout(new BorderLayout());
		
		JPanel jp_event_title = new JPanel();
		add(jp_event_title, BorderLayout.NORTH);
		JLabel jl_event_title = new JLabel("진행중인 이벤트");
		jl_event_title.setFont(new Font("굴림", Font.PLAIN, 20));
		jp_event_title.add(jl_event_title);
		
		JPanel jp_event_all = new JPanel();
		add(jp_event_all, BorderLayout.CENTER);
		//이벤트 이미지 6개 반복문
		//이벤트 이미지 img_panel에 추가(반복문)
		//이벤트 이름, 날짜 jl_event_name, jl_event_date 에 추가 (Be_eventvo 사용)
		//이미지와 이름을 합친 패널 6개 생성
		for(int i=0; i<6; i++) {
			//이벤트 사진 패널1
			jp_event_img[i] = new JPanel();
			event_img[i] = new ImageIcon("image/event"+i+".jpg");
			jl_event_img[i] = new JLabel(event_img[i]);
			jp_event_img[i].add(jl_event_img[i]);
			BE_EventVo vo = new BE_EventVo();
			BE_EventDao dao = new BE_EventDao();
			vo = dao.Eventlist(100);
			
			//이벤트 제목, 이벤트 등록 날짜 패널
			jl_event_name[i] = new JLabel();
			jl_event_name[i].setText(vo.geteName());
			jl_event_date[i] = new JLabel();
			jl_event_date[i].setText(vo.geteDate()+"");
			jp_event_text[i] = new JPanel();
			jp_event_text[i].setLayout(new BorderLayout());
			jp_event_text[i].add(jl_event_name[i], BorderLayout.NORTH);
			jp_event_text[i].add(jl_event_date[i], BorderLayout.SOUTH);
			
			//이벤트 사진 + 이벤트 제목, 등록날짜
			jp_event[i] = new JPanel();
			jp_event[i].setLayout(new BorderLayout());
			jp_event[i].add(jp_event_img[i], BorderLayout.CENTER);
			jp_event[i].add(jp_event_text[i], BorderLayout.SOUTH);
			
			jp_event_all.setLayout(new GridLayout(3,2));
			jp_event_all.add(jp_event[i]);
			
			
			jp_event_img[i].addMouseListener(new MouseListener() {
				
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
					BE_EventImg be_event_img = new BE_EventImg();
					be_event_img.imagenum = 1;
					
				}
			});

		}
			setSize(700,1000);
			setVisible(true);

	}
	
	/*
	 * public static void main(String[] args) { new BE_EventPanel(); }
	 */
}

