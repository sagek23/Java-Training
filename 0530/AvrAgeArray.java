/*�������� ���̸� �迭�� �����ϰ�
������ ���հ� ����� ���Ͽ� ���
������ ��� 6���̰� ������ ���̴�
26, 30, 26, 27, 32, 20
*/
class  AvrAgeArray
{
	public static void main(String[] args) 
	{
		int sum=0;
		int age;
		//int []age ={26,30,26,27,32,20}; 
		int []ages = new int[6];
		ages[0]=26;
		ages[1]=30;
		ages[2]=26;
		ages[3]=27;
		ages[4]=32;
		ages[5]=20;
		//ages[6]=50; �迭�� ������ �ʰ��ϹǷ� ����
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