package Chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/*
 ������ ���� Ŭ����. ������ ServerSocket�� �����ϰ�
  Ŭ���̾�Ʈ�� ������ ���Ѵ�� ���·� ��ٸ����� �Ѵ�.
  Ŭ���̾�Ʈ�� ������ ��û�ϸ� ������ �����ϰ� �� Ŭ���̾�Ʈ��
  ����� �ϱ����� �����带 �����ϰ� �����忡�� ����� �ñ��. 
 */

public class TCPServer {
	ServerSocket server;
	int port = 9003;
	public static ArrayList<TCPServerThread> list; 
	public TCPServer() {
		try {
			server = new ServerSocket(port);//�������� ����
			list = new ArrayList<TCPServerThread>();
			//��û�� Ŭ���̾�Ʈ�� ����� ����ϴ� �����带 ������� list ����
			while(true)//Ŭ���̾�Ʈ�� ������ ���Ѵ����·� ��ٸ�.
			{
				Socket socket =  server.accept(); //Ŭ���̾�Ʈ�� ���ӿ�û ����
				//Ŭ���̾�Ʈ�� ����� ���� ������ ����
				TCPServerThread tst = new TCPServerThread(socket);
				//Ŭ���̾�Ʈ�� ����� ���� ������ ����
				list.add(tst); //�����带 list�� ����.
				tst.start(); // ������ ����
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPServer();
	}

}
