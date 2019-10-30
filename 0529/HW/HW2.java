/*
다음 코드는 배열 a와 배열 b의 내용이 일치하는지를 알아보기 위하여
작성되었다. 배열이 올바르게 비교되는가? 만약 올바르지않다면 올바르게
수정하라.

int[] a = {1,2,3,4,5};   a는 1000번 값이 있는 메모리를 가리킴
int[] b = {6,7,8,9,10};  b는 2000번 값이 있는 메모리를 가리킴. 
if(a==b)  --> 가리키는 메모리의 주소가 같지 않으므로 ==를 쓰면 일치하지 않는다고 나온다.
	System.out.println("배열의 내용이 일치합니다.");
else
	System.out.println("배열의 내용이 일치하지 않습니다.");	
*/
import java.util.*;
class	HW2  
{
	public static void main(String[] args) 
	{
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3,4,5};
		if(Arrays.equals(a,b)) //배열의 내용 비교
			System.out.println("배열의 내용이 일치합니다.");
		else
			System.out.println("배열의 내용이 일치하지 않습니다.");	
	}
}
