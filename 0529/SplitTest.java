class  SplitTest
{
	public static void main(String[] args) 
	{
		String kittens = "����,����,���,ġ��"; 
		String []splitt = kittens.split(","); //�ϳ��� ���ڿ��� �и��ؼ� �迭�� �ִ´�.
		System.out.println(splitt.length); //�迭�� ����
		System.out.println(splitt[0]);
		System.out.println(splitt[1]); 
		System.out.println(splitt[2]); 
		System.out.println(splitt[3]); 

	}
}
