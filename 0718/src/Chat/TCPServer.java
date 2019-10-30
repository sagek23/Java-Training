package Chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/*
 서버를 위한 클래스. 서버는 ServerSocket을 생성하고
  클라이언트의 접속을 무한대기 상태로 기다리도록 한다.
  클라이언트가 접속을 요청하면 접속을 수락하고 그 클라이언트와
  통신을 하기위한 쓰레드를 생성하고 쓰레드에게 통신을 맡긴다. 
 */

public class TCPServer {
	ServerSocket server;
	int port = 9003;
	public static ArrayList<TCPServerThread> list; 
	public TCPServer() {
		try {
			server = new ServerSocket(port);//서버소켓 생성
			list = new ArrayList<TCPServerThread>();
			//요청한 클라이언트와 통신을 담당하는 스레드를 담기위한 list 생성
			while(true)//클라이언트의 접속을 무한대기상태로 기다림.
			{
				Socket socket =  server.accept(); //클라이언트의 접속요청 수락
				//클라이언트와 통신을 위한 소켓을 생성
				TCPServerThread tst = new TCPServerThread(socket);
				//클라이언트와 통신을 위한 스레드 생성
				list.add(tst); //스레드를 list에 담음.
				tst.start(); // 스레드 가동
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
