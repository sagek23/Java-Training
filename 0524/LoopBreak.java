class LoopBreak 
{
	public static void main(String[] args) 
	{
		int i = 1;
		for(;;)
		{	
			System.out.println("Hello World!");
			i++;
			if(i>3)
				break; //���� �� ������ �ִ� ��ġ�� �ݺ��� Ż��
		}
		System.out.println("�۾�����");
	}
}
