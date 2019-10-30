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
		JMenu jm = new JMenu("����");
		JMenu jm2 = new JMenu("����");
		JMenu jm3 = new JMenu("����");
		
		JMenuItem mnew = new JMenuItem("������");
		JMenuItem save = new JMenuItem("����");
		JMenuItem open = new JMenuItem("�ҷ�����");
		JMenuItem exit = new JMenuItem("����");
		
		mnew.addActionListener(this);
		save.addActionListener(this);
		open.addActionListener(this);
		exit.addActionListener(this);
		
		jm.add(mnew);
		jm.add(save);
		jm.add(open);
		jm.add(exit);
		
		jmb.add(jm);
		
		JMenuItem circle = new JMenuItem("��");
		JMenuItem line = new JMenuItem("��");
		JMenuItem rect = new JMenuItem("�簢��");
		
		jm2.add(circle);
		jm2.add(line);
		jm2.add(rect);
		
		circle.addActionListener(this);
		line.addActionListener(this);
		rect.addActionListener(this);
		
		jmb.add(jm2);
		
		JMenuItem cyan = new JMenuItem("û��");
		JMenuItem gray = new JMenuItem("ȸ��");
		JMenuItem blue = new JMenuItem("�Ķ�");
		JMenuItem green = new JMenuItem("�ʷ�");
		JMenuItem color_ch = new JMenuItem("�ٸ� ����");
		
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
		case "������":
			break;
		case "����":
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
		case "�ҷ�����":
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
		case "����":
			System.exit(0);
			break;
		case "��":
			pp.drawType = 0;
			break;
		case "��":
			pp.drawType =1;
			break;
		case "�簢��":
			pp.drawType = 2;
			break;
		case "û��":
			pp.color = Color.cyan;
			break;
		case "ȸ��":
			pp.color = Color.gray;
			break;
		case "�Ķ�":
			pp.color = Color.blue;
			break;
		case "�ʷ�":
			pp.color = Color.green;
			break;
		case "�ٸ� ����":
			pp.color = jcc.showDialog(this, "������", Color.black);
			break;

		}
	
	}

}
