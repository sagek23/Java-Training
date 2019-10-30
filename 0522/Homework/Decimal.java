class  Decimal
{
	public static void main(String[] args) 
	{
		double a =56.3534534;
		//a = new Double(String.format("%.2f",a)); //자료형 포장
		//반올림하여 소수 둘째자리까지 출력.
		//반올림하지않고 소수 둘째짜리까지 출력하려면?
		System.out.println(Math.floor(a*100)/100.0);
		//String b = String.format("%.2f",a) //2f->소수점 둘째자리까지 표현
		System.out.println(a);
	}
}
