/* ����ڷκ��� ������ ������ �Է¹޾�
   ���� �� ���� 0���� ũ�ų� ������ �� ���� ���ϱ� 100�� �Ͽ�
   ����ϰ� �׷��� ������ �׼��� ������ ����ϴ� ���α׷�*/
import java.util.*;
class ConditionOperatorTest2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� n�� �Է����ּ���==> ");
		int n = sc.nextInt();
		int r;
		r = (n>=0)?n+100:n*n;
		System.out.println(r);
	}	
}
