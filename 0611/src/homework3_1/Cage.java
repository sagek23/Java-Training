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
		// 타입이 맞지않아 형변환.
		
		cage.setAnimal(new Lion());		
		Tiger tiger = (Tiger)cage.getAnimal();
		// 형제끼리는 형변환 할 수 없어요!
		// is a 관계(상속관계,부모자식)에 있을때 형변환 할 수 있어요.
		
		//4,5 못함.
		System.out.println("ok");
	
	}

}
