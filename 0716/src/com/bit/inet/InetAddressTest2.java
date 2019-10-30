package com.bit.inet;

import java.net.InetAddress;

public class InetAddressTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			InetAddress addr = InetAddress.getByName("www.naver.com");
			System.out.println(addr.getHostAddress());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
