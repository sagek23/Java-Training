package hw2;

import java.util.Scanner;

class NotFoundException extends Exception
{
	public NotFoundException(String msg)
	{
		super(msg);
	}
}

public class SearchArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			int []arr= {1,2,3,4,5,6,7,8,9};
			System.out.print("���ڸ� �Է��ϼ���==> ");
			int a = sc.nextInt();
			int b=0;
			for(int i=0;i<arr.length;i++)
			{	
				if(arr[i]==a)
				{	
					b=arr[i];
					System.out.println(a+"��/�� �����մϴ�");
					break;
				}
			}
			if(b!=a)
			{
				throw new NotFoundException("�迭�� �������� �ʴ� �����Դϴ�");
			}
	
		}catch(NotFoundException e)
		{
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}
	}

}
