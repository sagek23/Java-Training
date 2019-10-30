package com.bit.net2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPSender extends JFrame {
	JTextArea jta;
	JTextField jtf;
	JButton btn;
	DatagramSocket ds;
	public UDPSender() {
		jta = new JTextArea();
		jtf = new JTextField(30);
		btn = new JButton("전송");
		int port = 9001;
//		String ip = "203.236.209.91";
		String ip = "172.168.0.219";
		
		
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
		
		try {
			ds = new DatagramSocket();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		class SenderThread extends Thread
		{
			byte [] buff = new byte [100];
			DatagramPacket p;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				p = new DatagramPacket(buff, buff.length);
				while(true)
				{	
					try {
						ds.receive(p);
						String msg = new String(buff);
						jta.append(p.getAddress()+msg.trim()+"\n"); //트림은 공백 없애기
						Arrays.fill(buff, (byte)0);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					
				}
			}
			
		}
		SenderThread st = new SenderThread();
		st.start();
		
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg = jtf.getText();
				
				//String ip = "172.168.0.219";
				
				try {
				
					InetAddress addr =  InetAddress.getByName(ip);
					byte [] data = msg.getBytes();
					
					DatagramPacket dp = new DatagramPacket(data, data.length, addr, port);
							
					ds.send(dp);
					//ds.receive(dp);
					jtf.setText("");
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPSender();
	}

}
