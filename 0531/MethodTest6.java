class MethodTest6
{
	public static int plus(int a, int b)  //int a,b�� �Ұ�. return���� �������� �޼ҵ� �̸��տ� 
										 //�����ϴ� ���� �ڷ����� Ÿ���� �־����. ���ϰ��� ���� ���� void 
	{
		int r = a+ b;
		//System.out.println("���: " +r);
		return + r; //���ϰ��� ����
	}
	public static void main(String[] args) 
	{
		int r1 = plus(2,3);
		System.out.println("���: "+r1);
		r1 = plus(267,3);
		System.out.println("���: "+r1);
	}
}
