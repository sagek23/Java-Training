import javax.swing.*;
import java.awt.*;
//MyFrame is a JFrame 관계
class MyFrame extends JFrame
{	
	JButton btn;
	//MyFrame has a JButton 관계
	public	MyFrame(String title)
	{
		super(title);
		//setTitle("hello");
		btn = new JButton("오늘은 불수!");
		setLayout(new FlowLayout());
		add(btn);
	}
}

class  JFrameTest2
{
	public static void main(String[] args) 
	{
		MyFrame f1 = new MyFrame("hello");
		//400,300
		f1.setSize(400,300);
		f1.setVisible(true);
	}
}
