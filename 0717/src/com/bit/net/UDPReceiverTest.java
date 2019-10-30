package com.bit.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.HashSet;

public class UDPReceiverTest {
	HashSet<SocketAddress> client_list;
	public UDPReceiverTest() {
		client_list = new HashSet<SocketAddress>();
		
		int port = 9001;
		try {
			DatagramSocket ds = new DatagramSocket(port);
			byte [] data = new byte[100]; //데이터를 받기위한 그릇
			DatagramPacket dp = new DatagramPacket(data, data.length);
			while(true)
			{
				ds.receive(dp);
				client_list.add(dp.getSocketAddress());
				for(SocketAddress sa:client_list) 
				{
					dp.setSocketAddress(sa);
					ds.send(dp);
				}
				//ds.send(dp);
				Arrays.fill(data, (byte)0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPReceiverTest();
		
	}

}
