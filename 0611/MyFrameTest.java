import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame implements ActionListener
{
	JButton btn;
	public MyFrame()
	{
		btn = new JButton("눌러보세요");
		add(btn);
		this.setSize(200,200);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		btn.addActionListener(this); //인터페이스를 구현한 객체. 이벤트 처리 담당자
	}
	public void actionPerformed(ActionEvent e) //재정의 할때는 public으로 변경
	{
		JButton btn1 = (JButton)e.getSource();
		if (btn.getText().equals("눌러보세요"))
			btn.setText("안녕하세요");
		else
			btn.setText("눌러보세요");

		//System.out.println("안녕하세요");
	}
}
class MyFrameTest 
{
	public static void main(String[] args) 
	{
		MyFrame mf = new MyFrame();
	}
}
