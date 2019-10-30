package com.bit.draw2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.accessibility.Accessible;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class LineFrame extends JFrame implements ActionListener {

	JFileChooser jfc;
	LinePanel lp;
	File file;
	public LineFrame() {
		// TODO Auto-generated constructor stub
		lp = new LinePanel();
		jfc = new JFileChooser("c:/output");
		JMenuBar jmb = new JMenuBar();
		
		
		JMenu jm_draw = new JMenu("�׸��� ����");
		JMenuItem circle = new JMenuItem("��");
		JMenuItem square = new JMenuItem("�簢��");
		JMenuItem line = new JMenuItem("��");
		
		
		
		JMenu jm = new JMenu("����");
		JMenuItem menu_new = new JMenuItem("������");
		JMenuItem menu_open = new JMenuItem("����");
		JMenuItem menu_save = new JMenuItem("����");
		JMenuItem menu_exit = new JMenuItem("����");
		jm.add(menu_new);
		jm.add(menu_open);
		jm.add(menu_save);
		jm.add(menu_exit);
		jm_draw.add(line);
		jm_draw.add(circle);
		jm_draw.add(square);
		
		jmb.add(jm);
		jmb.add(jm_draw);
		setJMenuBar(jmb);
		
		menu_open.addActionListener(this);
		menu_save.addActionListener(this);
		menu_exit.addActionListener(this);
		menu_new.addActionListener(this);
		circle.addActionListener(this);
		square.addActionListener(this);
		line.addActionListener(this);
		
		add(lp);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LineFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "����":
			try {
				int a = jfc.showSaveDialog(this);
				if(a==0)
				{
					file = jfc.getSelectedFile();
					ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
					os.writeObject(lp.list);
					os.close();
					String fname = file.getName();
					JOptionPane.showMessageDialog(this, fname+"�� ����");
					setTitle(fname);
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			break;

		case "����":
			try {
				int a = jfc.showOpenDialog(this);
				if(a==0)
				{
					file = jfc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					lp.list = (ArrayList<GraphinInfo>)ois.readObject();
					lp.repaint();
					ois.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			break;
		case "��":
			lp.drawType = 0;
		break;
		case "��":
			lp.drawType = 1;
		break;
		case "�簢��":
			lp.drawType = 2;
		break;
		}
	}

}
