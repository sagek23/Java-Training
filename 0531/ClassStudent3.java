/*
�Ѹ��� �л��� ������ ó���ϱ����� �̸�, ����, ����, ����, ����� �ϳ��� ��Ʈ�� �����
*/
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
	int calc()
	{
		tot = kor+eng+math;
		avr = tot/3;
		return tot; //return�������� ��ȯ�Ǵ� �� �ϳ��� ����
	}
}
class ClassStudent3                                                                                                                                                                                                                                             
{
	public static void main(String[] args) 
	{
		Student s; //s��� ������ Student�ڷ������� ���
		s = new Student(); //new xxx�� ���� �޸𸮰� Ȯ���ȴ�.  new Student���� ��ü������ �ؾ� Student s�� ����� �� ����
		// new Student�� �����ϸ� ����  name; kor; eng, math, tot, avr��ŭ �޸𸮰� �����.
		//����� �����ϱ����ؼ��� .����̸� ex) .name .kor

		s.name = "ȫ�浿";
		s.kor = 80;
		s.eng = 90;
		s.math = 70;
		s.calc();//Class Student�� calc�� ȣ��

		System.out.println(s);
		System.out.println(s.calc());
	
	}
}