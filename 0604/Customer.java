class Customer
{
	String name;
	int age;
	public Customer(String name, int age) //������
	{
		this.name = name;
		this.age = age;
	}
	public String toString() //�Ӽ��� ��� ����ϱ����� toString
	{
		return name+", "+age;
	}
	public static void main(String[] args) //�� main()�� Customer�� ����޼ҵ尡 �ƴϴ�.
	{									   //Customer�ȿ� main()�� ǥ���� �� �ִ�.
		Customer c = new Customer("�踸��", 7);
		System.out.println(c);
	}
}
