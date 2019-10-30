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
		tab.addTab("도서", new BookPanel());
		tab.addTab("고객", new CustomerPanel(o));
		tab.addTab("주문", new OrdersPanelMap());
		tab.addTab("주문조회", new OrderSearch());
				
		add(tab);
		setTitle("도서관리시스템");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
