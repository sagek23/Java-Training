package Layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//Frame�� ���̾ƿ��� FlowLayout���� �����ϰ� ��ư 15���� ��ƺ���.
public class Flow extends JFrame {

	public Flow() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		for(int i=1; i<=15;i++)
		{
			add(new JButton("��ư"+i));
		}
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Flow();
	}

}
