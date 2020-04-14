package logic;

import java.util.ArrayList;

import graphics.Enemy;
import graphics.IceCream;
import graphics.Pineapple;
import graphics.PowerUp;
import graphics.RegCandy;
import graphics.SuperCandy;

public class Level {

	/**
	 * Contains the data needed to create a level
	 * Adds to arraylists, that are used to draw each thing out
	 */
	
    private final ArrayList<Enemy> eArray = new ArrayList<>();
    private final ArrayList<SuperCandy> sArray = new ArrayList<>();
    private final ArrayList<RegCandy> cArray = new ArrayList<>();
    private final ArrayList<PowerUp> powerups = new ArrayList<>();
    private final ArrayList<PowerUp> allPowerups;



    @SuppressWarnings("unchecked")
	public Level(int enemyNr, double eSpeed, int sCandyNr, int candyNr) {

        powerups.add(new Pineapple());
        powerups.add(new IceCream());
       
        allPowerups=(ArrayList<PowerUp>)powerups.clone();

        for (int i = 0; i < enemyNr; i++) {
            eArray.add(new Enemy());
        }

        for (Enemy enemies : eArray) {
            enemies.setSpeed(eSpeed);
        }

        for (int i = 0; i < sCandyNr; i++) {
            sArray.add(new SuperCandy(2000));
        }

        for (int i = 0; i < candyNr; i++) {
            cArray.add(new RegCandy(1000));
        }
    }

    public ArrayList<Enemy> geteArray() {
        return eArray;
    }

    public ArrayList<SuperCandy> getsArray() {
        return sArray;
    }

    public ArrayList<RegCandy> getcArray() {
        return cArray;
    }

    public ArrayList<PowerUp> getPowerups() {
        return powerups;
    }

    public ArrayList<PowerUp> getAllPowerups() {
        return allPowerups;
    }

}
