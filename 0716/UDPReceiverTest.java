import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 9001;
		try {
			DatagramSocket ds = new DatagramSocket(port);
			byte [] data = new byte[100];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			while(true)
			{
				ds.receive(dp);
				ds.send(dp);
				String msg = new String(data, "utf-8");

				System.out.println("수신된 메세지: "+msg);
				Arrays.fill(data, (byte)0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}
