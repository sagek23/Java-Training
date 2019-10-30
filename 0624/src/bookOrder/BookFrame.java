package bookOrder;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookFrame extends JFrame {
	
	public BookFrame()
	{
		JPanel jp = new JPanel();
		jp.add(new OrderPanel());
		
		add(jp);
		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
