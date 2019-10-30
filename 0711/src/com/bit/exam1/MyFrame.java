package com.bit.exam1;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame()
	{
		setTitle("My Game");
		add(new MyPanel());
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
