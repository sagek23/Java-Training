package TCP;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

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
	JButton conn;
	Socket socket; //����� ��û
	OutputStream os; //�����͸� �ִ� �뵵
	InputStream is; //�����͸� �޴� �뵵
	String ip = "203.236.209.97";
	int port = 9003;
	String myMsg="";
	class ClientThread extends Thread{

		@Override
		public void run() {
			try {
			byte []data = new byte [100];
			while(true)
			{
					is.read(data);
					String msg = new String(data);
					jta.append(socket.getInetAddress()+":  "+msg+"\n");
					if(myMsg.equals("q!"))
					{	
						break;
					}
					Arrays.fill(data, (byte)0);
			}		
				
			is.close();
			os.close();
			socket.close();
			jta.append("��������");
			}catch (Exception e) {
			// TODO: handle exception
			}
		}	
	}
	public TCPClientGUI() {
		jta = new JTextArea();
		jtf = new JTextField(20);
		btn = new JButton("����");
		conn = new JButton("����");
		setLayout(new BorderLayout());
		JScrollPane jsp  = new JScrollPane(jta);
		JPanel jp = new JPanel();
		
		jp.setLayout(new FlowLayout());
		jp.add(jtf);

		jp.add(btn);
		jp.add(conn);
		
		add(jsp, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		conn.addActionListener(new ActionListener() { //�����ư
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					socket = new Socket(ip, port);//socket�� �����Ͽ� ����� ��û
					os = socket.getOutputStream(); //���濡�� �����͸� �ִ� �뵵
					is = socket.getInputStream();//���濡�� �����͸� �޴¿뵵
					jta.append("������ ���� ����"+"\n");
					ClientThread ct = new ClientThread();
					ct.start();
					
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
				byte []data = jtf.getText().getBytes();//�����̱� ������ textField�� ���� ������
				//byte���� �迭�� �����´�.
				try {
					os.write(data);//�����Ϳ� �ִ� ������ �������� ���� ��
					jtf.setText("");
					myMsg = jtf.getText().trim();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
		
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPClientGUI();
	}

}
