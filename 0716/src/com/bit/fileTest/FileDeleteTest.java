package com.bit.fileTest;

import java.io.File;

public class FileDeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname = "c:/output/fo.txt";
		try {
			File file = new File(fname);
			boolean a = file.delete();
			if(a==true)
			{
				System.out.println("���ϻ����Ϸ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
