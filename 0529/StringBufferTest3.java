class StringBufferTest3
{
	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer("Hello");
		char []arr = {'k','o','r','e','a'};
		sb.append(arr);
		System.out.println(sb);

		/*StringBuffer에서는 작동하지않는 String에서만 가능한 기능이 많다.
		그럴경우 StringBuffer를 String으로 만든 후 그 기능을 사용한다.
		*/
		String r = sb.toString(); //StringBuffer를 String으로 변환
		System.out.println(r.toUpperCase());// toUpperCase는 String에서만 가능.
	}
}
