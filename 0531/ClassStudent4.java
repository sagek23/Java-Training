/*
�Ѹ��� �л��� ������ ó���ϱ����� �̸�, ����, ����, ����, ����� �ϳ��� ��Ʈ�� �����
*/
import java.util.*;
class Student
{
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	int avr; //�Ӽ�, ���
	public String toString()
	{
		return "�̸�: "+name+", ���� :"+kor+", ����: "+eng+", ����: "+math+",����: "+tot+", ���: "+avr; 
	}
	void calc()
	{
		tot = kor+eng+math;
		avr = tot/3;
	}
}
class ClassStudent4                                                                                                                                                                                                                                             
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Student []s = new Student[5]; //int []a = new int[5];���� �������� 5�� ������ ��.
		for (int i=0;i<s.length ;i++ )
		{
			s[i] = new Student(); //��ü����
			System.out.print(i+1+"��° �л��� �̸�==> ");
			s[i].name = sc.next();
			System.out.print("����==> ");
			s[i].kor = sc.nextInt();
			System.out.print("����==> ");
			s[i].eng = sc.nextInt();
			System.out.print("����==> ");
			s[i].math = sc.nextInt();
			s[i].calc();
		}
		for (int i=0;i<s.length ; i++)
		{
			for (int j=i+1;j<s.length ;j++ )
			{
				if (s[j].avr > s[i].avr)
				{
					Student temp;
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
		for (int i=0;i<s.length ;i++ )
			System.out.println(s[i]);
	}
}
