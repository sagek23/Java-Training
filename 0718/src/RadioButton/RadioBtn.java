package RadioButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioBtn extends JFrame{
	JLabel jb;
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	ImageIcon icon4;
	ImageIcon icon5;
	ButtonGroup group;
	public RadioBtn() {
		JRadioButton animal [] = new JRadioButton[5];
		setLayout(new BorderLayout());
		icon1 = new ImageIcon("cat.png");
		icon2 = new ImageIcon("dog.png");
		icon3 = new ImageIcon("tiger.png");
		icon4 = new ImageIcon("wolf.png");
		icon5 = new ImageIcon("jaguar.png");
		
		group = new ButtonGroup();
		jb = new JLabel(icon1);
		setVisible(true);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			animal[0] = new JRadioButton("고양이");
			animal[1] = new JRadioButton("강아지");
			animal[2] = new JRadioButton("호랑이");
			animal[3] = new JRadioButton("늑대");
			animal[4] = new JRadioButton("재규어");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	

		animal[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			jb.setIcon(icon1);
				
			}
		});
		
		animal[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jb.setIcon(icon2);
			}
		});
		
		animal[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jb.setIcon(icon3);
			}
		});
		
		animal[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jb.setIcon(icon4);
			}
		});
		
		animal[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jb.setIcon(icon5);
			}
		});
		

	for(JRadioButton rb : animal)
	{
		try {
			group.add(rb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	JPanel jp = new JPanel();
	jp.add(animal[0]);
	jp.add(animal[1]);
	jp.add(animal[2]);
	jp.add(animal[3]);
	jp.add(animal[4]);
	
	jp.setLayout(new FlowLayout());
	
	add(jp, BorderLayout.NORTH);
	add(jb, BorderLayout.CENTER);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RadioBtn();
	}
}
