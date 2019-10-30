package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer {
	ServerSocket server;//클
	int port = 9003;
	public static ArrayList<TCPServerThread> list; 
	public TCPServer() {
		try {
			server = new ServerSocket(port);
			list = new ArrayList<TCPServerThread>();
			while(true)
			{
				Socket socket =  server.accept(); //클라이언트의 접속요청 수락
				//클라이언트와 통신을 위한 소켓
				TCPServerThread tst = new TCPServerThread(socket);
				list.add(tst);
				tst.start();
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
