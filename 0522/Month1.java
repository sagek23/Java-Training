/*
연습) 사용자에게 월을 입력받아 그 월은 몇일까지 있는지 판별하여 출력하도록 한다.
*/
import java.util.*;
class  Month1
{
	public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int month,lastDay;
        System.out.print("월을 입력하세요==>");
        month = sc.nextInt();
 
        //31 : 1,3,5,7,8,10,12
        //30 : 4,6,9,11
        //28 : 2
 
        if(month < 1 || month >12)
        {
            System.out.println("입력값을 확인하세요");
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
        System.out.println(month + "월은 " + lastDay + "까지 있어요");
    }
}


/*
31일 - 1, 3, 5,7,8, 10, 12
30일 - 4, 6, 9, 11
28일 - 2
*/