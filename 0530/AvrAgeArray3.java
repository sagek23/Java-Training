/*�������� ���̸� �迭�� �����ϰ�
������ ���հ� ����� ���Ͽ� ���
������ ��� 6���̰� ������ ���̴�
26, 30, 26, 27, 32, 20
*/
class  AvrAgeArray3
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		int []ages ={26,30,26,27,32,20}; 
		System.out.println("����: ");
		for (int d:ages) //for each �ݺ���
		{
			System.out.print(d+" ");
		}
		System.out.println();
		for (int c:ages)
		{
			sum +=c;
		}
		int avr = sum/ages.length;
		System.out.println("���� ����: "+sum);
		System.out.println("���� ���: "+avr);
	}
}
