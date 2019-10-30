package exam2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BookStore extends JFrame {
	public BookStore() 
	{
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("도서", new BookPanel());
		tab.addTab("고객", new CustomerPanel());
		tab.addTab("주문", new OrderPanel());
		
		setLayout(new BorderLayout());
		add(tab);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
