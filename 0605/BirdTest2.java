/*
setter
��������� ���� �����Ű�� ���� �޼ҵ�.
�����Ű������ ���� �Ű������� ���޹޾�
�װ��� ��������� �����Ѵ�.
*/
class Bird
{
	private String type;
	
	private String color;

	public void setType(String type)
	{
		this.type = type;
	}
	public void pro()
	{
		Scanner sc = new Scanner();
		System.out.print("���� ����?");
		String str = sc.next;
		type = str;
	}

	
}
class  BirdTest2
{
	public static void main(String[] args) 
	{
		Bird b1 = new Bird();
		//b1.type="����"; type�� private�̹Ƿ� ���ٺҰ�
		b1.setType="����"; //setter�� ����Ͽ� ��������� ���� ����
	}
}
