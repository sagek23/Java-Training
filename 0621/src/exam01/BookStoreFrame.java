package exam01;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BookStoreFrame extends JFrame {
	
	BookPanel b;
	CustomerPanel c;
	OrdersPanelMap o;
	OrderSearch os;
	
	
	public BookStoreFrame() {
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("����", new BookPanel());
		tab.addTab("��", new CustomerPanel(o));
		tab.addTab("�ֹ�", new OrdersPanelMap());
		tab.addTab("�ֹ���ȸ", new OrderSearch());
				
		add(tab);
		setTitle("���������ý���");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
