package exam2;

import java.util.Scanner;

public class ProcessScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []sco;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ������ �����ðڽ��ϱ�?==> ");
		int h = sc.nextInt();
		sco=new int[h];
		
		try {
		for (int i=0;i<h;i++)
		{
			System.out.print(i+1+"�� ������ �Է��ϼ���==> ");
			int score = sc.nextInt();
			sco[i]=score;
		}
		
		ProcessScore p = new ProcessScore(sco);
		}catch(IllegalScore e)
		{System.out.println(e.getMessage());}
		
	}

}
