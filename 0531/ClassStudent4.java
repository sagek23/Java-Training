/*
한명의 학생의 정보를 처리하기위한 이름, 국어, 수학, 총점, 평균을 하나의 세트로 만든다
*/
import java.util.*;
class Student
{
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	int avr; //속성, 멤버
	public String toString()
	{
		return "이름: "+name+", 국어 :"+kor+", 영어: "+eng+", 수학: "+math+",총점: "+tot+", 평균: "+avr; 
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
		Student []s = new Student[5]; //int []a = new int[5];같이 참조변수 5개 생성한 것.
		for (int i=0;i<s.length ;i++ )
		{
			s[i] = new Student(); //객체생성
			System.out.print(i+1+"번째 학생의 이름==> ");
			s[i].name = sc.next();
			System.out.print("국어==> ");
			s[i].kor = sc.nextInt();
			System.out.print("영어==> ");
			s[i].eng = sc.nextInt();
			System.out.print("수학==> ");
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
