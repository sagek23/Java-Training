package com.bit.exam2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score{

	int sco;
	public void draw(Graphics g)
	{
		g.drawString("score:"+sco, 350, 100);
		g.setColor(Color.red);
		g.setFont(new Font("µ¸¿ò",Font.BOLD,20));
	}

}
