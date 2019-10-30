package exam2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BookStore extends JFrame {
	public BookStore() 
	{
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("����", new BookPanel());
		tab.addTab("��", new CustomerPanel());
		tab.addTab("�ֹ�", new OrderPanel());
		
		setLayout(new BorderLayout());
		add(tab);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
