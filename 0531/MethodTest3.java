class  MethodTest3
{
	public static void sayHello(String name) //�޼ҵ��� ���� //name�� �Ű�����
	{
		for (int i=1;i<=3 ; i++)
			System.out.println(name+"��/�� �ȳ�");
		
	}

	public static void main(String[] args) 
	{
		sayHello("����"); //�޼ҵ� ȣ��
		int year = 2019;
		System.out.println("���ش� "+year);
		
		sayHello("����");

		String name = "��Ʈķ��";
		System.out.println("�츮�� �ִ� ���� "+name);
		
		sayHello("����");


	}
}