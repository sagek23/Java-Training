/*
������ ���� �����ϴ� ���α׷��� while���� �̿��Ͽ� �ۼ�
<���࿹>
������ �߿� ����� ����ұ��? 2
2*1 = 2
..
*/
import java.util.*;
class  WhileGugu
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ����� ����ұ�==> ");
		int n = sc.nextInt();
		int i = 1;
		while(i <= 9)
		{
			System.out.println(n+"*"+i+"="+(n*i));
			i++;
		}
	}
}