/*
���� �ڵ�� �迭 a�� �迭 b�� ������ ��ġ�ϴ����� �˾ƺ��� ���Ͽ�
�ۼ��Ǿ���. �迭�� �ùٸ��� �񱳵Ǵ°�? ���� �ùٸ����ʴٸ� �ùٸ���
�����϶�.

int[] a = {1,2,3,4,5};   a�� 1000�� ���� �ִ� �޸𸮸� ����Ŵ
int[] b = {6,7,8,9,10};  b�� 2000�� ���� �ִ� �޸𸮸� ����Ŵ. 
if(a==b)  --> ����Ű�� �޸��� �ּҰ� ���� �����Ƿ� ==�� ���� ��ġ���� �ʴ´ٰ� ���´�.
	System.out.println("�迭�� ������ ��ġ�մϴ�.");
else
	System.out.println("�迭�� ������ ��ġ���� �ʽ��ϴ�.");	
*/
import java.util.*;
class	HW2_ 
{
	public static void main(String[] args) 
	{
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3,4,5};
		if (a.length!=b.length)
		{
			System.out.println("�� �迭�� �޶��");
			return;
		}
		int c = 0;
		for (int i=0;i<a.length;i++ )
		{
			
			if (a[i]!=b[i])
			c+=1;		
		}

		if (c>0)
			System.out.println("�迭�� ������ ��ġ���� �ʽ��ϴ�.");
		else
			System.out.println("�迭�� ������ ��ġ�մϴ�.");
	//	if(Arrays.equals(a,b)) //�迭�� ���� ��
		//	System.out.println("�迭�� ������ ��ġ�մϴ�.");
	//	else
			//System.out.println("�迭�� ������ ��ġ���� �ʽ��ϴ�.");	
	}
}