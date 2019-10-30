package com.bit.fileTest;

import java.io.File;

public class FileTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fname1 = "c:/output";
			String fname2 = "c:/output/fff.txt";
			File file = new File(fname1);
			File file2 = new File(fname2);
			
			if(file.isDirectory()==true)
			{
				file.delete();
				System.out.println("디렉토리 삭제");		
			}
			if(file2.isFile()==true)
			{
				file2.delete();
				System.out.println("파일 삭제");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
