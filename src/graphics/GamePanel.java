package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import logic.Game;

class GamePanel extends JPanel {

	/**
	* 
	* Panel where each level is drawn out, 
	* enemies, candies, powerups and player
	*/
	private static final long serialVersionUID = 7144085121692279402L;

	
	
	public void setGame(Game game) {
		this.game = game;
		

		// unbind the old keyAdapter, replace it and bind the new one
		this.removeKeyListener(this.keyAdapter);
		this.keyAdapter=new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				game.getPlayer().keyPressed(e);

			}

			public void keyReleased(KeyEvent e) {
				game.getPlayer().keyReleased(e);
			}
		};
		this.addKeyListener(this.keyAdapter);
	}

	private Game game;

	//add and initial keyAdapter that does nothing because we dont know the player yet
	private KeyAdapter keyAdapter = new KeyAdapter(){
		public void keyPressed (KeyEvent e){}
		public void keyReleased (KeyEvent e){}
	};

	public GamePanel() {



		setLayout(new BorderLayout());
		this.isRequestFocusEnabled();
		this.setVisible(true);
		this.setFocusable(true);
		
		

	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.drawRect(0, 0, 795, 530);

		for (Enemy enemies : game.getLevel().geteArray()) {
			enemies.paintYourself(g);
		}

		for (SuperCandy sCandy : game.getLevel().getsArray()) {
			sCandy.paintYourself(g);
		}

		for (RegCandy rCandy : game.getLevel().getcArray()) {
			rCandy.paintYourself(g);
		}

		for (PowerUp pu : game.getLevel().getPowerups()) {
			pu.paintYourself(g);
		}
		
		game.getPlayer().paintYourself(g);
		
	}

}
