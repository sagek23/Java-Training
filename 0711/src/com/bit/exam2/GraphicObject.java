package com.bit.exam2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GraphicObject {
	BufferedImage img = null;
	
	int x = 0, y=0;
	public GraphicObject(String name)
	{
		try {
			img = ImageIO.read(new File(name));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void update() 
	{

	}
	public void draw(Graphics g) 
	{
		g.drawImage(img, x, y, null);
		
	}
	public void keyPressed(KeyEvent event) 
	{
		
	}
}
