import java.io.InputStream;
import java.net.Socket;

public class TCPClientTest2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("203.236.209.97", 9000);
			System.out.println("������ ����");
			InputStream is = socket.getInputStream();
	
			byte [] data =new byte[100];
			is.read(data);
			String msg = new String(data);
			System.out.println("�����κ��� ���ŵ� ������: "+msg);
			socket.close();
			System.out.println("������ ��������");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}