//배열을 선언하고 초기값을 주지 않으면?
/*
기본자료형은 초기화 되지않지만 참조자료형은
초기화 된다
int 0
double 0.0
boolean false
*/
class  ArrayInitial
{
	public static void main(String[] args) 
	{
		double []b = new double[3];
		boolean []c = new boolean[3];
		System.out.println(b[0]);
		System.out.println(c[0]);
		//int b[] = new int[3];
		//System.out.println(b[0]);
		//int a;
		//int b[];
		//System.out.println(a);
		//System.out.println(b);
	}
}
