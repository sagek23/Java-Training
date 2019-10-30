package Chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
//접속을 요청한 클라이언트 한명을 상대하여 통신하는 스레드 클래스
//클라이언트로부터 수신한 메세지를 연결된 모든 클라이언트들에게 방송한다.

public class TCPServerThread extends Thread {
	Socket socket;
	//접속을 요청한 클라이언트와 연결접점이 이루어지는 데이터 소켓을 위한 변수
	//TCPServer에 스레드 생성시에 매개변수로 전달.
	InputStream is;//클라이언트로부터 데이터를 수신하기 위한 Stream
	OutputStream os;//클라이언트에게 데이터를 송신하기 위한 Stream
	
	
	public void broadCast(byte []data) //data변수로 클라이언트가 보낸 메세지를 받음
	{ //클라이언트가 보낸 메세지를 연결된 모든 클라이언트에게 방송하기위한 메소드

			for(TCPServerThread tt: TCPServer.list)
			{
				//byte형으로 받은 메세지를 list에 들어있는 ip(클라이언트)들에게 송신
				tt.send(data);
			}
	}
	public void send(byte []data) //서버가 보낸 메세지를 내가 담당하고 있는 스레드에게 전송
	{
		try {
			os.write(data);//출력을 위한 스트림을 통해 데이터를 전송
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public TCPServerThread(Socket socket) { //여러명과 접속하기위해 Thread
		this.socket = socket;				//생성시에 socket을 받는다.
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	}

	@Override
	public void run() {//계속 대화를 주고받음
		try {

			byte []data = new byte [100]; //클라이언트가 주는 데이터를 주고 받기위한 바이트
			while(true) //대화를 계속하기 위한 while, while을 설정하지 않으면 대화가 한번으로 끝남
			{
				is.read(data);
				//os.write(data); //읽어들인 것을 다시 내보냄(화면에 송출) 혼자 메아리
				broadCast(data);//list에 있는 socket에 접속한 ip에 송출
				String str = new String(data); //byte형 변수 data를 문자열로 캐스팅
				String arr[] = str.split("#");
				if(arr[1].trim().equals("q!")) //str의 값이 q!이면 대화종료
					break;
				Arrays.fill(data, (byte)0); //data를 0으로 비우기
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
