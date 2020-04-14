package graphics;





import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class MenuPanel extends JPanel{
	
	/**
	 * Draws out the background for the menupanel
	 * 
	 */
	private static final long serialVersionUID = -5951715919501812427L;
	
	private final ImageIcon back;

	
	public MenuPanel() {

		back = new ImageIcon("sprites/candyb.png");
		setSize(800, 600);
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		back.paintIcon(this, g, 0, 0);
		
		
	}


	}
		
	
	




