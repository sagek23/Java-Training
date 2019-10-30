/*
<심리테스트>
숲속길을 걷고 있는데 열쇠가 떨어져있다.
1)줍는다
2)줍지않는다
2번
(살면서 요행을 바라는가 바라지 않는가)

2.왕자님이나 공주님이 살고있을것 같은 성이 나타났다.
담의 높이는 어느정도이면 좋을까?
3미터
(이성에게 벽을 세우는 높이)

3. 성안으로 들어다니 방이 많다. 
첫번째 방문을 열어보니 이방은 온통 하얀색의 방이다.
가구, 벽지 등 모두 하얀색의 방이다.
이때 어떤 느낌일지 적어라.
별 생각없음
(태어났을 때 느낌)

4. 그 다음 방문을 열었더니 그 방에는 창문, 침대, 
옷장이 있다. 창문을 열어보싶고 침대에 앉아보고 싶고
옷장을 열고싶다. 궁금한 순서대로 나열해라. 
옷장-창문-침대
(배우자를 고를 때 보는 것 재산-배경-그 사람 자신)

5. 창문을 열었더니 창문 밖에 수영장이 보인다.
거기에 남친이 수영을 하고있다.
그때 당신의 행동은?
뭐하냐고 소리친다
(배우자가 외도시 행동)

6. 마지막 방문을 열어보니 깜깜한 방이지만 어디선가
커피향이 난다. 그때 당신의 행동은?
들어가지 않는다.
(죽을을 받아들이는 태도)
*/
import java.util.*;
class  PsyTest2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

			System.out.println("1. 숲속길을 걷고 있는데 예쁜 열쇠가 떨어져있다. 당신은 어떻게 하겠는가");
			System.out.print("1)줍는다 2)줍지않는다==>" );
			int a = sc.nextInt();
			
			if(a==1 || a==2)
				while(true)
				{	
					if(a==1)
					System.out.println("줍는다를 선택한 당신은 인생에서 요행을 바라는 사람이다");
					else if (a==2)
					System.out.println("줍는다를 선택한 당신은 인생에서 요행을 바라지않고 정직하게 사는 사람이다");
					System.out.println("");	
						break;
					else
					System.out.print("번호를 다시 선택하세요==> ");
				}
				
			/*
			if (a!=1 && a!=2)
				while (true)
				{		
					if(a>=3 || a<=0)
					System.out.print("번호를 다시 선택하세요==> ");
					a = sc.nextInt(); 
				}
			*/
				
	
			System.out.println("2. 왕자님이나 공주님이 살고있을것 같은 성이 나타났다. 담의 높이는 어느정도이면 좋을까?");
			System.out.print("1)없다 2)1m 3)2m이상==> " );
			int b = sc.nextInt();
			System.out.println("성의 높이는 이성에게 벽을 세우는 높이를 뜻한다");
			if (b==1)
			System.out.println("없다를 선택한 당신은 이성을 벽을 세우지않고 잘 지내는 사람이다");
			else if (b==2)
			System.out.println("1m를 선택한 당신은 이성에게 벽을 세우기는 하지만 높지는 않으므로 이성관계가 나쁘지않다");
			else if (b==3)
			System.out.println("2m이상 선택한 당신은 이성에게 높은 벽을 세우는 사람으로 이성관계에 불편함을 느끼고 있을지도 모르겠다");
			else
			System.out.print("번호를 다시 선택하세요==> ");
			System.out.println("");
			
			sc.nextLine();
			System.out.println("3. 성안으로 들어다니 방이 많다. 첫번째 방문을 열어보니 이방은 온통 하얀색의 방이다.가구, 벽지 등 모두 하얀색의 방이다.이때 어떤 느낌일지 적어라.");
			String c = sc.nextLine();
			System.out.println(c+": 이것은 자신이 태어났을 때의 느낌입니다");
			System.out.println("");

			System.out.println("4. 그 다음 방문을 열었더니 그 방에는 창문, 침대, 옷장이 있다. 창문을 열어보싶고 침대가 푹신한지 앉아보고 싶고 옷장에 뭐가 있는지 궁금하다. 무엇을 가장 먼저 할 것인지 적어라.");
			String d = sc.next();
			System.out.println("이것은 당신이 배우자를 선택할 때 가장 중요시 하는 것입니다");
			if (d.equals("창문"))
			System.out.println(d+"을 선택한당신은 배우자를 선택할때 그 사람의 배경을 가장 중요시합니다");
			else if(d.equals("옷장"))
			System.out.println(d+"을 선택한 당신은 배우자를 선택할때 그 사람이 가진 것을 가장 중요시합니다");
			else if(d.equals("침대"))
			System.out.println(d+"을 선택한 당신은 배우자를 선택할때 그 사람 자체를 가장 중요시합니다");
			else
			System.out.println("잘못적었습니다");
			System.out.println("");
			
			System.out.println("5. 창문을 열었더니 창문 밖에 수영장이 보인다.거기에 애인 혹은 배우자가 수영을 하고있다.그때 당신의 행동은?");
			System.out.print("1)소리친다 2)쳐다본다 3)같이 수영한다==>" );
			int e = sc.nextInt();
			if (b==1)
			System.out.println("1번을 선택한 당신은 배우자의 외도에도 관계개선을 하려는 사람이다");
			else if (b==2)
			System.out.println("2번을 선택한 당신은 배우자가 외도를 하면 그대로 관계를 끝내는 사람이다");
			else if (b==3)
			System.out.println("3번을 선택한 당신은 배우자가 외도를 하면 같이 외도를 하는 사람이다");
			else
			System.out.print("번호를 다시 선택하세요==> ");
			System.out.println("");

			System.out.println("6. 마지막 방문을 열어보니 깜깜한 방이지만 어디선가 커피향이 난다. 그때 당신의 행동은?");
			System.out.print("1)들어가지 않는다 2)양초를 켠다 2)들어간다==>" );
			int f = sc.nextInt();
			if (b==1)
			System.out.println("1번을 선택한 당신은 죽음을 순순히 받아들이려 하지않는 사람이다");
			else if (b==2)
			System.out.println("2번을 선택한 당신은 죽음을 순순히 받아들이려 하지않는 사람이다");
			else if (b==3)
			System.out.println("3번을 선택한 당신은 죽음을 순순히 받아들이는 사람이다");
			else
			System.out.print("번호를 다시 선택하세요==> ");
			System.out.println("");


	
		





	}
}
