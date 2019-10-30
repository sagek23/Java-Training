/*사용자로부터 키를 입력받아 표준쳬중을 계산한 후 사용자의 체중과 비교하여
저체중인지, 표준인지, 과체중인지를 판단하는 프로그램을 작성, 표준체중 계산식은 
다음을 사용. 
표준체중 = (키-100)*0.9 */
import java.util.*;
class  AvrWeight
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("키를 입력하세요==>");
		double height = sc.nextDouble();
		double avr;
		avr = (height - 100)*0.9;
		System.out.print("체중을 입력하세요==>");
		double weight = sc.nextDouble();
		
		if (weight>avr)
			System.out.println("과체중입니다");
		else if (weight<avr)
			System.out.println("저체중입니다");
		else
			System.out.println("표준입니다");

		
	}
}
