package com.bit.exam2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.bit.exam1.Person2;

public class BallPanel extends JPanel implements Runnable {

	int x;
	int y;
	int xStep;
	public BallPanel() {
		xStep=10;
		x = 0;
		y=280;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.red);
	
		//g.drawOval(0, 280, 30, 30);
		g.fillOval(x, y, 30, 30);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
while(true)
{	
	while(x<=360)

		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			}	
			if(x>=360)
			{
				xStep= xStep*-1;
				
			}
			if(x<=0)
			{
				xStep= xStep+10;
			}
			
			x+=xStep;
			repaint();			
				
		}	
 	}
}
	public static void main(String[] args) {
		BallPanel bp = new BallPanel();
		
	}
}
