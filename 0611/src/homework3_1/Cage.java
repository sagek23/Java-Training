package homework3_1;

class Animal{}
class Lion extends Animal{}
class Tiger extends Animal{}

public class Cage {
	private Object animal;
	public void setAnimal(Object x) {
		animal = x;
	}
	public Object getAnimal() {
		return animal;
	}
	
	public static void main(String[] args) {
		Cage cage = new Cage();
		cage.setAnimal(new Lion());
		Lion lion = (Lion)cage.getAnimal();  
		// Ÿ���� �����ʾ� ����ȯ.
		
		cage.setAnimal(new Lion());		
		Tiger tiger = (Tiger)cage.getAnimal();
		// ���������� ����ȯ �� �� �����!
		// is a ����(��Ӱ���,�θ��ڽ�)�� ������ ����ȯ �� �� �־��.
		
		//4,5 ����.
		System.out.println("ok");
	
	}

}
