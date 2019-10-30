class StringBufferTest2
{
	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer("Hello");
		char []arr = {'k','o','r','e','a'};
		int year = 1991;
		boolean flag = true;
		sb.append(",");
		sb.append(arr);
		sb.append(",");
		sb.append(year);
		sb.append(",");
		sb.append(flag);
		
		System.out.println(sb);


	}
}
