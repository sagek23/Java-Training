
import java.util.Scanner;
class LifeSignal04 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String name,r1="", 
			r3="�;ױ����ι�������������", 
			fResult ="";
		//�迭: �ڷ����� ���� �������� ����
		String []yearSign= {"��","��","��","�䳢","��","��","��","��","������","��","��","����"};
		String []detail = {
			"��� ������ ���δ����� �޾ƿ�", //��
			"�ܺ�ġ���� ������ ����", //��
			"�������� �ִ� ���", //��
			"�ؿܷ� �� ���� ����", //��
			"�ΰ����� ����", //��
			"�Ӹ��� ����", //��
			"�ϴ÷κ��� ���� ����", //��
			"�ܷο��� ���� Ž", //��
			"�پ��� ��鿡 ������ ����", //��
			"����ں��� ����", //��
			"�����ְ� ����", //��
			"���� ��." //��
		};
		String r2="õ";
		int month, day, hour,num=0, 
			numY=0, numM=0, numD=0, numH;		

		System.out.println("�̸��� �Է��ϼ���: ");
		name = sc.next();
		System.out.println("�츦 �Է��ϼ���: ");
		System.out.println("0:��, 1:��, 2:�� 3:�䳢 4:�� 5:�� 6:�� 7:�� 8:������ 9:�� 10:�� 11:����  ==>");
		num = sc.nextInt();
		System.out.println("������ �Է��ϼ���: ");
		month = sc.nextInt();
		System.out.println("������ �Է��ϼ���: ");
		day = sc.nextInt();
		System.out.println("���ø� �Է��ϼ���: ");
		System.out.println("0:��, 1:��, 2:�� 3:�� 4:�� 5:�� 6:�� 7:�� 8:�� 9:�� 10:�� 11:��  ==>");
		hour = sc.nextInt();

		System.out.println("�Է��Ͻ� ������ ������ �����ϴ�.");
		System.out.println(name+" �� : "+yearSign[num]+"��, "+month+"��, "+day+"��, "+hour+"��");
		
		r1 = r2+ r3.charAt(num) +"";		
		System.out.print(r1+": ");
		System.out.println(detail[num]);
		numM = month-1 + num;
		if(numM >= 12)
			//numM = numM - 12;
			numM = numM % 12;
		System.out.print(r2  + r3.charAt(numM)+": ");
		System.out.println(detail[numM]);

		numD = day-1 + numM;
		if(numD >= 12)
			//numD = numD - 12;
			numD = numD % 12;

		System.out.print(r2  + r3.charAt(numD)+": ");
		System.out.println(detail[numD]);

		numH = hour-1+ numD;
		if(numH >= 12)
//			numH = numH - 12;
			numH = numH % 12;
		System.out.print(r2  + r3.charAt(numH)+": ");
		System.out.println(detail[numH]);
	}
}