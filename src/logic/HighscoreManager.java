package logic;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class HighscoreManager {
	
	/**
	 * Manages writing and reading the highscore file
	 * adds highscore to the list, to add to file
	 */

    private final ArrayList<Highscore> highscoreArrayList = new ArrayList<>();

    public HighscoreManager() {

	}



	private void writeHighScoreFile() {
	    try {
	        Writer fileWriter = new FileWriter(new File("HighScore.txt"), false);
	        for (int i = 0; i < 4; i++) {
	            fileWriter.write(highscoreArrayList.get(i).getName() + '/'
                        + highscoreArrayList.get(i).getHighScore() + "\r\n");
            }
	        fileWriter.close();
        }catch (IOException e) {
	        e.printStackTrace();
        }
    }


    public void readHighscoreFile() {
	    Scanner s;
	    try {
	        s = new Scanner(new File("HighScore.txt"));
	        for (int i = 0; i < 4; i++) {
                String temp;
                temp = s.nextLine();

                for (int v = 0; v < temp.length(); v++) {
                    if (temp.charAt(v) == '/') {
                        highscoreArrayList.add(new Highscore(temp.substring(0,v),
                                Integer.parseInt(temp.substring(v+1))));
                    }
                }
            }
        } catch (FileNotFoundException e) {
	        e.printStackTrace();
        }
    }

    public void addHighScore(int score) {
        for(int i =0; i <highscoreArrayList.size(); i++) {
            if (score >= highscoreArrayList.get(i).getHighScore()) {
                String playername = JOptionPane.showInputDialog("Congratulations! You got a new highscore. Enter your name (Max 8 characters): ");
                int maxLength = 8;
                if (playername.length() > maxLength) {
                    playername = playername.substring(0, maxLength);
                }
                highscoreArrayList.add(i, new Highscore(playername, score));
                writeHighScoreFile();
                break;
            }
        }
    }

    public ArrayList<Highscore> getHighscoreArrayList() {
        return highscoreArrayList;
    }

}


