package graphics;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import logic.Game;
import logic.HighscoreManager;

public class GameWindow extends JFrame implements ActionListener{
	
	/**
	 * The window of the game.
	 * Handles showing of panels, buttons and labels.
	 * Adds actionlisteners.
	 * Contains the panel with cards that we use for showing the different "states" 
	 * 
	 */
	private static final long serialVersionUID = 8200281240189287626L;
	
	private final GamePanel gPanel;
	private Game game;
	private final JLabel scoreLabel;
	private final JLabel lifeLabel;
	private final MenuPanel mPanel = new MenuPanel();
	private final HighscoreManager hm = new HighscoreManager();
	private final HighScorePanel hsPanel = new HighScorePanel(hm);
	private final HelpPanel hpPanel = new HelpPanel(this);
	private final JPanel cards = new JPanel(new CardLayout());

	
	
	
	public GameWindow() {
		gPanel = new GamePanel();

		this.game = new Game(this);
		gPanel.setGame(game);

		JButton backBtn = new JButton("Back");
		JButton hsBackBtn = new JButton("Back");
		scoreLabel = new JLabel("Score: " + game.getScore());
		lifeLabel = new JLabel("Lives left: " + game.getPlayer().getLife());

		setSize(800,600);
		setResizable(false);
		
		
		mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
		JLabel meny = new JLabel("Menu");
		meny.setAlignmentX(Component.CENTER_ALIGNMENT);
		meny.setFont(new Font("Courier New", Font.PLAIN, 30));
		
		JButton newGame = new JButton("New Game");
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton highScore = new JButton("HighScore");
		highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton help = new JButton("Help");
		help.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		mPanel.add(meny);
		mPanel.add(newGame);
		mPanel.add(highScore);
		mPanel.add(help);
		
		newGame.addActionListener(this);
		highScore.addActionListener(this);
		help.addActionListener(this);


		MenuPanel m2 = new MenuPanel();
		m2.add(scoreLabel);
		m2.add(backBtn);
		m2.add(lifeLabel);


		backBtn.addActionListener(this);


		hsPanel.add(hsBackBtn);
		hsBackBtn.addActionListener(this);

		gPanel.add(m2, BorderLayout.PAGE_END);
		cards.add(mPanel, "mPanel");
		cards.add(hsPanel, "Highscores");
		cards.add(gPanel, "Gametime");
		cards.add(hpPanel, "Help");
		
		this.add(cards);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Timer gameTimer = new Timer(16, e -> {
			if (gPanel.hasFocus()) {
				getScoreLabel().setText("Score: " + game.getScore());
				lifeLabel.setText("Lives left: " + game.getPlayer().getLife());
				game.update();
			}

		});
		gameTimer.start();

	}
	private JLabel getScoreLabel() {
		return scoreLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 	String action = e.getActionCommand();
		switch (action) {
			case "New Game": {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "Gametime");
				this.game = new Game(this);
				gPanel.setGame(game);
				gPanel.requestFocusInWindow();

				break;
			}
			case "HighScore": {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "Highscores");
				hsPanel.requestFocusInWindow();

				break;
			}
			case "Help": {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "Help");
				hpPanel.requestFocusInWindow();
				break;
			}
			case "Back":
				menuBack();
				break;
		}
	    }
	
	public void menuBack() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "mPanel");
        mPanel.requestFocusInWindow();
	}


	public HighscoreManager getHm() {
		return hm;
	}
}

