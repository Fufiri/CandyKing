package graphics;

import java.awt.Rectangle;

class Candy {
	
	/**
	 * 
	 * Superclass for all candies
	 * Gets coordinates on candy, rectangle around
	 * handles scorevalue for candy
	 */
	

	private final int x = (int) (780 * Math.random());
	private final int y = (int) (520 * Math.random());
	private Rectangle rect;
	private final int pointValue;
	
	Candy(int pointValue) {
		this.pointValue = pointValue;

	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	public int getPointValue() {
		return pointValue;
	}

	public Rectangle getRect() {
		return rect;
	}

	void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
}
