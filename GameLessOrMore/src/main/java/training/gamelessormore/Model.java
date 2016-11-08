package training.gamelessormore;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Hurt Yevhenii
 */
public class Model {

    /**
     * initial left boundary, unknown number is more than it
     */
    private final int MIN_RAND;
    /**
     * initial right boundary, unknown number is less than it
     */
    private final int MAX_RAND;

    /**
     * current left boundary, unknown number is always more than it,
     * in the beginning of program it is equal to MIN_RAND
     * and can changes during execution of program
     */
    private int currentMinNumber;
    /**
     * current right boundary, unknown number is always less than it,
     * in the beginning of program it is equal to MAX_RAND
     * and can changes during execution of program
     */
    private int currentMaxNumber;
    /**
     * Number that player tries to guess.
     * It always more than MIN_RAND and currentMinNumber
     * and less than MAX_RAND and currentMaxNumber
     */
    private int unknownNumber;
    /**
     * Last number that player enters
     */
    private int currentNumber;

    /**
     * list of numbers that players enters
     */
    private ArrayList<Integer> playersAttempts = new ArrayList<Integer>();

    Random rand = new Random();


    /**
     * Default constructor
     */
    Model() {
        this.MIN_RAND = 0;
        this.MAX_RAND = 100;
        currentMinNumber = MIN_RAND;
        currentMaxNumber = MAX_RAND;
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
     * Method that checks is value that player inputs in correct boundary or not
     * @param currentNumber value that player inputs
     * @return boolean value that is true when number that players enters is not in correct interval
     */
    public boolean isOutOfBoundary(int currentNumber) {
        return (currentNumber > currentMaxNumber) || (currentNumber < currentMinNumber);
    }

    /**
     * Method sets number that players tries to guess
     */
    public void setUnknownNumber() {
        this.unknownNumber = rand.nextInt(MAX_RAND - MIN_RAND - 1) + 1;
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
