import java.io.InputStream;
import java.net.Socket;

public class TCPClientTest2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("203.236.209.97", 9000);
			System.out.println("서버에 접속");
			InputStream is = socket.getInputStream();
	
			byte [] data =new byte[100];
			is.read(data);
			String msg = new String(data);
			System.out.println("서버로부터 수신된 데이터: "+msg);
			socket.close();
			System.out.println("서버와 연결해제");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
