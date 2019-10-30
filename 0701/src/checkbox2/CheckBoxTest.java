package checkbox2;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxTest extends JFrame{

	String []str = {"수박","사과","포도","복숭아","배"};
	JCheckBox cb[];
	JTextField result;
	
	public CheckBoxTest()
	{
		cb = new JCheckBox[str.length];
		setLayout(new FlowLayout());
		
		for(int i=0;i<cb.length;i++) 
		{
			cb[i] = new JCheckBox(str[i]);
			add(cb[i]);
		}
		JTextField result = new JTextField(30);
		add(result);
		
		for(int i=0; i<cb.length;i++)
		{
			cb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub	
					String r ="";
					for (JCheckBox c: cb)
					{
						if(c.isSelected()==true)
						{
							r= r+c.getText()+",";
						}
						else if(c.isSelected()==false)
						{
							result.setText("");
						}
					}
					if(r.equals(""))
					{
						result.setText("아무것도 선택하지 않음");
					}
					else
					{
						r = r.substring(0, r.length()-1);
						result.setText(r+"을/를 선택했어요");
					}
					
				}
			});
			
		}
		
			
			//result = r+"을/를 선택";			
		
		
		setVisible(true);
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxTest();
	}

}
