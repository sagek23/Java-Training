package com.bit.exam2;

import java.awt.event.KeyEvent;
import java.lang.invoke.SwitchPoint;

public class SpaceShip extends GraphicObject {
	public SpaceShip(String name)
	{
		super(name); //graphicObject의 생성자. 
		x = 150;
		y = 400;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		//super.keyPressed(event);
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:x= x-15;break;
		case KeyEvent.VK_RIGHT:x= x+15;break;
		case KeyEvent.VK_UP:y= y-15;break;
		case KeyEvent.VK_DOWN:y= y+15;break;
		}
	}
	
	
}
