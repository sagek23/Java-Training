/*
�̸��̷κ��� ���̵� �߶�ͼ� ���
*/
class	IdFromEmail 
{
	public static void main(String[] args) 
	{
		String email = "tiger@nate.com";
		int n = email.indexOf("@");
		String id = email.substring(0, n);
		System.out.println(id);
	}
}
