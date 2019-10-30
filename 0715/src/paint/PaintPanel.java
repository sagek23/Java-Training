package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel implements MouseListener{
	int sx;
	int sy;
	int ex;
	int ey;
	int drawType;
	Color color;
	ArrayList<PaintSelect> list;
	public PaintPanel()
	{
		list = new ArrayList<PaintSelect>();
		addMouseListener(this);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(arg0);
		for(PaintSelect ps:list)
		{
			int width = ps.ex-ps.sx;
			int height = ps.ey-ps.sy;
			int x = ps.sx;
			int y = ps.sy;
			if(sx>ex)
			{
				x = ps.ex;
				width = ps.sx-ps.ex;
			}
			if(sy>ey)
			{
				y = ps.ey;
				height = ps.sy-ps.ey;
			}
			g.setColor(ps.color);
			
			switch (ps.drawType) {
			case 0:
				g.drawOval(x, y, width, height);
				break;
			case 1:
				g.drawLine(ps.sx, ps.sy, ps.ex, ps.ey);
				break;
			case 2:
				g.drawRect(x, y, width, height);
				break;
			}
	
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		sx = e.getX();
		sy = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ex = e.getX();
		ey = e.getY();
		list.add(new PaintSelect(sx, sy, ex, ey, drawType, color));
		repaint();
	}
	
}
