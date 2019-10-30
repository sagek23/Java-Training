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
	Socket socket; //����� ��û
	OutputStream os; //�����͸� �ִ� �뵵
	InputStream is; //�����͸� �޴� �뵵
	//String ip = "203.236.209.97";
	String ip = "";
	String name = "";
	int port = 9003;
	String myMsg=""; //���� �޼����� ���Ḧ ���� �޼������� �Ǻ�
	ImageIcon icon;
	public void connect()
	{
		
		try {
			socket = new Socket(ip, port);//socket�� �����Ͽ� �������� ����� ��û
			os = socket.getOutputStream(); //������ ���� ���濡�� �����͸� �۽��ϴ� ��Ʈ�� ����
			is = socket.getInputStream();//������ ���� ���濡�� �����͸� �����ϴ� ��Ʈ�� ����
			jta.append("������ ���� ����"+"\n");
			ClientThread ct = new ClientThread();//ClientThread ����
			ct.start();
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}
	}
	class ClientThread extends Thread{
	//������ �۽��ϴ� �����͸� ����Ͽ� �����ϴ� ������
		@Override
		public void run() {
			try {
			byte []data = new byte [100];
			while(true)//��������ʴ� �� ��� �����͸� �޴´�. 
			{
					is.read(data); //������ ����
					String msg = new String(data); //�����͸� ���ڿ��� ��ȯ
					jta.append(msg+"\n");
					jta.setCaretPosition(jta.getDocument().getLength());//�ڵ���ũ��
					if(myMsg.equals("q!")) //myMsg�� q!�̸� ä�� ����
					{	
						break;
					}
					Arrays.fill(data, (byte)0);//���� �޼����� �ޱ����� �迭�� ����.
			}		
				
			is.close();
			os.close();
			socket.close();
			//��ȭ�� ����Ǹ� ����� �ڿ��� ��� ����.
			jta.append("��������");
			}catch (Exception e) {
			// TODO: handle exception
			}
		}	
	}
	public TCPClientGUI(String ip, String name) {//connectFrameŬ�����κ��� ip�� name�� ����
		this.ip = ip; //�Ű������� ip�ּҿ� name�� ���´�.
		//�Ű������� ���޹��� ip,name�� ��������� ��´�.
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
		btn = new JButton("����");
	//	conn = new JButton("����");
		
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
		*/
		
		jtf.addActionListener(new ActionListener() {
			//���Ͱ� ������ sendMsgȣ���Ͽ� �۵�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendMsg();
			}

			private void sendMsg() {
				// TODO Auto-generated method stub
				String msg = name+"#"+jtf.getText();
				byte []data = msg.getBytes();//�����̱� ������ textField�� ���� ������
				//byte���� �迭�� �����´�.
				try {
					os.write(data);//�����Ϳ� �ִ� ������ �������� ���� ��
					myMsg = jtf.getText().trim(); //�Է¹��� ���� ������ ����
					jtf.setText(""); //�޼��� ���� �� �Է�â ����
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
				String msg = name+"#"+jtf.getText();//Ŭ���̾�Ʈ ������ ���� name�Է�,
				//name�� ��ȭ�� �����ϱ����� #�Է�
				byte []data = msg.getBytes();//�����̱� ������ textField�� ���� ������
				//byte���� �迭�� �����´�.
				try {
					os.write(data);//�����Ϳ� �ִ� ������ �������� ���� ��
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
