package graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RegCandy extends Candy {
	
	//private final BufferedImage image = null;
	/**
	 * Paints out the image for regular candies
	 * @param pointValue 
	 * how much points one candy gives
	 */
	
	public RegCandy(int pointValue)  {
		super(pointValue);
		super.setRect(new Rectangle(getX(), getY(), 20, 20));
	}
	
	private static BufferedImage getImage() {
		try {
			return ImageIO.read(new File("sprites/candy2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void paintYourself(Graphics g) {
		//g.drawRect((int) super.getRect().getX(),(int) super.getRect().getY(),(int) super.getRect().getWidth(),(int) (super.getRect().getHeight()));
		g.drawImage(getImage(), super.getX(), super.getY(), null);
	}
}

