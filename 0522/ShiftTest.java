class ShiftTest 
{
	public static void main(String[] args) 
	{
		int a = 8; //8�� �������� ����� �־��� ��Ʈ ����ŭ �̵�
				   /* ex) 8�� �������� 1000. �̰��� �������� 
				   �Ѻ�Ʈ �̵��ϸ� 10000�̹Ƿ� 16. ����������
				   �Ѻ�Ʈ �̵��ϸ� 100�̹Ƿ� 4�̴�*/ 
		int i = a << 1;
		System.out.println(i);
		int j = a >> 1;
		System.out.println(j);
	}
}