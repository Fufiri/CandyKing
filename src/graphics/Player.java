package graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import logic.Game;

public class Player extends Figure implements KeyListener {
	
	/**
	 * Paints itself
	 * Handles what happens when player moves
	 * Listens for keys.
	 * Handles the checks for collision with other objects
	 * Keeps track of life and if the player has collected enough candies to level up
	 * 
	 */

	//private final BufferedImage image = null;
	private int collectedCandies = 0;
	private int life = 3;
	static int speed = 3;
	private final static int BASESPEED = 3;
    private int x, y;
    private final Game game;
    private boolean up,
                    down,
                    left,
                    right;
 

	
	public Player(Game game) {
		speed = BASESPEED;
		this.game = game;
			
		super.setRect(new Rectangle(x, y, (this.getX() +30), (this.getY()+30)));
	}
	
	private static BufferedImage getImage() {
		try {
			return ImageIO.read(new File("sprites/player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void paintYourself(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.drawRect((int) super.getRect().getX(),(int) super.getRect().getY(),(int) super.getRect().getWidth(),(int) (super.getRect().getHeight()));
		g.drawImage(getImage(), x, y, null);
	}
	
	public void go() {
	    x += super.getvX();
	    y += super.getvY();
	    
	    if (x >= getRight()) {
	    	x = getRight();
	    	super.setvX(0); 
	    }
	    if (y > getDown()) {
	    	y = getDown();
	    	super.setvX(0); 
	    }
	    if (x <= getLeft()) {
	    	x = getLeft();
	    	super.setvX(0); 
	    }
	    if (y < getUp()) {
	    	y = getUp();
	    	super.setvX(0); 
	    }
		super.getRect().x = x;
		super.getRect().y = y;
		
	}
	
	private void update() {
	    super.setvX(0);
	    super.setvY(0);
	    if(down) super.setvY(speed);
	    if(up) super.setvY(-speed);
		if(left) super.setvX(-speed);
	    if(right) super.setvX(speed);
	}
	public void powerUpUpdate() {
		for (PowerUp pu : game.getLevel().getAllPowerups()){
			pu.update();
		}
	}

	private int getX() {
		return x;
	}


	private int getY() {
		return y;
	}


	@Override
	public void keyPressed(KeyEvent e) { 
		switch(e.getKeyCode()) {
	        case KeyEvent.VK_DOWN: down = true; break;
	        case KeyEvent.VK_UP: up = true; break;
	        case KeyEvent.VK_LEFT: left = true; break;
	        case KeyEvent.VK_RIGHT: right = true; break;
	    }
	    update();   
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
	    case KeyEvent.VK_DOWN: down = false; break;
	    case KeyEvent.VK_UP: up = false; break;
	    case KeyEvent.VK_LEFT: left = false; break;
	    case KeyEvent.VK_RIGHT: right = false; break;
	}
	update();
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void checkCollision() {

			for (Enemy enemy : game.getLevel().geteArray() ) {

				if (this.getRect().intersects(enemy.getRect())) {
					life--;
					for (int i = 0; i <= 15; i++) {
					enemy.go();
					}
					//System.out.println(enemy.getRect());
				}
			}

			ArrayList<RegCandy> eatenRegCandies = new ArrayList<>();
			for (RegCandy rCandy : game.getLevel().getcArray()) {
				if (this.getRect().intersects(rCandy.getRect())) {
					eatenRegCandies.add(rCandy);
					game.setScore(game.getScore()+rCandy.getPointValue());
					collectedCandies++;
				}
			}
			for (RegCandy eatenRCandy : eatenRegCandies) {
				game.getLevel().getcArray().remove(eatenRCandy);
			}

			ArrayList<SuperCandy> eatenSuperCandies = new ArrayList<>();
			for (SuperCandy sCandy : game.getLevel().getsArray()) {
				if (this.getRect().intersects(sCandy.getRect())) {
					eatenSuperCandies.add(sCandy);
					game.setScore(game.getScore()+sCandy.getPointValue());
					collectedCandies++;
				}

			}
			for (SuperCandy eatenCandy : eatenSuperCandies) {
				game.getLevel().getsArray().remove(eatenCandy);
			}

			ArrayList<PowerUp> eatenPowerUps = new ArrayList<>();
			for (PowerUp pu : game.getLevel().getPowerups()) {
				if (this.getRect().intersects(pu.getRect())) {
					pu.effect();
					eatenPowerUps.add(pu);
				}
			}
			for (PowerUp eatenPowerUp : eatenPowerUps ) {
				game.getLevel().getPowerups().remove(eatenPowerUp);
			}

	}

	public boolean hasEatenEnough() {
		return collectedCandies == 8;
	}
	
	public boolean isAlive() {
		return life > 0;
	}


	public void setCollectedCandies(int collectedCandies) {
		this.collectedCandies = collectedCandies;
	}

	public int getLife() {
		return life;
	}
	


}
