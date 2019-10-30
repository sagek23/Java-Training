package checkbox3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxList extends JFrame implements ActionListener{
	JTextField result;
	
	ArrayList<String> al;
	JCheckBox cb[];
	String [] str = {"수박","사과","포도","복숭아","배"};
	
	public CheckBoxList()
	{
		result = new JTextField(20);
		al = new ArrayList<String>();
		
		
		cb = new JCheckBox[str.length];
		setLayout(new FlowLayout());
		for(int i=0; i<cb.length;i++)
		{
			cb[i] = new JCheckBox(str[i]);
			add(cb[i]);
			cb[i].addActionListener(this);
		}
		add(result);
		
		setVisible(true);
		setSize(400,140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JCheckBox c= (JCheckBox)e.getSource();
		if(c.isSelected())
		{
			al.add(c.getText());
		}
		else
		{
			al.remove(c.getText());
		}
		if(al.size()==0)
		{
			result.setText("아무것도 선택하지 않았습니다");
		}
		else
		{
			result.setText(al.toString()+"을/를 선택하였습니다");
		}
	}

}
