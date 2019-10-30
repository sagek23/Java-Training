/*사용자로부터 키를 입력받아 표준쳬중을 계산한 후 사용자의 체중과 비교하여
저체중인지, 표준인지, 과체중인지를 판단하는 프로그램을 작성, 표준체중 계산식은 
다음을 사용. 
표준체중 = (키-100)*0.9, 표준체중의 범위를 -1, +1로 수정 */

import java.util.*;
class  AvrWeight1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("키를 입력하세요==>");
		double height = sc.nextDouble();
		double avr;
		avr =  (height - 100)*0.9;
		avr = Math.floor(avr); //소수점 이하 버리기
		String standard;
		System.out.print("체중을 입력하세요==>");
		double weight = sc.nextDouble();	
		
		if(weight>avr+1)
			standard = "과체중";
		else if (weight<avr-1)
			standard = "저체중";
		else
			standard = "표준";

		System.out.println(standard);
	}
}
