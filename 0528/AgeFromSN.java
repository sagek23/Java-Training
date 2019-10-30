import java.util.Date;
class  AgeFromSN
{
	public static void main(String[] args) 
	{
		String snum = "910101-1234567";
		String bYear = "19"+snum.substring(0,2);

		System.out.println(bYear);
		int year = Integer.parseInt(bYear);  //문자를 정수로 바꿔주는 래퍼 클래스(문자가 숫자일 경우만 가능)
		Date today = new Date();
		int tYear = today.getYear()+1900;
		int age = tYear - year;
		System.out.println(age);
	}
}
