package TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class TCPServerThread extends Thread {
	Socket socket;
	InputStream is;
	OutputStream os;
		
	public void broadCast(byte []data) //byte형으로 데이터를 받음
	{

			for(TCPServerThread tt: TCPServer.list)
			{ //list에 들어있는 ip에 방송
				tt.send(data);
			}
	}
	public void send(byte []data) //byte형으로 데이터를 받음
	{
		try {
			os.write(data);
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
				if(str.trim().equals("q!")) //str의 값이 q!이면 대화종료
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
