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
}
class ClassStudent
{
	public static void main(String[] args) 
	{
		Student s; //s��� ������ Student�ڷ������� ���
		s = new Student(); //new xxx�� ���� �޸𸮰� Ȯ���ȴ�.
		// new Student�� �����ϸ� ����  name; kor; eng, math, tot, avr��ŭ �޸𸮰� �����.
		//����� �����ϱ����ؼ��� .����̸� ex) .name .kor

		s.name = "ȫ�浿";
		s.kor = 80;
		s.eng = 90;
		s.math = 70;
		s.tot = s.kor+s.eng+s.math;
		s.avr = s.tot/3;

		System.out.println(s.name);
		System.out.println("����: "+ s.tot);
		System.out.println("���: "+ s.avr);
	}
}