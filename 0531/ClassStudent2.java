/*
한명의 학생의 정보를 처리하기위한 이름, 국어, 수학, 총점, 평균을 하나의 세트로 만든다
*/
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
class ClassStudent2                                                                                                                                                                                                                                             
{
	public static void main(String[] args) 
	{
		Student s; //s라는 변수를 Student자료형으로 사용
		s = new Student(); //new xxx는 힙에 메모리가 확보된다.
		// new Student를 선언하면 힙에  name; kor; eng, math, tot, avr만큼 메모리가 생긴다.
		//멤버에 접근하기위해서는 .멤버이름 ex) .name .kor

		s.name = "홍길동";
		s.kor = 80;
		s.eng = 90;
		s.math = 70;
		s.calc();

		System.out.println(s);
	
	}
}
