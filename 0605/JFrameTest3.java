import javax.swing.*;
import java.awt.Graphics;
class MyPanel extends JPanel
{
		public void paintComponent(Graphics g) //�������̵�. �׷��Ȱ� ���õȰ� Graphics�� ������ ����.
	{
		System.out.println("������");
		//������: x=100,y=100  ����(210,100) ���׸���
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
