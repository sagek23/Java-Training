//���ڿ� ���� a�� �ҹ��� l�� ������ ���Ͽ� ����Ͻÿ�.
class CharTest6 
{
	public static void main(String[] args) 
	{
		String a = "Hello Hello";
		int n=0;
		for (int i=0 ; i<a.length() ; i++)
			//����.length�� ������ ������ �ִ� ���ڿ��� ���̸� �˷��ش�.
		{
			char b = a.charAt(i);
			if ( b == 'l' )
				n = n+1;
		}
		System.out.println("�ҹ��� l�� ������ " + n);
	}
}