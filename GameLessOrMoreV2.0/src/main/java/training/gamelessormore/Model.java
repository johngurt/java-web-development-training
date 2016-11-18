package training.gamelessormore;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents business logic of program
 *
 * @author Hurt Yevhenii
 */
public class Model {

    /**
     * initial left boundary, unknown number is more than it
     */
    private final int initialMin;
    /**
     * initial right boundary, unknown number is less than it
     */
    private final int initialMax;

    /**
     * current left boundary, unknown number is always more than it,
     * in the beginning of program it is equal to initialMin
     * and can changes during execution of program
     */
    private int currentMinNumber;
    /**
     * current right boundary, unknown number is always less than it,
     * in the beginning of program it is equal to initialMax
     * and can changes during execution of program
     */
    private int currentMaxNumber;
    /**
     * Number that player tries to guess.
     * It always more than initialMin and currentMinNumber
     * and less than initialMax and currentMaxNumber
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

    Model(int initialMin, int initialMax) {
        this.initialMin = initialMin;
        this.currentMinNumber = initialMin;
        this.initialMax = initialMax;
        this.currentMaxNumber = initialMax;
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
        return (currentNumber >= currentMaxNumber) || (currentNumber <= currentMinNumber);
    }

    /**
     * Method sets number that players tries to guess
     */
    public void setUnknownNumber() {
        this.unknownNumber = rand.nextInt(initialMax - initialMin - 1) + initialMin + 1;
    }

    /**
     * getters and setters
     */
    public int getInitialMax() {
        return initialMax;
    }

    public int getInitialMin() {
        return initialMin;
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
