/*
�̹��� ����Ͽ� ������ �ζǹ�ȣ 6���� ���Ͽ� �迭�� ��ƶ�.
*/
class  ArrayTest
{
	public static void main(String[] args) 
	{
		int lotto[]= new int[6]; //�ڸ���ȣ�� 0���� ����. �迭�� ����� n���̸� ��밡���� �ڸ���ȣ�� 0~n-1�̴�.
		lotto[0] =7;
		lotto[1] =8;
		lotto[2] =9;
		lotto[3] =15;
		lotto[4] =44;
		lotto[5] =38;

		for (int i=0;i<=lotto.length-1 ;i++ )
		{
			System.out.println(lotto[i]);
		}
		
	}
}
