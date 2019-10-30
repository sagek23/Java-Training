package com.bit.exam2;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.xml.parsers.FactoryConfigurationError;

public class Missile extends GraphicObject {
	
	boolean launched = false;
	
	public Missile(String name)
	{
		super(name);//�θ�Ŭ������ name���� ���� �ִ� ��
		y = -200;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//super.update();
		if(launched) // = launched == true
		{
			y = y-30;
		}
		if(y<-100)
		{
			launched = false;
		}	
	}
	public void keyPressed(KeyEvent event, int x, int y)
	{
		if(event.getKeyCode()==KeyEvent.VK_SPACE)
		{
			File file = new File("ding.WAV");
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(file));
				clip.start();
			} catch (Exception e) {
				// TODO: handle exception
			}
			launched = true;
			this.x = x; //GraphicObject�κ��� �������� x,y
			this.y = y;
		}
	}
}
