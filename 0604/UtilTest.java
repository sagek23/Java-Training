/*
� Ŭ������ �Ӽ������� ������ ���� �ְ� 
��ɸ����� ������ ���� �ִ�.

�ΰ��� ������ �Ű������� ���޹޾� ���߿� ū���� ã��
��ȯ�ϴ� �޼ҵ带 ���� Ŭ����
*/
class Util
{
	public int getMax(int a, int b) //��ɸ����� ����.
	{
		int max;
		if (a>b)
			max = a;//return a;
		else
			max = b; //return b;

		return max;
	}
}
class  UtilTest
{
	public static void main(String[] args) 
	{
		Util u = new Util(); //��ü���� �� �Ű������� �ַ��� �����ڰ� �־����
		//u.getMax(2,3);
		System.out.println(u.getMax(10,34));
	}
}
