import java.util.Scanner;

class JavaHomework4_reference 
{
	public static void main(String[] args) 
	{
      Scanner sc = new Scanner(System.in);
      System.out.print("n==> ");
      int n = sc.nextInt(); 
      
      boolean b = true;
      for( int i = 2; i < n; i++)
      {   

   	 if(n % i == 0)
    	 {
    		 b= false;
    		 break;
    	 }
    	 
      }
      if(b==true && n!=1)
 
 		 System.out.println(n+"= �Ҽ�");
      else
    	  System.out.println(n+"= �Ҽ� �ƴ�");
      
	}
}

