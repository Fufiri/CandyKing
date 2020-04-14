package graphics;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


class HelpPanel extends JPanel {
	
	/**
	 * Shows help text, paints text and background image
	 * 
	 */
	private static final long serialVersionUID = -7547838484960356256L;
	private final ImageIcon back;


	public HelpPanel(GameWindow gw) {

		setBorder(new EmptyBorder(150, 150, 150, 150));
		setLayout(new BorderLayout(0, 0));
		JButton helpBackBtn = new JButton("Back");
		helpBackBtn.addActionListener(gw);
        JTextArea textarea = new JTextArea(
                "Press NEW GAME to start a new game. " +
                        "Walk with the arrow buttons, you get points for each candy you take. " +
                        "\r\n" +
                        "You level up when you have taken 8 different candies. " +
                        "\r\n" +
                        "The ice cream makes you faster for 7 seconds, while the pineapple makes you slower for 7 seconds" +
                        "\r\n" +
                        "The game is over once you have hit an enemy 3 times "
        );
		helpBackBtn.setHorizontalAlignment(SwingConstants.CENTER);
		textarea.setFont(new Font("Font", Font.PLAIN, 16));
		textarea.setSize(500,600);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		this.add(textarea, BorderLayout.CENTER);
		this.add(helpBackBtn,BorderLayout.PAGE_START);
		back = new ImageIcon("sprites/helpB.jpg");
		setSize(800, 600);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		back.paintIcon(this, g, 0, 0);
		
		
	}

}
