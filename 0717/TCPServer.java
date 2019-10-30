import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPServer extends JFrame {

	JTextArea jta;
	JTextField jtf;
	JButton btn;
	int port = 9002;
	ServerSocket ssocekt;
	OutputStream os;
	InputStream is;
	public TCPServer() {
	try {
		ssocekt = new ServerSocket(port);
		System.out.println("서버가동");
		while(true)
		{
			Socket socket = ssocekt.accept();
			//System.out.println("클라이언트가 접속");
			ServerThread st = new ServerThread(socket);
			st.start();
			
		
		}
	} catch (Exception ex) {
	// TODO: handle exception
	System.out.println(ex.getMessage());}
				
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPServer();
	}

}
