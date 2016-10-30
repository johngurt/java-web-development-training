package training.gamelessormore;

import java.util.Random;

/**
 * Created by gurt on 10/30/16.
 */
public class Model {

    private final int MIN_RAND;
    private final int MAX_RAND;

    private int currentMinNumber;
    private int currentMaxNumber;

    private int unknownNumber;

    Random rand = new Random();

    Model() {
        MIN_RAND = 0;
        MAX_RAND = 100;
        currentMinNumber = MIN_RAND;
        currentMaxNumber = MAX_RAND;
        unknownNumber = rand.nextInt(101);
    }

    Model(int MIN_RAND, int MAX_RAND) {
        this.MIN_RAND = MIN_RAND;
        this.MAX_RAND = MAX_RAND;
        currentMinNumber = MIN_RAND;
        currentMaxNumber = MAX_RAND;
        unknownNumber = rand.nextInt(MAX_RAND - MIN_RAND + 1) + MIN_RAND;
    }

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
}
