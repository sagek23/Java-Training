import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame implements ActionListener
{
	JButton btn;
	public MyFrame()
	{
		btn = new JButton("����������");
		add(btn);
		this.setSize(200,200);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		btn.addActionListener(this); //�������̽��� ������ ��ü. �̺�Ʈ ó�� �����
	}
	public void actionPerformed(ActionEvent e) //������ �Ҷ��� public���� ����
	{
		JButton btn1 = (JButton)e.getSource();
		if (btn.getText().equals("����������"))
			btn.setText("�ȳ��ϼ���");
		else
			btn.setText("����������");

		//System.out.println("�ȳ��ϼ���");
	}
}
class MyFrameTest 
{
	public static void main(String[] args) 
	{
		MyFrame mf = new MyFrame();
	}
}
