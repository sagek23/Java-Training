package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class TCPServerThread extends Thread {
	Socket socket;
	InputStream is;
	OutputStream os;
		
	public void broadCast(byte []data) //byte������ �����͸� ����
	{

			for(TCPServerThread tt: TCPServer.list)
			{ //list�� ����ִ� ip�� ���
				tt.send(data);
			}
	}
	public void send(byte []data) //byte������ �����͸� ����
	{
		try {
			os.write(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public TCPServerThread(Socket socket) { //������� �����ϱ����� Thread
		this.socket = socket;				//�����ÿ� socket�� �޴´�.
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	}

	@Override
	public void run() {//��� ��ȭ�� �ְ����
		try {

			byte []data = new byte [100]; //Ŭ���̾�Ʈ�� �ִ� �����͸� �ְ� �ޱ����� ����Ʈ
			while(true) //��ȭ�� ����ϱ� ���� while, while�� �������� ������ ��ȭ�� �ѹ����� ����
			{
				is.read(data);
				//os.write(data); //�о���� ���� �ٽ� ������(ȭ�鿡 ����) ȥ�� �޾Ƹ�
				broadCast(data);//list�� �ִ� socket�� ������ ip�� ����
				String str = new String(data); //byte�� ���� data�� ���ڿ��� ĳ����
				if(str.trim().equals("q!")) //str�� ���� q!�̸� ��ȭ����
					break;
				Arrays.fill(data, (byte)0); //data�� 0���� ����
			}
			is.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
