package com.bit.draw1;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;



public class LinePanel extends JPanel implements MouseListener{

	int sx;//시작점
	int sy;
	int ex;//끝점
	int ey;
	
	ArrayList<GraphinInfo> list;
	
	public LinePanel() {
		list = new ArrayList<GraphinInfo>();
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g);
		//g.drawLine(sx,sy,ex,ey);
		for(GraphinInfo info :list)
		{
			g.drawLine(info.sx, info.sy, info.ex, info.ey);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		sx = e.getX();
		sy= e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ex = e.getX();
		ey= e.getY();
		list.add(new GraphinInfo(sx,sy,ex,ey));
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
