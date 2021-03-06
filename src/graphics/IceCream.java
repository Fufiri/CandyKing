package graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IceCream extends PowerUp  {
	
	/**
	 * Paints the icecream power up.
	 * Handles what happens on pick up for itself
	 */
	//private final BufferedImage image = null;
	private int iv;
	
	public IceCream()  {
		super.setRect(new Rectangle(getX(), getY(), 20, 20));
		iv = super.getIv();
	}
	
	private static BufferedImage getImage() {
		try {
			return ImageIO.read(new File("sprites/icecream.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void paintYourself(Graphics g) {
		g.drawImage(getImage(), super.getX(), super.getY(), null);
	}

	@Override
	public void effect() {
		iv=POWERUP_DURATION_FRAMES;
			Player.speed = Player.speed + 4;
		}

		@Override
	public void update() {
		if (iv > 1) {
			iv = iv - 1;
		} else if (iv == 1){
			iv = 0;
			Player.speed -= 4;
		}
	}
}


