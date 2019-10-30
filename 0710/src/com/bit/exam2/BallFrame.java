package com.bit.exam2;

import javax.swing.JFrame;

public class BallFrame extends JFrame {
	BallPanel bp;
	public BallFrame()
	{
		bp = new BallPanel();
		add(bp);
		setVisible(true);
		setSize(400, 350);
		
		Thread thr = new Thread(bp);
		thr.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BallFrame bf = new BallFrame();
	}

}
