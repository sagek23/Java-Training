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
				
		System.out.println("�츮���� ������ ��� "+ cage.list.size() + "���� �Դϴ�.");
		
		//�츮���� Lion�� ���� �ľ��Ͽ� ����� ���ϴ�.
		int count = 0;
		for(Animal obj :cage.list)
		{
			if(obj instanceof Lion)
				count++;
		}
		
		System.out.println("cage�ȿ� lion�� ���� "+ 
		count + "�����Դϴ�.");
		
	}
}





