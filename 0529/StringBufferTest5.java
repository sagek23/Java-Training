/*

*/
class StringBufferTest5
{ 
	public static void main(String[] args)   
	{
		StringBuffer sb = new StringBuffer("ģ���� ����߳�");  //append�� ���ڿ� �� �ڿ� �߰�
		//sb�� �� �տ� "ģ����"�� �߰�
		System.out.println(sb.insert(0, "ģ���� ")); //insert�� ���ϴ� ��ġ�� ����  
	}
}
