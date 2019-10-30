package Layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//BorderLayout�� ȭ���� ��, �Ʒ�, ��, ��, ����� 5���� ��������
//�����ϴ� ����̴�. 

/*
 * ��,�Ʒ�,��,��� �����ϸ� center�� ������ ������ ����.
 * center�� �����ϸ� center�� �ڸ��� �����̵�.
 * center�� �ַ� �ϰ� �μ����� ������ ��,�Ʒ�,��,�쿡 ��ġ�Ѵ�. 
 */
public class Border extends JFrame {

	public Border() {
		// TODO Auto-generated constructor stub
		
		setLayout(new BorderLayout());
		
		add(new JButton("��"), BorderLayout.NORTH);
		add(new JButton("�Ʒ�"), BorderLayout.SOUTH);
		//add(new JButton("������"), BorderLayout.EAST);
		//add(new JButton("����"), BorderLayout.WEST);
		add(new JButton("���"), BorderLayout.CENTER);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Border();
	}

}
