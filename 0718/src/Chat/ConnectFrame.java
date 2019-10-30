package Chat;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ConnectFrame extends JFrame {

	JTextField jtf_ip;
	JTextField jtf_name;
	String name;
	String ip;
	ImageIcon icon;
	ImageIcon icon2;
	JButton btn;
	
	public ConnectFrame() {
		jtf_ip = new JTextField(20);
		jtf_name = new JTextField(20);
		icon = new ImageIcon("connection.png");
		icon2 = new ImageIcon("connected.png");
		btn = new JButton(icon);
		int width = icon.getIconHeight();
		int height = icon.getIconHeight();
		btn.setSize(width, height);
		btn.setBorderPainted(false);
		btn.setBorder(null);
		btn.setRolloverIcon(icon2);
		
		setLayout(new FlowLayout());
		add(new JLabel("ip주소: "));
		add(jtf_ip);
		add(new JLabel("대화명"));
		add(jtf_name);
		add(btn);
		setSize(300, 150);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ip = jtf_ip.getText(); //접속하려는 ip와 대화명 입력
				name = jtf_name.getText();
				new TCPClientGUI(ip, name); 
				//TCPClient에 ip와 name을 매개변수로 주어 TCPClient를 생성한다.
				setVisible(false); //TCPClient가 불려와지면 ip,name입력창이 사라짐
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConnectFrame();
	}

}
