//�������� ��ճ��̸� ���϶�
class StringAvr 
{
	public static void main(String[] args) 
	{
		String age = "26,27,30,40,41,21";
		String []ages = age.split(",");//split�� ����Ͽ� �и��� ����� �迭�� �ȴ�.
		int sum=0; //������ ��
		int avr; //������ ���
		int a; //ages�� ������ �ٲ� ��
		int mem=ages.length;
		String b; //age�� ,�� �������� split�� ��.
		for (int i=0; i<ages.length ;i++ ) 
		{
			b = ages[i];
			a = Integer.parseInt(b);	
			sum+=a;
		}
		avr = sum/mem;
		System.out.println(avr);
	
	}
}

	//ages[0].trim();�迭���� Ʈ���� ����Ϸ��� �̷��� ���.