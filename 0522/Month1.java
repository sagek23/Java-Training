/*
����) ����ڿ��� ���� �Է¹޾� �� ���� ���ϱ��� �ִ��� �Ǻ��Ͽ� ����ϵ��� �Ѵ�.
*/
import java.util.*;
class  Month1
{
	public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int month,lastDay;
        System.out.print("���� �Է��ϼ���==>");
        month = sc.nextInt();
 
        //31 : 1,3,5,7,8,10,12
        //30 : 4,6,9,11
        //28 : 2
 
        if(month < 1 || month >12)
        {
            System.out.println("�Է°��� Ȯ���ϼ���");
            return;
        }
         
        if(month ==4 || month == 6 || month == 9 || month == 11)
        {
            lastDay = 30;
        }
        else if(month == 2)
        {
            lastDay = 28;
        }
        else
        {
            lastDay = 31;
        }
        System.out.println(month + "���� " + lastDay + "���� �־��");
    }
}


/*
31�� - 1, 3, 5,7,8, 10, 12
30�� - 4, 6, 9, 11
28�� - 2
*/