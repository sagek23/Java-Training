/*상점에서 하나에 100원인 물건을 판매하고 있다고 가정하자. 물건을 10개 이상
구입하는 고객에게는 10%를 할인해준다고 하자. 사용자가 구입한 물건의 개수를 
입력하면 전체가격이 얼마인지를 계산해주는 프로그램을 작성하라. 즉 물건의
개수가 10이상이면 10% 할인한 가격으로 계산을 하여아한다. if-else문을 사용하라*/
import java.util.*;
class  Discount
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("10개 이상을 구입하시면 10% 할인해드립니다.");
		System.out.print("구입하신 물건의 개수를 입력해주세요==> ");
		int purchase = sc.nextInt();
		double price;

		if (purchase>=10)
		{
			price = (purchase*100)*0.9;
			System.out.println("10% 할인받으실 수 있습니다");
		}
		else	
			price = purchase*100;
		
		System.out.println(price+"원 입니다");
		
	}
}
