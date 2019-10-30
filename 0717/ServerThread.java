import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class ServerThread extends Thread {
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public ServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
	@Override
	public void run() {
		byte [] data = new byte[100];
		while(true)
		{
			try {
				is.read(data);
				os.write(data);
				System.out.println("수신된 메세지: "+(new String(data)));
				Arrays.fill(data, (byte)0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	}

}
