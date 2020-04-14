package graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Enemy extends Figure implements ActionListener{
	
	/**
	 * 
	 * Subclass of figure, represents an enemy
	 * handles coordinates, movement speed
	 * and random direction generation
	 * 
	 */

	// private final BufferedImage image = null;
	
         
    static double speed = 5.0;
    
	private int x = (int) (780 * Math.random());
	private int y = (int) (515 * Math.random());



	public Enemy() {
		super.setRect(new Rectangle(x, y, 30, 30));
		sAnim();
		setRandomSpeed();
	}
	

	private void sAnim() {
	
		Timer timer = new Timer(16, this);
		timer.start();
		
	}
		
	public void go() {	
	    x += super.getvX();
	    y += super.getvY();

	    if (x >= getRight()) {
	    	x = getRight();
	    	setRandomSpeed();
	    }
	    if (y > getDown()) {
	    	y = getDown();
	    	setRandomSpeed();
	    }
	    if (x <= getLeft()) {
	    	x = getLeft();
	    	setRandomSpeed();
	    }
	    if (y < getUp()) {
	    	y = getUp();
	    	setRandomSpeed();
	    }
		super.getRect().x = x;
		super.getRect().y = y;
	    
	}
	

	private void setRandomSpeed() {
		double direction = Math.random() * 2.0 * Math.PI;
		super.setvX((int)(speed*Math.cos(direction)));
		super.setvY((int)(speed*Math.sin(direction)));
	}
	
	private static BufferedImage getImage() {
		try {
			return ImageIO.read(new File("sprites/enemy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void paintYourself(Graphics g) {
		g.drawImage(getImage(), x, y, null);
//		g.setColor(Color.BLACK);
//		g.drawRect((int) super.getRect().getX(),(int) super.getRect().getY(),(int) super.getRect().getWidth(),(int) (super.getRect().getHeight()));
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		go();
		
	}


	public void setSpeed(double eSpeed) {
		speed = eSpeed;
		
	}




	

}
