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
			System.out.println("���� ����");
			System.out.println("Ŭ���̾�Ʈ�� ���� ���");
			while(true)
			{
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ�� �����");
				// accpet�޼ҵ�� ��û�� Ŭ���̾�Ʈ�� ����� ���� ������ Socket�� ��ȯ
				OutputStream os  = socket.getOutputStream();
				Thread.sleep(1000);
				
				String msg = "hi";
				byte [] data = msg.getBytes();
				os.write(data);
				socket.close();
				System.out.println("Ŭ���̾�Ʈ�� ��������");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}