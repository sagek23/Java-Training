package exam1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListStudent3 {
	public static void searchData(ArrayList al) 
	{
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.print("�˻��� �л��� �̸��� �Է��Ͻÿ�==> ");
		name = sc.next();
		boolean flag = false;
		for (Object obj : al)
		{
			Student stu = (Student)obj;
			if(stu.getName().equals(name))
			{	System.out.println(stu);
				flag = true;
			}
		}
		if(flag ==false)
			System.out.println("ã�� �̸��� �����ϴ�");
	}
	public static void menu()
	{
		System.out.println("��ȣ�� �����Ͻÿ�==> ");
		System.out.println("1.�߰� 2.��� 3.�˻� 4.���� 0.����");
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
			if (sel==0)
				break;
			switch(sel)
			{
				case 1:inputData(al);break;
				case 2:printData(al);break;
				case 3:searchData(al);break;
				case 4:deleteData(al);break;
			}
		}
	}
	private static void deleteData(ArrayList al) {
		// TODO Auto-generated method stub
		try {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.print("������ �л��� �̸��� �Է��Ͻÿ�==> ");
		name = sc.next();
		boolean flag = false;
		for (Object obj:al)
		{
			Student stu = (Student)obj;
			if(stu.getName().equals(name))
			{	
				al.remove(stu);
				flag = true;
			}
		}
		if(flag ==false)
			System.out.println("ã�� �̸��� �����ϴ�");
		}
		catch(Exception e)
		{
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
