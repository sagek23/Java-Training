package paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class PaintFrame extends JFrame implements ActionListener {
	JFileChooser jfc;
	File file;
	PaintPanel pp;
	JColorChooser jcc;
	public PaintFrame() {
		jcc = new JColorChooser(Color.black);
		pp = new PaintPanel();
		jfc = new JFileChooser("c:/output");
		
		JMenuBar jmb = new JMenuBar();	
		JMenu jm = new JMenu("파일");
		JMenu jm2 = new JMenu("도구");
		JMenu jm3 = new JMenu("색상");
		
		JMenuItem mnew = new JMenuItem("새파일");
		JMenuItem save = new JMenuItem("저장");
		JMenuItem open = new JMenuItem("불러오기");
		JMenuItem exit = new JMenuItem("종료");
		
		mnew.addActionListener(this);
		save.addActionListener(this);
		open.addActionListener(this);
		exit.addActionListener(this);
		
		jm.add(mnew);
		jm.add(save);
		jm.add(open);
		jm.add(exit);
		
		jmb.add(jm);
		
		JMenuItem circle = new JMenuItem("원");
		JMenuItem line = new JMenuItem("선");
		JMenuItem rect = new JMenuItem("사각형");
		
		jm2.add(circle);
		jm2.add(line);
		jm2.add(rect);
		
		circle.addActionListener(this);
		line.addActionListener(this);
		rect.addActionListener(this);
		
		jmb.add(jm2);
		
		JMenuItem cyan = new JMenuItem("청록");
		JMenuItem gray = new JMenuItem("회색");
		JMenuItem blue = new JMenuItem("파랑");
		JMenuItem green = new JMenuItem("초록");
		JMenuItem color_ch = new JMenuItem("다른 색상");
		
		jm3.add(cyan);
		jm3.add(gray);
		jm3.add(blue);
		jm3.add(green);
		jm3.add(color_ch);
		
		cyan.addActionListener(this);
		gray.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		color_ch.addActionListener(this);
		
		jmb.add(jm3);
		
		add(pp);
		setJMenuBar(jmb);
		
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PaintFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd= e.getActionCommand();
		
		switch (cmd) {
		case "새파일":
			break;
		case "저장":
			int a = jfc.showSaveDialog(this);
			try {
				if(a==0)
				{
					file = jfc.getSelectedFile();
					ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(pp.list);
					oos.close(); 
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			break;
		case "불러오기":
			int b = jfc.showOpenDialog(this);
			if(b==0)
			{
				file = jfc.getSelectedFile();
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					pp.list = (ArrayList<PaintSelect>)ois.readObject();
					pp.repaint();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}	
			}
			break;
		case "종료":
			System.exit(0);
			break;
		case "원":
			pp.drawType = 0;
			break;
		case "선":
			pp.drawType =1;
			break;
		case "사각형":
			pp.drawType = 2;
			break;
		case "청록":
			pp.color = Color.cyan;
			break;
		case "회색":
			pp.color = Color.gray;
			break;
		case "파랑":
			pp.color = Color.blue;
			break;
		case "초록":
			pp.color = Color.green;
			break;
		case "다른 색상":
			pp.color = jcc.showDialog(this, "색상선택", Color.black);
			break;

		}
	
	}

}
