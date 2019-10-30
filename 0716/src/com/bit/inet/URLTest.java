package com.bit.inet;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

public class URLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String addr= "http://www.hanbit.co.kr/edu/books/new_book_list.html";
		//String(byte [] bytes, Charset charset)
		byte [] data = new byte[500];
		try {
			URL url = new URL(addr);
			InputStream is = url.openStream();
			int ch;
			String str="";
			
			while((ch=is.read(data))!=-1)
			{
				String s = new String(data, "UTF-8");
				str += s;
				Arrays.fill(data, (byte)0);
			}
			is.close();
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
