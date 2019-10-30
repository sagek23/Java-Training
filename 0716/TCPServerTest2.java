import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		try {
			ServerSocket ss = new ServerSocket(9000);
			System.out.println("서버 가동");
			System.out.println("클라이언트의 접속 대기");
			while(true)
			{
				Socket socket = ss.accept();
				System.out.println("클라이언트와 연결됨");
				// accpet메소드는 요청한 클라이언트와 통신을 위한 데이터 Socket을 반환
				OutputStream os  = socket.getOutputStream();
				Thread.sleep(1000);
				
				String msg = "hi";
				byte [] data = msg.getBytes();
				os.write(data);
				socket.close();
				System.out.println("클라이언트와 연결해제");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}