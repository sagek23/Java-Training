//print the names of the team members.
//c:/team/name.txt
import java.io.FileWriter;
import java.io.*;
class PrintToFileName 
{
	public static void main(String[] args)	
	{
		try{
		FileWriter fw = new FileWriter("c:/team/name.txt");
		fw.write("안재희,천석훈,김슬지,김해리,이재우,장은지");
		fw.close();
		System.out.println("파일을 생성하였습니다");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
