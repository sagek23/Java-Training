package com.bit.fileTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.bit.fileList.FileListFrame;

public class FileListFra extends JFrame implements ActionListener, MouseListener {
	JTextArea jta;
	JButton btn;
	JList<String> list;
	File file;
	Vector<String> data;

	public FileListFra() {
		
		data = new Vector<String>();
		jta = new JTextArea();
		
		btn = new JButton("ªË¡¶");
		list = new JList<String>(data);
		listFile();
		
		list.addMouseListener(this);
		
		setLayout(new BorderLayout());
		JScrollPane jsp1 = new JScrollPane(list);
		JScrollPane jsp2 = new JScrollPane(jta);
		JPanel jp = new JPanel();
		
		jp.setLayout(new BorderLayout());
		jp.add(jsp1, BorderLayout.CENTER);
		jp.add(btn,  BorderLayout.SOUTH);
		
		add(jp, BorderLayout.WEST);
		add(jsp2, BorderLayout.CENTER);
		
	
		
		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(this);
	
	}
	private void listFile() {
		// TODO Auto-generated method stub
		data.clear();
		String path = "c:/output";
		File dir = new File(path);
		String [] fileList = dir.list();
		
		for(String f:fileList)
		{
			File file = new File("c:/output/"+f);
			if(file.isFile())
			{
				String fname = file.getName();
				if(fname.endsWith(".txt")||fname.endsWith(".java"))
				{
					data.add(f);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileListFra();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
