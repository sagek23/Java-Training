package exam3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BookStore extends JFrame {
	
	BookPanel b;
	CustomerPanel c;
	OrderPanel o;
	OrderSearch os;
	
	public BookStore() 
	{
		os = new OrderSearch();
		o = new OrderPanel(os);
		b = new BookPanel(o);
		c = new CustomerPanel(o);
		
		
		JTabbedPane tap = new JTabbedPane();
		tap.addTab("도서", b);
		tap.addTab("고객", c);
		tap.addTab("주문", o);
		tap.addTab("주문조회", os);
		
		setLayout(new BorderLayout());
		add(tap);
		setSize(1000, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
