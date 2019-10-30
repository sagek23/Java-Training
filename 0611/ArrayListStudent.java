package exam1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Student 
{
	private String name;
	private String adrs;
	private String tel;
	public Student(String name, String adrs, String tel) {
		super();
		this.name = name;
		this.adrs = adrs;
		this.tel = tel;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", adrs=" + adrs + ", tel=" + tel + "]";
	}
	
}
public class ArrayListStudent{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet();
		ArrayList al = new ArrayList();
		Student s = new Student();
		Scanner sc = new Scanner(System.in);
		al.add(new Student("홍길동","마포구","010-2132-5344"));
		al.add(new Student("채성아","떡잎마을","010-5555-4444"));
		al.add(new Student("정우성","강남구","010-2465-5534"));
		
		
		for (Object obj : al)
		{
			System.out.println(obj);
		}
		
	}

}
