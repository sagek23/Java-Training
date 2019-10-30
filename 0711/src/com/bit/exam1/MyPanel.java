package com.bit.exam1;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	Enemy enemy;
	Enemy enemy2;
	Enemy enemy3;
	SpaceShip spaceship;
	Missile missile;
	
	public MyPanel() {
		// TODO Auto-generated constructor stub
		enemy = new Enemy("enemy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		requestFocus();
		setFocusable(true);
		addKeyListener(this);
		
		class MyThread extends Thread
		{

			@Override
			public void run() {
				//super.run();
				while(true)
				{
					enemy.update();
					missile.update();
					spaceship.update();
					
					if(enemy.isHit(missile))
					{
						enemy.x = 500;
						enemy.y = 500;
				
						System.out.println("dead");
					}
					
					repaint();
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}//end while
			}//end run
		}//end MyThread
		
		Thread t = new MyThread();
		t.start();
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		enemy.draw(g);
		missile.draw(g);
		spaceship.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		spaceship.keyPressed(e);
		missile.keyPressed(e, spaceship.x, spaceship.y);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
