package graphics;

import java.awt.Graphics;
import java.awt.Rectangle;

public class PowerUp {
	
	
	/**
	 * Superclass for powerups
	 * contains all variables that Icecream and pineapple have in common
	 */
	private final int x = (int) (780 * Math.random());
	private final int y = (int) (510 * Math.random());
	final int POWERUP_DURATION_FRAMES = 438;

	private Rectangle rect;

	PowerUp() {
		
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	public Rectangle getRect() {
		return rect;
	}

	void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public void paintYourself(Graphics g) {

	}
	
	public void effect() {
		
	}

	public void update() {

	}

	int getIv() {
		int iv = 0;
		return iv;
	}
}
