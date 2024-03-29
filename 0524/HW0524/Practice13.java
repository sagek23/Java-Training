/*
  13. 피타고라스의 정리는 직각삼각형에서 직각을 낀
     두변의 길이를 a,b라고 하고,
     빗변의 길이를 c라고 한다면 a^2 +b^2  = c^2의 
     수식이 성립한다는 것이다.

    각변의 길이가 100보다 작은 삼각형 중에서 
    피타고라스의 정리가 성립하는 직각 삼각형은
    몇개나 있을까?
  3중 반복문을 이용하여 피타고라스의 정리를
    만족하는 3개의 정수를 찾도록 한다.
 */
public class Practice13 {

	public static void main(String[] args) {
	int a,b,c;
	int count=0;
	for(a = 1 ; a<=100 ; a++) {
		  for (b = 1; b<=100; b++) {
			  for (c = 1; c <= 100; c++) {
				  if (a*a+b*b==c*c) {
					  count++;
					  System.out.println("a: "+a+"/ b: "+b+"/ c: "+c+"인 직각삼각형");
				  }
			  }
		  }
	}
	
	
	System.out.println(count);
	}

}
