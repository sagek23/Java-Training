
/*4.Ű���忡�� ������ �ϳ��� �о ������ �������� �����ϴ� ���α׷� �ۼ�/
switch�� ���*/
import java.util.*;
class  HW5
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���ĺ��� �Է��Ͻÿ�==> ");
		char al = sc.next().charAt(0);

		switch (al)
		{
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				System.out.println("����");
				break;
			default:
				System.out.println("����");
				
		}
	}
}
