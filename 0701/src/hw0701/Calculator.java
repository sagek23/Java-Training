package hw0701;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Calculator extends JFrame implements ActionListener {
	int op1;
	int op2;
	String op;
	JButton btn[];
	JTextArea taResult;
	String calc [] = {"1","2","3","+","4","5","6","-","7","8","9","*","0","C","=","/"};
	
	public Calculator() {
		
		btn = new JButton[calc.length];
		taResult = new JTextArea(5,25);
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(taResult);
		
		JPanel jp = new JPanel();
		JPanel jp_result = new JPanel();
		
		jp_result.setLayout(new FlowLayout());
		jp.setLayout(new GridLayout(4, 4, 5, 5));
		
		jp_result.add(taResult);
		
		for(int i=0;i<calc.length;i++)
		{
			btn[i] = new JButton(calc[i]);
			jp.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		add(jp_result, BorderLayout.NORTH);
		add(jp, BorderLayout.CENTER);
		
	
		
		setVisible(true);
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String b = e.getActionCommand();
		String r = "";
		try {
			if(b.equals("+")||b.equals("-")||b.equals("*")||b.equals("/"))
			{
				op1 = Integer.parseInt(taResult.getText());
				op = b;
				taResult.setText(r);
				
			}
			else if(b.equals("="))
			{
				op2 = Integer.parseInt(taResult.getText());
				
				int g  =0;
				if(op.equals("+"))
				{	g = op1+op2;
				
				}
				else if(op.equals("-"))
				{	g = op1-op2;
				}
				else if(op.equals("*"))
				{	g = op1*op2;
				}
				else if(op.equals("/"))
				{	g = op1/op2;
				}
				
				taResult.setText(g+"");	
			}
		
			else if(b.equals("C"))
			{
				op1=0;
				op2=0;
				op="";
				taResult.setText(r);
			}
			else
			{
				taResult.setText(taResult.getText()+b);
			}
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}
		
	
	}

}
