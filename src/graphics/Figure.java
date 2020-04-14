package graphics;

import java.awt.Rectangle;


class Figure {
	
	/**
	 * Handles bounds that enemy and player can't move outside off
	 * Superclass that contains variables that player and enemy have in common
	 * 
	 */
	
	private Rectangle rect;
	private static final int Right= 770;
    private static final int Left = 1;
    private static final int Up = 1;
    private static final int Down = 505;

    private int vX, vY;
    
	Figure() {
		
	}
	
	Rectangle getRect() {
		return rect;
	}

	void setRect(Rectangle rect) {
		this.rect = rect;
	}

	int getvX() {
		return vX;
	}

	void setvX(int vX) {
		this.vX = vX;
	}

	int getvY() {
		return vY;
	}

	void setvY(int vY) {
		this.vY = vY;
	}

	static int getRight() {
		return Right;
	}

	static int getLeft() {
		return Left;
	}

	static int getUp() {
		return Up;
	}

	static int getDown() {
		return Down;
	}
	
}
