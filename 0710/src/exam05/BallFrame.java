package com.bit.exam05;

import javax.swing.JFrame;

// ���� ������ ���� ������ �������� �̵��ϵ��� �մϴ�.
public class BallFrame extends JFrame {
	
	BallPanel bp;
	
	public BallFrame() 
	{
		bp= new BallPanel();
		add(bp);
		setSize(400, 300);
		setVisible(true);
		
		(new Thread(bp)).start();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BallFrame();
	}

}
