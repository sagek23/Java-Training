//����ڿ��� �ֹι�ȣ�� �Է¹޾� ������ �Ǻ��϶�
import java.util.*;
class  SocialNum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��Ͻÿ�==> ");
		String num = sc.next();
		//String w = "2";
		//String ww = "4";
		String a = num.charAt(7)+"";

		//System.out.println(a);
		if (a.equals("2") || a.equals("4"))
			System.out.println("����");
		else if (a.equals("1") || a.equals("3"))
			System.out.println("����");
		else
			System.out.println("�߸��Է��Ͽ����ϴ�.");
	}
}