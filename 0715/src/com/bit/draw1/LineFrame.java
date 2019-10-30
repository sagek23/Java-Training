package com.bit.draw1;

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
		JMenu jm = new JMenu("파일");
		JMenuItem menu_new = new JMenuItem("새파일");
		JMenuItem menu_open = new JMenuItem("열기");
		JMenuItem menu_save = new JMenuItem("저장");
		JMenuItem menu_exit = new JMenuItem("종료");
		jm.add(menu_new);
		jm.add(menu_open);
		jm.add(menu_save);
		jm.add(menu_exit);
		
		jmb.add(jm);
		setJMenuBar(jmb);
		
		menu_open.addActionListener(this);
		menu_save.addActionListener(this);
		menu_exit.addActionListener(this);
		menu_new.addActionListener(this);
		
		
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
		case "저장":
			try {
				int a = jfc.showSaveDialog(this);
				if(a==0)
				{
					file = jfc.getSelectedFile();
					ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
					os.writeObject(lp.list);
					os.close();
					String fname = file.getName();
					JOptionPane.showMessageDialog(this, fname+"에 저장");
					setTitle(fname);
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			break;

		case "열기":
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
		}
	}

}
