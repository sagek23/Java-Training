package hw1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TFrame extends JFrame {
	
	public TFrame ()
	{
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("상영관", new Theater());
		tab.addTab("고객", new Customer());
		tab.addTab("예약", new Booking());
		
		setLayout(new BorderLayout());
		add(tab);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
