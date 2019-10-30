package homework3_2;

import java.util.ArrayList;

class Animal{}
class Lion extends Animal{}
class Tiger extends Animal{}

class Cage {
	
	ArrayList<Animal> list = new ArrayList<Animal>();

	public ArrayList<Animal> getList() {
		return list;
	}

	public void setList(ArrayList<Animal> list) {
		this.list = list;
	}
	
	
}

public class CageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cage cage = new Cage();
		cage.list.add(new Lion());
		cage.list.add(new Lion());
		cage.list.add(new Tiger());
				
		System.out.println("우리안의 동물은 모두 "+ cage.list.size() + "마리 입니다.");
		
		//우리안의 Lion의 수를 파악하여 출력해 봅니다.
		int count = 0;
		for(Animal obj :cage.list)
		{
			if(obj instanceof Lion)
				count++;
		}
		
		System.out.println("cage안에 lion의 수는 "+ 
		count + "마리입니다.");
		
	}
}





