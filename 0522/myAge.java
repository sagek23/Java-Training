/*
연습) 다음을 차례대로 프로그래밍 해라.
	  -자신의 나이를 age변수에 저장
	  -자신의 나이에 10을 더하기 한 결과를 다시 age에 저장
	  -age의 값을 1증가시킨다.
	  -age의 값을 출혁한다.
*/
class  myAge
{
	public static void main(String[] args) 
	{
		int age = 29;
		int i = 10;
		age += i;
		//age++;
		++age;
		System.out.println(age);
	}
}
