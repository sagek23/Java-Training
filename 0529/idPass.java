//����ڿ��� ���̵�� ��ȣ�� �Է¹޾� ���.�� ���̵�� ��ȣ�� 8�� �̻��� ��.
import java.util.*;
class  idPass
{
	public static void main(String[] args) 
	{
	
			Scanner sc = new Scanner(System.in);
			System.out.print("id�� �Է��Ͻÿ�==> ");
			String id = sc.next();
			System.out.print("�н����带 �Է��Ͻÿ�==> ");
			String pass = sc.next();
				while (true)
		{	
				if (id.length()<8)
				{
					System.out.println("id�� 8�� �̻��̾�� �մϴ�");
					System.out.print("id�� �ٽ� �Է��Ͻÿ�==> ");
					id = sc.next();
				}
		
			
				if (pass.length()<8)
				{
					System.out.println("�н������ 8�� �̻��̾�� �մϴ�");
					System.out.print("�н����带 �ٽ� �Է��Ͻÿ�==> ");
					pass = sc.next();
				}
		
				if (id.length()>=8 && pass.length()>=8)
				{
					System.out.println("�ùٸ��� �Է��Ͽ����ϴ�");
					break;
				}
		}
		System.out.println("id= "+id);
		System.out.println("password= "+pass);
				
	}
}