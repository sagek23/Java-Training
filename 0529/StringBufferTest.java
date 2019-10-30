class StringBufferTest 
{
	public static void main(String[] args) 
	{
		String str = new String("Hello");
		System.out.println(str.concat("Java"));  //str에 Java가 추가되는 것이 아니라 변화된 새로운 객체가 만들어 지는 것/
		StringBuffer sb = new StringBuffer("Hello");
		System.out.println(str); //다시 str을 프린트했을 때 변화가 없다.
		sb.append("World"); //sb에 변동이 생긴다. sb의 내용에 World가 추가 됨.
		System.out.println(sb);
	}
}
