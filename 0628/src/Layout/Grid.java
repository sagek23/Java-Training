package Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//14�� ������ ��ĭ�� ��� 12�� 4�������� ���. ������ ������ ������ ��µ��� �ʴ´�.
/*
 * -���� ���� ����
 * -������ �࿭�� ������ ���۳�Ʈ�� ���� �࿭�� ���߾� �������� ���� ��
 *  ����� ���� �������� ��ĭ���� ǥ�õȴ�.
 * -������ �࿭�� ������ ������Ʈ�� ���� �۰� �� ������ �࿭�� ���� 
 *  ���߾� ���� ������ �࿭�� ���õȴ�.
 *  GridLayout(3,5) �� ����������, ������Ʈ�� ���� 12����� 3�� 5���� ���õǰ�
 *  3�� 4���� ���������.
 *  �� ū���� ������ �˾Ƽ� ���� ����� �÷��ش�. ���� �����ǰ� ���� ���� ����.  
 * */

public class Grid extends JFrame {

	public Grid() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(3,5));
		//for(int i=1; i<=15;i++)
		for(int i=1; i<=21;i++)
		//for(int i=1; i<=12;i++)
		{
			add(new JButton("��ư"+i));
		}
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Grid();
	}

}
