/*����ڿ��� n�� �Է¹޾� n!�� ���϶�*/
import java.util.*;
class ForPrac6
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("n�� �Է��Ͻÿ�==> ");
		int n = sc.nextInt();
		int facto=1;
		int i;
		for (i=n; i>0; i--)
		{
				if (i>1)
					System.out.print(i+"*");
				else
					System.out.print(i+"=");
			facto = facto*i;	
		}
		
		System.out.println(facto);
	}
}

	//facto = facto*i;