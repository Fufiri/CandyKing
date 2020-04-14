package logic;

public class Highscore {

	/**
	 * Contains the data needed to create a highscore
	 * 
	 */
	private final int highScore;
	private final String name;
	
	public Highscore(String name, int highScore) {
		this.highScore = highScore;
		this.name = name;
	}

	public int getHighScore() {
		return highScore;
	}

	public String getName() {
		return name;
	}

}



