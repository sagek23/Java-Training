package hw3;

import java.util.Scanner;

public class ProcessScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProcessScore ps = new ProcessScore();
		try {
		System.out.print("����� ������ �Է��Ͻðڽ��ϱ�?");
		int h = sc.nextInt();
		
		for(int i=0;i<h;i++)
		{	
			System.out.print("������ �Է��ϼ���==> ");
			double sco = sc.nextDouble();
			if(sco<0)
			{
				throw new IllegalScore("����� �Է��ϼ���");
			}
			ps.s.add(sco);
		}
		ps.Score();
		ps.Avg();
		}catch(IllegalScore e)
		{
			System.out.println("����� �Է��ϼ���");
		}
		
		
	}

}
