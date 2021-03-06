package com.bit.io.filetest2;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BitNotePad extends JFrame implements ActionListener {

	JTextArea jta;
	JFileChooser jfc;
	public BitNotePad() {
		// TODO Auto-generated constructor stub
		jfc = new JFileChooser("c:/output/");
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		JMenuBar jmb = new JMenuBar();//메뉴바
		JMenu menu = new JMenu("파일");//주메뉴
		JMenuItem item_new= new JMenuItem("새파일");//부메뉴
		JMenuItem item_save= new JMenuItem("저장");//부메뉴
		JMenuItem item_exit= new JMenuItem("종료");//부메뉴
		JMenuItem item_open= new JMenuItem("열기");//부메뉴
		
		menu.add(item_new);
		menu.add(item_open);
		menu.add(item_save);
		menu.add(item_exit);
		
		jmb.add(menu);
		setJMenuBar(jmb);
		
		item_new.addActionListener(this);
		item_save.addActionListener(this);
		item_exit.addActionListener(this);
		item_open.addActionListener(this);
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
			
		switch (cmd) {
		case "저장":
			try {
				int c = jfc.showSaveDialog(this);

				switch (c) {
				case 0:
					
					FileWriter fw = new FileWriter(jfc.getSelectedFile());
					fw.write(jta.getText());
					fw.close();
					System.out.println("파일을 생성하였습니다");
					break;
				}
			
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			break;
		case "열기":
			jta.setText("");
			int d= jfc.showOpenDialog(this);
			
			switch (d){
			case 0:
				try {
					FileReader fr = new FileReader(jfc.getSelectedFile());
					int a;
					String str="";
					while((a=fr.read())!=-1)
					{
						str = str+(char)a;
					}
					
					jta.setText(str);
					System.out.println(str);
					fr.close();
					break;
						
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				break;
			}
		case "새파일":
			jta.setText("");
			break;
		case "종료":
			System.exit(0);
			break;
		}
		/*if(cmd.equals("저장"))
		{
		try {
			FileWriter fw = new FileWriter("c:/output/notepad.txt");
			fw.write(jta.getText());
			fw.close();
			System.out.println("파일을 생성하였습니다");
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}
		}
		*/
	}

	public static void main(String[] args) {
		new BitNotePad();
	}
}
