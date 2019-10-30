package com.bit.net3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPServer extends JFrame {

	JTextArea jta;
	JTextField jtf;
	JButton btn;
	int port = 9002;
	ServerSocket ssocekt;
	OutputStream os;
	InputStream is;
	public static ArrayList<ServerThread> list;
	public TCPServer() {
		
	try {
		list = new ArrayList<ServerThread>();
		ssocekt = new ServerSocket(port);
		System.out.println("��������");
		while(true)
		{
			Socket socket = ssocekt.accept();
		//	System.out.println("Ŭ���̾�Ʈ�� ����");
			ServerThread tst = new ServerThread(socket);
			list.add( tst );
			tst.start();				
			
		
		}
	} catch (Exception ex) {
	// TODO: handle exception
	System.out.println(ex.getMessage());}
				
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPServer();
	}

}