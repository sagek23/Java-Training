/*�������� ���̸� �迭�� �����ϰ�
������ ���հ� ����� ���Ͽ� ���
������ ��� 6���̰� ������ ���̴�
26, 30, 26, 27, 32, 20
*/
class  AvrAgeArray2
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		int []ages ={26,30,26,27,32,20}; 
		System.out.println("����: ");
		for (int j=0;j<ages.length ;j++ )
		{
			System.out.print(ages[j]+" ");
		}
		System.out.println(" ");
		for (int i=0;i<ages.length ; i++)
		{
			age = ages[i];
			sum +=age;
		}
		int avr = sum/ages.length;
		System.out.println("���� ����: "+sum);
		System.out.println("���� ���: "+avr);
	}
}
