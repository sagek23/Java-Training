interface Edible
{
	boolean amount=false;
	final int TYPE=10;
	public abstract void eat();
}
class Sandwitch implements Edible
{
	public void eat()
	{
		System.out.println("샌드위치를 먹어요");
		System.out.println("amount: "+amount);
		System.out.println("TYPE: "+TYPE);
		//TYPE = 20; 상수이기때문에 변경불가
	}
}

class InterfaceTest1 
{
	public static void main(String[] args) 
	{
		System.out.println("OK");
		Edible w = new Sandwitch();
		w.eat();
	}
}
