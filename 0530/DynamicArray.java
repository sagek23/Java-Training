/*
�ڷῡ �߰�, ������ ����� ��쿡�� �迭�� ����ϱ� ����.
�׷��� ��� �ڹ��� �÷��� �����ӿ��� ���.
Set, List, Map
	Set�� �ߺ��� ������� �ʴ� ������ó���� ����
	List�� �ߺ��� ���
	Map�� key��value�� �ѽ����� �̷���� �ڷᱸ��
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
		ages.add(26); //������ �߰�
		System.out.println(ages);
		ages.remove(1);
		System.out.println(ages); //������ ����

		int sum = 0;
		for (int a:ages ) //(int i=0, i<ages.size();i++)
		{	
			sum+=a; //sum+=ages.get(); ArrayList�� .get�� Ư����ġ�� �ִ� ���� ������. 
		}
		System.out.println("���� ����: "+sum);
		System.out.println("���� ����: "+sum/ages.size()); //ArrayList�� ���̸� ǥ��

	}
}