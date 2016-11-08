package training.gamelessormore;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gurt on 10/30/16.
 */
public class Model {

    /**
     * initial interval [MIN_RAND, MAX_RAND]
     */
    private final int MIN_RAND;
    private final int MAX_RAND;

    /**
     * variables
     */
    //ends of interval that changes when you play
    private int currentMinNumber;
    private int currentMaxNumber;
    //number that program makes
    private int unknownNumber;
    //number that player enters
    private int currentNumber;

    /**
     * list of numbers that players enters
     */
    private ArrayList<Integer> playersAttempts = new ArrayList<Integer>();

    Random rand = new Random();

    /**
     * default constructor
     */
    Model() {
        MIN_RAND = 0;
        MAX_RAND = 100;
        currentMinNumber = MIN_RAND;
        currentMaxNumber = MAX_RAND;
        unknownNumber = rand.nextInt(101);
    }

    /**
     * constructor with specified boundaries
     * @param MIN_RAND left boundary
     * @param MAX_RAND right boundary
     */
    Model(int MIN_RAND, int MAX_RAND) {
        this.MIN_RAND = MIN_RAND;
        this.MAX_RAND = MAX_RAND;
        currentMinNumber = MIN_RAND;
        currentMaxNumber = MAX_RAND;
        unknownNumber = rand.nextInt(MAX_RAND - MIN_RAND + 1) + MIN_RAND;
    }

    /**
     * method that return true if player guesses unknown number
     * @return boolean value that is true when player guesses unknown number
     */
    public boolean playerWin() {
        return currentNumber == unknownNumber;
    }

    /**
     * method that return true if unknown number is greater than player's number
     * @return boolean value that is true when unknown number is greater than number that player enters
     */
    public boolean unknownNumberMoreThanCurrent() {
        return unknownNumber > currentNumber;
    }

    /**
     *
     * @param currentNumber value that player inputs
     * @return boolean value that is true when number that players enters is not in correct interval
     */
    public boolean isOutOfBoundary(int currentNumber) {
        return (currentNumber > currentMaxNumber) || (currentNumber < currentMinNumber);
    }

    /**
     * getters and setters
     */

    public int getMAX_RAND() {
        return MAX_RAND;
    }

    public int getMIN_RAND() {
        return MIN_RAND;
    }

    public int getCurrentMaxNumber() {
        return currentMaxNumber;
    }

    public int getCurrentMinNumber() {
        return currentMinNumber;
    }

    public void setCurrentMaxNumber(int currentMaxNumber) {
        this.currentMaxNumber = currentMaxNumber;
    }

    public void setCurrentMinNumber(int currentMinNumber) {
        this.currentMinNumber = currentMinNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getUnknownNumber() {
        return unknownNumber;
    }

    /**
     * method that save players attempts
     */
    public void addPlayersAttempt() {
        playersAttempts.add(currentNumber);
    }

    public String printPlayersAttempts() {
        return playersAttempts.toString();
    }

    public int numberOfAttempts() {
        return playersAttempts.size();
    }
}
