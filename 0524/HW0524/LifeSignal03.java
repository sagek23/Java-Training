
import java.util.Scanner;
class LifeSignal03 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String name, yearSign="",r1="", 
			r3="�;ױ����ι�����������", 
			fResult ="";

		String r2="õ";
		int month, day, hour,num=0, 
			numY=0, numM=0, numD=0, numH;		

		System.out.println("�̸��� �Է��ϼ���: ");
		name = sc.next();
		System.out.println("�츦 �Է��ϼ���: ");
		yearSign = sc.next();
		System.out.println("������ �Է��ϼ���: ");
		month = sc.nextInt();
		System.out.println("������ �Է��ϼ���: ");
		day = sc.nextInt();
		System.out.println("���ø� �Է��ϼ���: ");
		System.out.println("0:��, 1:��, 2:�� 3:�� 4:�� 5:�� 6:�� 7:�� 8:�� 9:�� 10:�� 11:��  ==>");
		hour = sc.nextInt();

		System.out.println("�Է��Ͻ� ������ ������ �����ϴ�.");
		System.out.println(name+" �� : "+yearSign+" ��, "+month+" ��, "+day+" ��, "+hour+" ��");
		
		switch(yearSign){
			case "��":r1 ="õ��";num=0;break;
			case "��":r1 ="õ��";num=1;break;
			case "ȣ����":r1 ="õ��";num=2;break;
			case "�䳢":r1 ="õ��";num=3;break;
			case "��":r1 ="õ��";num=4;break;
			case "��":r1 ="õ��";num=5;break;
			case "��":r1 ="õ��";num=6;break;
			case "��":r1 ="õ��";num=7;break;
			case "������":r1 ="õ��";num=8;break;
			case "��":r1 ="õ��";num=9;break;
			case "��":r1 ="õ��";num=10;break;
			case "����":r1 ="õ��";num=11;break;
		}		
		System.out.println(r1);
		numM = month-1 + num;
		if(numM >= 12)
			//numM = numM - 12;
			numM = numM % 12;
		System.out.println( "" + r2  + r3.charAt(numM));

		numD = day-1 + numM;
		if(numD >= 12)
			//numD = numD - 12;
			numD = numD % 12;

		System.out.println( "" + r2  + r3.charAt(numD));

		numH = hour + numD;
		if(numH >= 12)
//			numH = numH - 12;
			numH = numH % 12;
		System.out.println( "" + r2  + r3.charAt(numH));
	}
}
