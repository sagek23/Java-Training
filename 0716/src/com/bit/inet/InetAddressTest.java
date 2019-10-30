package com.bit.inet;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			InetAddress [] addr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ad:addr)
			{
				System.out.println(ad);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
