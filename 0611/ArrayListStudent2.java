package exam1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListStudent2 {
	public static void menu()
	{
		System.out.println("��ȣ�� �����Ͻÿ�==> ");
		System.out.println("1.�߰� 2.��� 3.����");
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
		System.out.print("�̸� �Է�==> ");
		name = sc.next();
		System.out.print("�ּ� �Է�==> ");
		adrs = sc.next();
		System.out.print("��ȭ��ȣ �Է�==> ");
		tel = sc.next();
		al.add(new Student(name,adrs,tel));
	}

}