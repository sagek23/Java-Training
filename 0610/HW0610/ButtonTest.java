/*
����1. "����������"��� ��ư�� �����ϴ� â�� �����.
����2. ��ư�� ������ "�ȳ��ϼ���"��� ���.
����3. â�� ����� ���ؼ��� JFrame�� ��ӹ޴´�.
����4. ��ư�� ������ �� �̺�Ʈ ó���� ���ؼ���
java.awt.evetnt.ActionLister �������̽��� �̿�.
����5. �츮�� �������� Ŭ������ JFrame�̸鼭 
ActionListner�̾�� �Ѵ�.
����6. ��ư�� �̺�Ʈ�� ����ϱ� ���ؼ���  
addActionListner(this)�޼ҵ带 �̿�.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyAction implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
			if (btn.getText().equals("����������"))
				btn.setText("�ȳ��ϼ���");
			else
				btn.setText("����������");
		}

}

class ButtonFrame extends JFrame
{
	public ButtonFrame()
	{
		this.setTitle("��ư");
		this.setSize(100,100);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		JButton btn1 = new JButton("����������");

		btn1.addActionListener(new MyAction());
		this.add(btn1);
		
	}
}
class  ButtonTest
{
	public static void main(String[] args) 
	{
		ButtonFrame b = new ButtonFrame();
		
	}
}