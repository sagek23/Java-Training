package com.bit.io.filetest;

import java.io.FileWriter;

public class FileWriterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("c:/output/bit.txt");
			fw.write("�ȳ�");
			fw.close();
			System.out.println("file�� �����Ͽ����ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
