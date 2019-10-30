package com.bit.exam1;

import java.util.Random;

public class Enemy extends GraphicObject {
	int dx;

	public Enemy(String name)
	{
		super(name);
		
		Random r = new Random();
		x = r.nextInt(500);
		y = r.nextInt(300);
		dx= r.nextInt()%10;
		if(dx<=0)
			dx= dx-5;
		else
			dx=dx*5;
		
	}
	public boolean isHit(Missile missile)
	{
		boolean hit = false;
		if(missile.x >= x&&missile.x<=(x+25)&&
		  missile.y>=y&&missile.y<=(y+25))
		{
			hit = true;
		}
		return hit;
	}
	@Override
	public void update() {
		//super.update();
	
		x=x+dx;
	
		if(x<0)
		{
			dx = 5;
		
		}
		if(x>500)
		{
			dx = -5;
			
		}
		/*
		if(x<0||x>500)
		{
			dx = dx*-1;
		}
		 로 하나의 if문으로도 가능
		 */
	}
	
	
}
