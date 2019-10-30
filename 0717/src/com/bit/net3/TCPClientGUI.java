package com.bit.net3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPClientGUI extends JFrame {
	
	
	JTextArea jta;
	JTextField jtf;
	JButton btn;
	int port = 9002;
	String ip = "203.236.209.97";
	Socket socket;
	InputStream is;
	OutputStream os;
	
	class ClientThread extends Thread
	{
		
		byte [] buf = new byte[100];
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				
			while(true)
			{
				is.read(buf);
				String str = new String(buf);
				//System.out.println(str);
				jta.append(str+"\n");
			}	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	public TCPClientGUI() {
		
		
		jta = new JTextArea();
		jtf = new JTextField(30);
		btn = new JButton("전송");
		
	
		//String ip = "172.168.0.219";
		
		
		setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		JScrollPane jsp = new JScrollPane(jta);
		
		jp.setLayout(new FlowLayout());
		jp.add(jtf);
		jp.add(btn);
		
		add(jsp, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverConnection();
		
		
		ClientThread ct = new ClientThread();
		ct.start();
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendData();
			
			}
		});
	}

	private void serverConnection() {
		// TODO Auto-generated method stub
		try {
			socket = new Socket(ip,port);
			is = socket.getInputStream(); //서버가 보내는 데이터 수신
			os = socket.getOutputStream();//서버에게 받은 데이터 송신
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}
	}

	private void sendData() {
		// TODO Auto-generated method stub
		String msg = jtf.getText();
		byte [] data = msg.getBytes();

		try {
			os.write(data);
			jtf.setText("");
			//socket.close();
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPClientGUI();
	}

}
