package homework1;

import java.util.ArrayList;
import java.util.Scanner;

// ����� ������ ������ ������ ������ �������
// ������ �Է��ϵ��� ���α׷��� ������ ���ϴ�.

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
				System.out.print(i+1+"��° �ɻ� ������ ������ �Է��ϼ��� ==> ");
				score = sc.nextDouble();
				if(score>10 || score <0) {
					System.out.println("0���� 10������ ������ �Է����� �ʾҽ��ϴ�.");
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
		
		System.out.println("����:"+r);
	}
}



