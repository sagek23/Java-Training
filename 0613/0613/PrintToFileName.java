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
		fw.write("������,õ����,�载��,���ظ�,�����,������");
		fw.close();
		System.out.println("������ �����Ͽ����ϴ�");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}