/*

*/
class StringBufferTest5
{ 
	public static void main(String[] args)   
	{
		StringBuffer sb = new StringBuffer("친구를 사랑했네");  //append는 문자열 맨 뒤에 추가
		//sb의 맨 앞에 "친구의"를 추가
		System.out.println(sb.insert(0, "친구의 ")); //insert는 원하는 위치에 삽입  
	}
}
