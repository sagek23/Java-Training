
/*���ڿ��� ���� ������ �Ǻ��Ϸ��� ==���Ұ�.
equals()�޼ҵ带 ����ؾ���*/
import java.util.*;
class  StringEquals
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.print("�̸��Է� ==> ");
		name = sc.next();

		//if(name == "tiger")
		if(name.equals("tiger"))
			System.out.println("tiger�Դϴ�");
		else
			System.out.println("tiger�� �ƴմϴ�");
	}
}