package com.bit.io.filetest;

import java.io.FileReader;

public class FileReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("c:/output/bit.txt");
			int ch;
			while((ch=fr.read())!=-1)
			{
				//System.out.println(ch);
				System.out.print((char)ch);
			}
			
			fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
