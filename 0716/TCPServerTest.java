import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {

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
				for(int i=0; i<10;i++)
				{
					int n = r.nextInt(100);
					os.write(n);
					Thread.sleep(100);
				}
				socket.close();
				System.out.println("Ŭ���̾�Ʈ�� ��������");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}