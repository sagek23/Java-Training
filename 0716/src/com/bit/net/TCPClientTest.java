package com.bit.net;

import java.io.InputStream;
import java.net.Socket;

public class TCPClientTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("203.236.209.97", 9000);
			System.out.println("서버에 접속");
			InputStream is = socket.getInputStream();
		
			
			for(int i=0;i<10;i++)
			{
				System.out.println("서버로부터 수신된 데이터: "+is.read());
			}
			socket.close();
			System.out.println("서버와 연결해제");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
