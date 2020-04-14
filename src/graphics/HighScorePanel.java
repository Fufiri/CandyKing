package graphics;

import java.awt.*;

import javax.swing.ImageIcon;

import javax.swing.JPanel;

import logic.HighscoreManager;

class HighScorePanel extends JPanel {
	
	/**
	 * 
	 * Shows highscores
	 * Draws background image and highscore list
	 * 
	 */
	private static final long serialVersionUID = 2654285504341035258L;
	private final ImageIcon back;
	private final HighscoreManager hm;
	
	public HighScorePanel(HighscoreManager hm) {
		this.hm=hm;
		hm.readHighscoreFile();
		back = new ImageIcon("sprites/highscoreb.jpg");
		setSize(800, 600);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		back.paintIcon(this, g, 0, 0);
		for (int i = 0; i < 4; i++) {
			g.setFont(new Font("CandyKing", Font.BOLD, 40));
			g.drawString(hm.getHighscoreArrayList().get(i).getName(), 250, 200+i*45);
			g.drawString(Integer.toString(hm.getHighscoreArrayList().get(i).getHighScore()), 550, 200+i*45);
		}
		
	}

}
