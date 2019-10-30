package com.bit.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 9001;
		try {
			String ip = args[0];
			String msg = args[1];
		
			byte [] data = msg.getBytes();
			InetAddress addr = InetAddress.getByName(ip);
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(data, data.length, addr, port);
			
			ds.send(dp);
			
			ds.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
