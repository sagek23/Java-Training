//����1: 101~109�� ������ �Ϲ�ʶ��̶�� ���´�;;
//����2: 240 �̻� ���ڸ� ������ ������ ���;; <<-- �̰� �����帳�ϴ�!!

import java.util.Scanner;
public class hw1_2 {
	public static void main(String []args)
	{Scanner sc = new Scanner(System.in);
	System.out.print("0���� 999 ���� ������ �Է��ϼ���: ");
	int n = sc.nextInt();
	int m= (n/10);
	int b= (n/100);
	

	/*String�� �ڲ� �ݺ��Ͽ� ���ŵǹǷ�
	 ��������ʴ� ������ �޸𸮰� ���� 
	 �޸� ���������� �Ͼ��*/

	String str = " ���̻�����ĥ�ȱ�";
		for (int i=0; i<=(m); i++)
			str += str;
			if (n ==0)
				System.out.println("��");
			else if (n>0 && n<10)
				System.out.println(str.charAt(n));
			else if (n>=10 && n<100)
				System.out.println(str.charAt(m)+"��.."+str.charAt(n));
			else if (n>=100 && n<1000)
				System.out.println(str.charAt(b)+"��"+str.charAt(m)+"��.."+str.charAt(n));

			else
				System.out.println("�Է°��� �ٽ� Ȯ���ϼ���.");


	
	}
}