package logic;

import graphics.GameWindow;
import graphics.Player;

public class Game {
	/**
	 * Stores Level parameters and which level you are on
	 * Keeps track of current score of this game
	 * Creates new player when run
	 * Contains the gameloop that runs when the gametimer starts
	 * Contains the gameOver function to add highscore when the game ends
	 */
	
	
	private final Level[] levels = {new Level(2, 5.0, 2, 10),
			new Level(4, 10, 2,10),
			new Level(6, 15, 2, 10)} ;

	private int level = 0;
	private int score = 0;
	private final Player player = new Player(this);
	private final GameWindow gw;


	public Game(GameWindow gw) {
		this.gw = gw;
	}

	private void nextLevel() {
		level++;

	}

	public Player getPlayer() {
		return player;
	}

	public Level getLevel() {
		return levels[level];
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}



	private void gameOver() {
		gw.getHm().addHighScore(score);
		gw.menuBack();
		

		
	}

	public void update() {
		player.go();
		player.checkCollision();

		player.powerUpUpdate();

		if ((player.hasEatenEnough()) && (level != 2)) {
			nextLevel();
			player.setCollectedCandies(0);
		}
		
		if (!player.isAlive()) {
			gameOver();

		}
		gw.repaint();	
	}

	
}
