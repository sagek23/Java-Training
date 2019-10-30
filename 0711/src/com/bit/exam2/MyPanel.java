package com.bit.exam2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MyPanel extends JPanel implements KeyListener {
//	Enemy enemy;
	ArrayList<Enemy> enemies;
	SpaceShip spaceship;
	Missile missile;
	Score score;

	public MyPanel() {
		// TODO Auto-generated constructor stub
		
		enemies = new ArrayList<Enemy>();
		for(int i=0;i<3;i++)
		{
			enemies.add(new Enemy("enemy.png"));
		}
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		score =new Score();
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
					for(Enemy enemy:enemies)
					{
						enemy.update();
						if(enemy.isHit(missile))
						{
							score.sco +=10;
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
					}
					
					
					missile.update();
					spaceship.update();
					
				
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
		for(Enemy enemy:enemies)
		{
			enemy.draw(g);
		}
		
		missile.draw(g);
		spaceship.draw(g);
		score.draw(g);
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
