package Chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPClientGUI extends JFrame {
	JTextArea jta;
	JTextField jtf;
	JButton btn;
//	JButton conn;
	Socket socket; //통신을 요청
	OutputStream os; //데이터를 주는 용도
	InputStream is; //데이터를 받는 용도
	//String ip = "203.236.209.97";
	String ip = "";
	String name = "";
	int port = 9003;
	String myMsg=""; //나의 메세지가 종료를 위한 메세지인지 판별
	ImageIcon icon;
	public void connect()
	{
		
		try {
			socket = new Socket(ip, port);//socket을 생성하여 서버에게 통신을 요청
			os = socket.getOutputStream(); //소켓을 통해 상대방에게 데이터를 송신하는 스트림 생성
			is = socket.getInputStream();//소켓을 통해 상대방에게 데이터를 수신하는 스트림 생성
			jta.append("서버와 연결 성공"+"\n");
			ClientThread ct = new ClientThread();//ClientThread 생성
			ct.start();
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}
	}
	class ClientThread extends Thread{
	//서버가 송신하는 데이터를 계속하여 수신하는 스레드
		@Override
		public void run() {
			try {
			byte []data = new byte [100];
			while(true)//종료되지않는 한 계속 데이터를 받는다. 
			{
					is.read(data); //데이터 수신
					String msg = new String(data); //데이터를 문자열로 변환
					jta.append(msg+"\n");
					jta.setCaretPosition(jta.getDocument().getLength());//자동스크롤
					if(myMsg.equals("q!")) //myMsg가 q!이면 채팅 종료
					{	
						break;
					}
					Arrays.fill(data, (byte)0);//다음 메세지를 받기위해 배열을 비운다.
			}		
				
			is.close();
			os.close();
			socket.close();
			//대화가 종료되면 사용한 자원을 모두 닫음.
			jta.append("연결해제");
			}catch (Exception e) {
			// TODO: handle exception
			}
		}	
	}
	public TCPClientGUI(String ip, String name) {//connectFrame클래스로부터 ip와 name을 받음
		this.ip = ip; //매개변수로 ip주소와 name을 갖는다.
		//매개변수로 전달받은 ip,name을 멤버변수에 담는다.
		this.name = name;
		jta = new JTextArea() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				setOpaque(false);
				g.drawImage(icon.getImage(), 0, 0, null);	
			}
			
		};
		jtf = new JTextField(20);
		btn = new JButton("전송");
	//	conn = new JButton("연결");
		
		setLayout(new BorderLayout());
		JScrollPane jsp  = new JScrollPane(jta);
		JPanel jp = new JPanel();
		
		icon = new ImageIcon("cat.png");
	
		jp.setLayout(new FlowLayout());
		jp.add(jtf);

		jp.add(btn);
		//jp.add(conn);
		
		add(jsp, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connect();
		/*
		conn.addActionListener(new ActionListener() { //연결버튼
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					socket = new Socket(ip, port);//socket을 생성하여 통신을 요청
					os = socket.getOutputStream(); //상대방에게 데이터를 주는 용도
					is = socket.getInputStream();//상대방에게 데이터를 받는용도
					jta.append("서버와 연결 성공"+"\n");
					ClientThread ct = new ClientThread();
					ct.start();
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
				
			}
		});
		*/
		
		jtf.addActionListener(new ActionListener() {
			//엔터가 눌리면 sendMsg호출하여 작동
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendMsg();
			}

			private void sendMsg() {
				// TODO Auto-generated method stub
				String msg = name+"#"+jtf.getText();
				byte []data = msg.getBytes();//전송이기 때문에 textField에 써진 내용을
				//byte형의 배열로 가져온다.
				try {
					os.write(data);//데이터에 있는 내용을 내보내기 위한 것
					myMsg = jtf.getText().trim(); //입력받은 값에 공백을 삭제
					jtf.setText(""); //메세지 전송 후 입력창 비우기
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
			}
		});
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg = name+"#"+jtf.getText();//클라이언트 구분을 위해 name입력,
				//name과 대화를 구분하기위해 #입력
				byte []data = msg.getBytes();//전송이기 때문에 textField에 써진 내용을
				//byte형의 배열로 가져온다.
				try {
					os.write(data);//데이터에 있는 내용을 내보내기 위한 것
					myMsg = jtf.getText().trim();
					jtf.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
		
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
