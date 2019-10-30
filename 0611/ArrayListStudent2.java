package exam1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListStudent2 {
	public static void menu()
	{
		System.out.println("번호를 선택하시오==> ");
		System.out.println("1.추가 2.출력 3.종료");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		while(true)
		{
			menu();
			sel=sc.nextInt();
			if (sel==3)
				break;
			switch(sel)
			{
				case 1:inputData(al);break;
				case 2:printData(al);break;
			}
		}
	}
	private static void printData(ArrayList al) {
		// TODO Auto-generated method stub
		for (Object obj:al)
		{
			System.out.println(obj);
		}
	}
	private static void inputData(ArrayList al) {
		// TODO Auto-generated method stub
		String name, adrs, tel;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력==> ");
		name = sc.next();
		System.out.print("주소 입력==> ");
		adrs = sc.next();
		System.out.print("전화번호 입력==> ");
		tel = sc.next();
		al.add(new Student(name,adrs,tel));
	}

}
