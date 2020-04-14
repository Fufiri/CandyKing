package graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SuperCandy extends Candy {
	
	
	/**
	 * Paints out the image for Super candies
	 * @param pointValue 
	 * how much points one super candy gives
	 */
	//private final BufferedImage image = null;
	
	public SuperCandy(int pointValue)  {
		super(pointValue);
		super.setRect(new Rectangle(getX(), getY(), 20, 20));
	}
	
	private static BufferedImage getImage() {
		try {
			return ImageIO.read(new File("sprites/candy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void paintYourself(Graphics g) {
		//g.drawRect(getX(),getY(),20, 20);
		g.drawImage(getImage(), super.getX(), super.getY(), null);
	}
}
