class  MethodTest4
{
	public static void sayHello(String name, int n) //�޼ҵ��� ���� /name�� �Ű����� /n�� �ݺ��ϰ� ���� ����
	{
		for (int i=1;i<=n ; i++)
			System.out.println(name+"��/�� �ȳ�");
		
	}

	public static void main(String[] args) 
	{
		sayHello("����",3); //�޼ҵ� ȣ��
		int year = 2019;
		System.out.println("���ش� "+year);
		
		sayHello("����",2);

		String name = "��Ʈķ��";
		System.out.println("�츮�� �ִ� ���� "+name);
		
		sayHello("��",1);


	}
}
