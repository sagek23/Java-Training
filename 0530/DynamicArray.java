/*
자료에 추가, 삭제가 빈번한 경우에는 배열을 사용하기 불편.
그래서 대신 자바의 컬렉션 프레임웍을 사용.
Set, List, Map
	Set은 중복을 허용하지 않는 데이터처리에 유용
	List는 중복을 허용
	Map은 key와value가 한쌍으로 이루어진 자료구조
*/
import java.util.ArrayList;
class  DynamicArray
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> ages = new ArrayList<>();
		ages.add(24);
		ages.add(30);
		ages.add(27);
		ages.add(20);
		ages.add(32);
		ages.add(26);
		System.out.println(ages);
		ages.add(25);
		ages.add(26); //데이터 추가
		System.out.println(ages);
		ages.remove(1);
		System.out.println(ages); //데이터 삭제

		int sum = 0;
		for (int a:ages ) //(int i=0, i<ages.size();i++)
		{	
			sum+=a; //sum+=ages.get(); ArrayList의 .get은 특정위치에 있는 것을 돌려줌. 
		}
		System.out.println("나이 총합: "+sum);
		System.out.println("나이 총합: "+sum/ages.size()); //ArrayList의 길이를 표현

	}
}
