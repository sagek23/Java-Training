package exam01;

public class SearchArray 
{
	public static void search(int []arr,int v) throws NotFoundException
	{
		int i = 0;
		
			for (i=0;i<arr.length;i++)
			{
				if(arr[i]==v)
				{
					System.out.println(v+"��/�� �ֽ��ϴ�");
					break;
				}
	
				if(i>=arr.length)
				{	
					throw new NotFoundException("�迭�� �������� �ʽ��ϴ�");
				}
			}
	}
}
