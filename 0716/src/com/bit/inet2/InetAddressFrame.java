package com.bit.inet2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InetAddressFrame extends JFrame implements ActionListener{
	JTextField jurl;
	JButton btn;
	JButton btn2;
	JTextArea usource;
	JFileChooser jfc;
	public InetAddressFrame() {
		jfc = new JFileChooser();
		jurl = new JTextField(50);
		btn = new JButton("�ܾ����");
		btn2 = new JButton("����");
		usource = new JTextArea();
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JScrollPane jsp = new JScrollPane(usource);
		jp.add(jurl);
		jp.add(btn);
		jp.add(btn2);
		
		jp.setLayout(new FlowLayout());
		btn.addActionListener(this);
		btn2.addActionListener(this);
		
		add(jp, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InetAddressFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd =e.getActionCommand();
		switch (cmd) {
		case "�ܾ����":
			getSource();
			break;

		case "����":
			saveSource();
			break;
		}
	}

	private void saveSource() {
		// TODO Auto-generated method stub
		int a = jfc.showSaveDialog(null);
		if(a==0)
		{
			try {
				FileWriter fw = new FileWriter(jfc.getSelectedFile());
				fw.write(usource.getText());
				fw.close();
				JOptionPane.showMessageDialog(null, "����Ϸ�");
				usource.setText("");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	private void getSource() {
		// TODO Auto-generated method stub
		byte [] data = new byte[100];
		try {
			int ch;
			String str="";
			URL url = new URL(jurl.getText());
			InputStream is = url.openStream(); //url�κ��� �о���� ���� ���� is�� ����
			/* 
			openStream()�޼ҵ�� URLŬ������ �޼ҵ��̸�, ������
			URL�κ��� ����Ʈ ������ �д� �Է� ��Ʈ����ü�� ��ȯ�Ѵ�.
			*/
			while((ch = is.read(data))!=-1)
			{
				String s = new String(data, "UTF-8");
				str += s;
				Arrays.fill(data, (byte)0);
			}
			is.close();
			jurl.setText("");
			usource.setText(str);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}
