package homework1;

import java.util.ArrayList;
import java.util.Scanner;

// 몇명의 선수의 점수를 판정할 것인지 물어본다음
// 점수를 입력하도록 프로그램을 수정해 봅니다.

public class Scoreinput {
	
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Double> list = new ArrayList<Double>();
	
	
	public static void write()
	{
		for(Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
	
	public static void input() {
		
		double score = 0;
		
			for(int i=0; i<10 ; i++) {
				System.out.print(i+1+"번째 심사 위원님 점수를 입력하세요 ==> ");
				score = sc.nextDouble();
				if(score>10 || score <0) {
					System.out.println("0에서 10사이의 점수를 입력하지 않았습니다.");
					return;
				}
				
				list.add(score);
				
			}
		}		
	
	
	public static void main(String[]args) {
		input();
		double max=list.get(0);
		double min=list.get(0);
		int a=0,b=0;
		
		for(int i=1; i<10; i++) {
			if (list.get(i)>max) {
				max = list.get(i);
				a= i;
			}
		}
		for (int i=1; i<10; i++) {
			if (list.get(i)<min) {
				min = list.get(i);
				b= i;
			}
		}
		
		write();
		
		list.remove(a);
		list.remove(b);
		
		write();
		
		double r = 0;
		for(double v:list)
		{
			r+= v;
		}
		
		System.out.println("총합:"+r);
	}
}



