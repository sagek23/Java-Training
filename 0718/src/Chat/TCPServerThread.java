package Chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
//������ ��û�� Ŭ���̾�Ʈ �Ѹ��� ����Ͽ� ����ϴ� ������ Ŭ����
//Ŭ���̾�Ʈ�κ��� ������ �޼����� ����� ��� Ŭ���̾�Ʈ�鿡�� ����Ѵ�.

public class TCPServerThread extends Thread {
	Socket socket;
	//������ ��û�� Ŭ���̾�Ʈ�� ���������� �̷������ ������ ������ ���� ����
	//TCPServer�� ������ �����ÿ� �Ű������� ����.
	InputStream is;//Ŭ���̾�Ʈ�κ��� �����͸� �����ϱ� ���� Stream
	OutputStream os;//Ŭ���̾�Ʈ���� �����͸� �۽��ϱ� ���� Stream
	
	
	public void broadCast(byte []data) //data������ Ŭ���̾�Ʈ�� ���� �޼����� ����
	{ //Ŭ���̾�Ʈ�� ���� �޼����� ����� ��� Ŭ���̾�Ʈ���� ����ϱ����� �޼ҵ�

			for(TCPServerThread tt: TCPServer.list)
			{
				//byte������ ���� �޼����� list�� ����ִ� ip(Ŭ���̾�Ʈ)�鿡�� �۽�
				tt.send(data);
			}
	}
	public void send(byte []data) //������ ���� �޼����� ���� ����ϰ� �ִ� �����忡�� ����
	{
		try {
			os.write(data);//����� ���� ��Ʈ���� ���� �����͸� ����
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
				String arr[] = str.split("#");
				if(arr[1].trim().equals("q!")) //str�� ���� q!�̸� ��ȭ����
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
