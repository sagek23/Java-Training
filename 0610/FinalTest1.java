class A
{
	int a = 3;
	final static int YEAR=2019;
	/*�ٸ� ��������� �����ϱ� ���� �Ϲ�������
	����� ��� �빮�ڷ� �����
	final�� ������ �� ���� ����� �ǹ�.
	��, ��ü���� ������ �޸𸮸� Ȯ���� �ʿ䰡 ������
	static���� ����� ���� ����*/
}
class FinalTest1 
{
	public static void main(String[] args) 
	{
		A aa = new A();
		aa.a=6;
		aa.YEAR = 2020;
		//System.out.println("Hello World!");
	}
}
