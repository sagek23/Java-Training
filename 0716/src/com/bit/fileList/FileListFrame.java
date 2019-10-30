package com.bit.fileList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileListFrame extends JFrame implements ActionListener, MouseListener {
	JTextArea jta;
	JButton btn;
	JList<String> list;
	File file;
	Vector<String> data;

	public FileListFrame() {
		
		data = new Vector<String>();
		jta = new JTextArea();
		
		btn = new JButton("삭제");
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String fname = list.getSelectedValue();
		int re = JOptionPane.showConfirmDialog(null, fname+"파일을 정말로 삭제할까요?");
		if(re == 0)
		{
			File file = new File("c:/output/"+fname);
			file.delete();					
			listFile();
			jta.setText("");
			JOptionPane.showMessageDialog(null, fname+"파일을 삭제하였습니다.");
		}
	}
	private void listFile() {
		// TODO Auto-generated method stub
		data.clear();
		String path = "c:/output";
		File dir = new File(path);
		String []file_list = dir.list();
		for(String fl:file_list)
		{			
			File file = new File("c:/output/"+fl);			
			if(file.isFile() )
			{
				String fname = file.getName();
				if(fname.endsWith(".java") || fname.endsWith(".txt"))
				{
					data.add(fl);
				}
			}
		}
		list.updateUI();

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		String fname= list.getSelectedValue();
		try {
			FileReader fr = new FileReader("c:/output/"+fname);
			int ch;
			String str = "";
			while((ch = fr.read()) != -1)
			{
				str = str + (char)ch;
			}					
			jta.setText(str);
			fr.close();
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}
		
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
}
