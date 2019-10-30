package hw3;

import java.util.Scanner;

public class ProcessScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProcessScore ps = new ProcessScore();
		try {
		System.out.print("몇명의 점수를 입력하시겠습니까?");
		int h = sc.nextInt();
		
		for(int i=0;i<h;i++)
		{	
			System.out.print("점수를 입력하세요==> ");
			double sco = sc.nextDouble();
			if(sco<0)
			{
				throw new IllegalScore("양수를 입력하세요");
			}
			ps.s.add(sco);
		}
		ps.Score();
		ps.Avg();
		}catch(IllegalScore e)
		{
			System.out.println("양수를 입력하세요");
		}
		
		
	}

}
