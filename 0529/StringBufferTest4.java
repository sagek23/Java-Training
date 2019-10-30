class StringBufferTest4
{
	public static void send(String msg)  //send는 String에서만 가능
	{
		System.out.println("전송한 메세지는 "+msg);
	}

	public static void main(String[] args) 
	{
		send("만두야 안녕");
		StringBuffer sb = new StringBuffer("Hello");
		send(sb.toString()); //StringBuffer는 send를 사용할 수 없으므로 String으로 변환
	}
}
