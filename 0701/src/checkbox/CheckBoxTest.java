package checkbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxTest extends JFrame {
	
	JCheckBox cb1;
	JCheckBox cb2;
	JTextField result;
	public CheckBoxTest()
	{
		setLayout(new FlowLayout());
		cb1 = new JCheckBox("사과");
		cb2 = new JCheckBox("포도");
		result = new JTextField(25);
		
		add(cb1);
		add(cb2);
		add(result);
		
		
		cb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String r = cb1.getText();
				result.setText(r+"를 선택하였습니다");
				boolean a = cb1.isSelected();
			}
		});
		cb2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String r = cb2.getText();
				result.setText(r+"를 선택하였습니다");
				boolean a = cb2.isSelected();
				System.out.println(a);
			}
		});
		
		setTitle("과일선택");
		setSize(400, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxTest();
	}

}
