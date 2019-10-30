package com.bit.net3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class ServerThread extends Thread {
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public void send(byte []data)
	{
		try{
			os.write(data);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void broadCast( byte[]data  )
	{
		for( ServerThread th   : TCPServer.list)
		{
			th.send(data);
		}
	}
	
	public ServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
	@Override
	public void run() {
		byte [] data = new byte[100];
		while(true)
		{
			try {
				is.read(data);
				String str = new String(data);	
				System.out.println("수신된 메세지: "+str);
				broadCast(data);
				Arrays.fill(data, (byte)0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	}

}
