import javax.swing.*;
import java.awt.Graphics;
class MyPanel extends JPanel
{
		public void paintComponent(Graphics g) //오버라이딩. 그래픽과 관련된건 Graphics가 가지고 있음.
	{
		System.out.println("동작해");
		//시작점: x=100,y=100  끝점(210,100) 선그리기
		g.drawLine(100,100,200,100);
	}
}
class BitFrame extends JFrame
{
	public BitFrame()
	{
		add(new MyPanel());
	}
}
class JFrameTest3 
{
	public static void main(String[] args) 
	{
		BitFrame f = new BitFrame();
		f.setSize(400,300);
		f.setVisible(true);
	}
}
