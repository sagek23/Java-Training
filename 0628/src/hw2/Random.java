package hw2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Random extends JFrame {
	JLabel lb1;
	
	JTextField tfInput;
	JTextField tfHint;
	JButton btn1;
	JButton btn2;
	
	public Random()
	{
		lb1 = new JLabel("���ڸ� �����Ͻÿ�");
		tfInput = new JTextField(10);
		tfHint = new JTextField(15);
		btn1 = new JButton("�ٽ� �ѹ�");
		btn2 = new JButton("����");
		
		JPanel jp_input = new JPanel();
		JPanel jp = new JPanel();
		JPanel jp_btn = new JPanel();
		
		setLayout(new BorderLayout());
		jp_input.add(lb1);
		jp_input.add(tfInput);
		jp_input.setLayout(new FlowLayout());
		
		
		jp.setLayout(new FlowLayout());
		jp.add(tfHint);
		
		
		jp_btn.add(btn1);
		jp_btn.add(btn2);
		jp_btn.setLayout(new FlowLayout());
		
		add(jp_input, BorderLayout.NORTH);
		add(jp, BorderLayout.CENTER);
		add(jp_btn, BorderLayout.SOUTH);
		
		setTitle("���ڰ���");
		setVisible(true);
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//randomAnswer();
		
		int answer = (int)(Math.random()*100)+1;
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn1)
				{
					
					int guess = Integer.parseInt(tfInput.getText());
					if (answer==guess)
					{	tfHint.setText("�����Դϴ�");
						tfHint.setBackground(Color.white);
					}
					else if(answer>guess)
					{
						tfHint.setText("�Է��� ������ Ů�ϴ�");
						tfHint.setBackground(Color.red);
					}
					else if(answer<guess)
					{
						tfHint.setText("�Է��� ������ �۽��ϴ�");
						tfHint.setBackground(Color.blue);
					}
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn2)
				{
					tfInput.setText("");
					tfHint.setText("");
					System.exit(0);
					
				}
			}
		});
	}
/*
	private void randomAnswer() {
		// TODO Auto-generated method stub
		
		try {
			int answer = (int)(Math.random()*100)+1;
			
			int guess = Integer.parseInt(tfInput.getText());
			
			if (answer==guess)
				tfHint.setText("�����Դϴ�");
			else if(answer>guess)
			{
				tfHint.setText("�Է��� ������ Ů�ϴ�");
				tfHint.setBackground(Color.red);
			}
			else if(answer<guess)
			{
				tfHint.setText("�Է��� ������ �۽��ϴ�");
				tfHint.setBackground(Color.red);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	*/
}
