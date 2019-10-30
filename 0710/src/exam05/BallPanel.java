package com.bit.exam05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

// BallPanel을 맴버로 가지는 Frame을 생성하고 
// 결과를 확인해 봅니다.
public class BallPanel extends JPanel implements Runnable {

	int x;
	int y;
	int xStep;
	int yStep;
	
	public BallPanel()
	{
		xStep = 10;
		yStep = -10;
		x = 10;
		y = 300-80;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.red);
		//g.drawOval(10, 200, 30, 30);
		g.fillOval(x, y, 30, 30);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			if( y < 10 )
			{
				yStep = yStep * -1;
			}
			
			if( y > (300-80))
			{
				yStep = yStep * -1;
			}
			
			
			
			
			if(x >= (400-50))
			{
				xStep = xStep*-1;
			}
			
			if(x < 10)
			{
				xStep = xStep*-1;
			}
			
			
			x = x + xStep;
			y = y + yStep;
			repaint();
		}
	}

}







