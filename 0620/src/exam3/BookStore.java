package exam3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BookStore extends JFrame {
	
	BookPanel b;
	CustomerPanel c;
	OrderPanel o;
	
	public BookStore() 
	{
		
		o = new OrderPanel();
		b = new BookPanel(o);
		c = new CustomerPanel(o);
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("도서", b);
		tab.addTab("고객", c);
		tab.addTab("주문", o);
		
		setLayout(new BorderLayout());
		add(tab);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
