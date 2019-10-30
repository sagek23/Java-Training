package checkbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxTest2 extends JFrame implements ActionListener{
	
	JCheckBox cb1;
	JCheckBox cb2;
	JTextField result;
	public CheckBoxTest2()
	{
		setLayout(new FlowLayout());
		cb1 = new JCheckBox("���");
		cb2 = new JCheckBox("����");
		result = new JTextField(25);
		
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		
		add(cb1);
		add(cb2);
		add(result);
		
	
		
		setTitle("���ϼ���");
		setSize(400, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String r = "";
		if(cb1.isSelected()==false&&cb2.isSelected()==false)
		{
			r="�ƹ��͵� �������� �ʾҾ��";
		}
		else if(cb1.isSelected()==true&&cb2.isSelected()==false)
		{
			r= "����� �����߾��";
		}
		else if(cb1.isSelected()==false&&cb2.isSelected()==true)
		{
			r= "������ �����߾��";
		}
		else
		{
			r = "����� ���� ��� �����߾��";
		}
		result.setText(r);
	}

}
